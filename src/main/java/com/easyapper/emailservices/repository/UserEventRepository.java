package com.easyapper.emailservices.repository;

import com.easyapper.emailservices.model.UserEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserEventRepository extends MongoRepository<UserEvent, String > {

        UserEvent findByEmail(String emailId);

        List<UserEvent> findAllByIsActive(Boolean isActive);
}
