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

        if (!body.getUrl().contains("instagram")) {
            throw new Exception("Gerçek instagram bu değil!");
        }

        if (InstazamUtils.isValidInstagramLink(body.getUrl())) {

        }

        Recognition recognition = Recognition.newEntry(body.getType(), body.getUrl());

        recognitionService.save(recognition);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
