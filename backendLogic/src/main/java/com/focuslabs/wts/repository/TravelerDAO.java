package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerDAO extends JpaRepository<Traveler, Long>{

}
