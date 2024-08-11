package com.ebay.westafrica.data.repositories;

import com.ebay.westafrica.data.models.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<Notes, String> {

}
