package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipDAO extends JpaRepository<Relationship, Long>{

}