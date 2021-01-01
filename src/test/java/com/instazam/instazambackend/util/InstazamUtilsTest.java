package com.instazam.instazambackend.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstazamUtilsTest {

    @Test
    public void getInstagramPostId() {
        String url = "https://www.instagram.com/p/CGbOaGEpkiL/";
        String out = InstazamUtils.getInstagramPostId(url);

        assertEquals(out, "CGbOaGEpkiL");
    }

}