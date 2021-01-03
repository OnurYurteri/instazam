package com.instazam.instazambackend.model.event;

import com.instazam.instazambackend.model.EventType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author Onur Yurteri
 */
@Getter
@Setter
@ToString
public class RecognitionSavedCmd extends ApplicationEvent {

    private static final long serialVersionUid = -1L;

    private String id;
    private EventType type;

    public RecognitionSavedCmd(Object source, String id, EventType type) {
        super(source);
        this.id = id;
        this.type = type;
    }

}
