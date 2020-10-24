package com.instazam.instazambackend.service;

/**
 * @author Onur Yurteri
 */
public class InstagramServiceImpl implements InstagramService {

    private final String POSTFIX = "?__a=1";

    @Override
    public String getVideoUrlFromLink(String postUrl) {
        System.out.println(postUrl);
        return postUrl;
    }

}
