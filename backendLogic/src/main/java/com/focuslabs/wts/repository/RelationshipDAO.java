package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by aman on 3/23/16.
 */
@Repository
public interface RelationshipDAO extends JpaRepository<Relationship, Long>{

}
