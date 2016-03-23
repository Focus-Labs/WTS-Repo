package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.WhereAbout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhereAboutDAO extends JpaRepository<WhereAbout, Long>{

}
