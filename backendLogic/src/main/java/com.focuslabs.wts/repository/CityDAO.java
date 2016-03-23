package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDAO extends JpaRepository<City, Long>{

}
