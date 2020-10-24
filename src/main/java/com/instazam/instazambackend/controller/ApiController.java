package com.instazam.instazambackend.controller;

import com.instazam.instazambackend.controller.request.RecognizeFromVideoRequest;
import com.instazam.instazambackend.model.Recognition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Onur Yurteri
 */
@RestController
@RequestMapping(value = "1.0")
public class ApiController {

    @RequestMapping(value = "recognize-from-video", method = RequestMethod.POST)
    public String test(HttpServletRequest request, @RequestBody RecognizeFromVideoRequest body) throws Exception {

        if (!body.getUrl().contains("instagram")) {
            throw new Exception("Gerçek instagram bu değil!");
        }

        URI uri = new URI(body.getUrl());
        // TODO: validate correct url by path count, also consider short urls and additional path for tracking???
        List<String> paths = Arrays.asList(uri.getPath().split("/"));

        Recognition status = Recognition.newEntry(body.getType(), body.getUrl());

        return status.toString();
    }

}
