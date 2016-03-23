package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.PostMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMediaDAO extends JpaRepository<PostMedia, Long>{

}
