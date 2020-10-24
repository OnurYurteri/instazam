package com.instazam.instazambackend.service;

import com.instazam.instazambackend.model.Recognition;
import org.springframework.stereotype.Service;

/**
 * @author Onur Yurteri
 */
@Service
public interface RecognitionService {

    void save(Recognition recognition);

}
