package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDAO extends JpaRepository<Event, Long>{

}
