package com.instazam.instazambackend.service;

import org.springframework.stereotype.Service;

/**
 * @author Onur Yurteri
 */
@Service
public interface InstagramService {

    String getVideoUrlFromLink(String postUrl);

}
