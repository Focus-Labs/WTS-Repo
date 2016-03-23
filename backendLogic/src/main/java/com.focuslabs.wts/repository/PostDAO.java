package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<Post, Long>{

}
