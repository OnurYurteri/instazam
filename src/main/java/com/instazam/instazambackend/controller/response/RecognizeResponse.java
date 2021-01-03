package com.instazam.instazambackend.controller.response;

import com.instazam.instazambackend.model.RecognitionStatus;
import lombok.Data;

/**
 * @author Onur Yurteri
 */
@Data
public class RecognizeResponse {

    String id;
    RecognitionStatus status;

}
