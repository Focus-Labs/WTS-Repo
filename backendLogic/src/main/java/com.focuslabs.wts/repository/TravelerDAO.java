package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerDAO extends JpaRepository<Traveler, Long>{

}
