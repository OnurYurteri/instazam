package com.instazam.instazambackend.model;

import lombok.Data;

import java.util.Map;

/**
 * @author Onur Yurteri
 */
@Data
public class RecognitionResult {

    Map<String, Object> metadata;
    Map<String, Object> apple;
    Map<String, Object> spotify;

}
