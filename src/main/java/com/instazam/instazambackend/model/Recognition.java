package com.instazam.instazambackend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import org.springframework.data.annotation.Id;

/**
 * @author Onur Yurteri
 */
@Getter
@Setter
@ToString
@Builder
public class Recognition {

    @Id
    String id;
    SourceType sourceType;
    String sourceUrl;
    String videoUrl;
    String convertedUrl;
    RecognitionStatus status;
    RecognitionResult result;

    //TODO: add result?

    public static Recognition newEntry(SourceType type, String url) {
        return Recognition.builder() //
                .sourceType(type) //
                .sourceUrl(url) //
                .status(RecognitionStatus.WAITING) //
                .build();
    }

}
