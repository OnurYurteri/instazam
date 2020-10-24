package com.instazam.instazambackend.controller.request;

import com.instazam.instazambackend.model.SourceType;
import lombok.*;

/**
 * @author Onur Yurteri
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecognizeFromVideoRequest {

    SourceType type;
    String url;

}
