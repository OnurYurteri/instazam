package com.instazam.instazambackend.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Onur Yurteri
 */
public class InstazamUtils {

    public static boolean isValidInstagramLink(String url) {
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

}
