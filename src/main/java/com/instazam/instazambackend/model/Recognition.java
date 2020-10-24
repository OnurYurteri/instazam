package com.instazam.instazambackend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Onur Yurteri
 */
@Getter
@Setter
@ToString
@Builder
public class Recognition {

    String id;
    SourceType sourceType;
    String sourceUrl;
    RecognitionStatus status;

    //TODO: add result?

    public static Recognition newEntry(SourceType type, String url) {
        return Recognition.builder() //
                .sourceType(type) //
                .sourceUrl(url) //
                .status(RecognitionStatus.WAITING) //
                .build();
    }

}
