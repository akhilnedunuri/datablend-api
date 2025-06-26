package com.blenddata.datablendapi.repository;

import com.blenddata.datablendapi.model.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    // You can add custom query methods here if needed
}
