package com.instazam.instazambackend.dao;

import com.instazam.instazambackend.model.Recognition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Onur Yurteri
 */
@Repository
public interface RecognitionDao extends MongoRepository<Recognition, String> {

}
