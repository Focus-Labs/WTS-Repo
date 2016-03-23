package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalDAO extends JpaRepository<Local, Long>{

}
