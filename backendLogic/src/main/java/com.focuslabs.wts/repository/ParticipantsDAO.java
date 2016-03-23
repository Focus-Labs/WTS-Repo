package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantsDAO extends JpaRepository<Participants, Long>{

}
