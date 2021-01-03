package com.instazam.instazambackend.service.client.response;

import com.instazam.instazambackend.model.RecognitionResult;
import lombok.Data;
import lombok.ToString;

/**
 * @author Onur Yurteri
 */
@Data
@ToString
public class AuddRecognizeResponse {

    String status;
    RecognitionResult result;
    Error error;

    @ToString
    @Data
    class Error {
        Integer error_code;
    }

}
