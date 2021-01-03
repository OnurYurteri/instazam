package com.instazam.instazambackend.controller;

import com.instazam.instazambackend.controller.request.RecognizeFromVideoRequest;
import com.instazam.instazambackend.controller.response.RecognizeResponse;
import com.instazam.instazambackend.model.EventType;
import com.instazam.instazambackend.model.Recognition;
import com.instazam.instazambackend.model.SourceType;
import com.instazam.instazambackend.service.RecognitionService;
import com.instazam.instazambackend.util.InstazamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "recognize", method = RequestMethod.POST)
    public ResponseEntity<RecognizeResponse> recognize(HttpServletRequest request, @RequestBody RecognizeFromVideoRequest body) throws Exception {
        if (SourceType.INSTAGRAM.equals(body.getType()) && !InstazamUtils.isValidInstagramLink(body.getUrl())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Url must be a valid instagram link!");
        } else if (!SourceType.INSTAGRAM.equals(body.getType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only Instagram urls are supported, yet.");
        }

        Recognition recognition = recognitionService.saveAndFireEvent(Recognition.newEntry(body.getType(), body.getUrl()), EventType.INITIAL_SAVE);
        RecognizeResponse response = new RecognizeResponse();
        response.setId(recognition.getId());
        response.setStatus(recognition.getStatus());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "fetch/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recognition> fetch(HttpServletRequest request, @PathVariable String id) {
        final Recognition recognition = recognitionService.find(id);

        return new ResponseEntity<>(recognition, HttpStatus.OK);
    }

}
