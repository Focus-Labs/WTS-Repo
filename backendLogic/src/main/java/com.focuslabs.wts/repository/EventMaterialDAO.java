package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.EventMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventMaterialDAO extends JpaRepository<EventMaterial, Long>{

}
