package com.easyapper.emailservices.repository;

import com.easyapper.emailservices.model.UserEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserEventRepository extends MongoRepository<UserEvent, String > {
}
