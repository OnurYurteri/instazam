package com.instazam.instazambackend.controller;

import com.instazam.instazambackend.controller.request.RecognizeFromVideoRequest;
import com.instazam.instazambackend.model.Recognition;
import com.instazam.instazambackend.service.RecognitionService;
import com.instazam.instazambackend.util.InstazamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Onur Yurteri
 */
@RestController
@RequestMapping(value = "1.0")
public class ApiController {

    @Autowired
    RecognitionService recognitionService;

    @RequestMapping(value = "recognize-from-video", method = RequestMethod.POST)
    public ResponseEntity<Recognition> test(HttpServletRequest request, @RequestBody RecognizeFromVideoRequest body) throws Exception {

        if (!InstazamUtils.isValidInstagramLink(body.getUrl())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Url must be a valid instagram link!");
        }

        Recognition recognition = recognitionService.save(Recognition.newEntry(body.getType(), body.getUrl()));

        return new ResponseEntity<>(recognition, HttpStatus.OK);
    }

}
