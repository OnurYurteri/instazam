package com.instazam.instazambackend.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Onur Yurteri
 */
public class InstazamUtils {

    public static boolean isValidInstagramLink(String url) {
        if (!url.contains("instagram")) {
            return false;
        }

        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            return false;
        }

        // TODO: validate correct url by path count, also consider short urls and additional path for tracking???
        //List<String> paths = Arrays.asList(uri.getPath().split("/"));

        return true;
    }

    public static String getInstagramPostId(String url) {
        if (!url.contains("instagram")) {
            return null;
        }

        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            return null;
        }

        List<String> paths = Arrays.asList(uri.getPath().split("/"));

        return paths.get(2);
    }

}
