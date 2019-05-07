package com.easyapper.emailservices.repository;

import com.easyapper.emailservices.model.Bosses;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossesRepository extends MongoRepository< Bosses, String > {
 Bosses findBy_id(ObjectId _id);
}