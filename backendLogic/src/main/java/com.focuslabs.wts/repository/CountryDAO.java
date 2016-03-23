package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDAO extends JpaRepository<Country, Long>{

}
