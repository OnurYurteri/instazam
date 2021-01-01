package com.instazam.instazambackend.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class InstagramServiceImplTest {

    @Mock
    InstagramServiceImpl instagramService = new InstagramServiceImpl();

    @Test
    public void getVideoUrlFromLink(){
        String url = "https://www.instagram.com/p/CGbOaGEpkiL/";
        instagramService.getVideoUrlFromLink(url);
    }

}