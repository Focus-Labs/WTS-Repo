package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by baba on 6/13/2016.
 */
@Repository
public interface EventRepository extends MongoRepository<Event,String> {
}
