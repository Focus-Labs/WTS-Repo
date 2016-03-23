package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long>{

}
