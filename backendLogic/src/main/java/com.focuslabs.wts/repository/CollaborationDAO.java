package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Collaboration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborationDAO extends JpaRepository<Collaboration, Long>{

}
