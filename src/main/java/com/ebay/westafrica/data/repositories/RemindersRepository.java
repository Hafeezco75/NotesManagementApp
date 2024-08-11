package com.ebay.westafrica.data.repositories;

import com.ebay.westafrica.data.models.Reminders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemindersRepository extends MongoRepository<Reminders, String> {

}
