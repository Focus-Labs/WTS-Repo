package main.java.com.focuslabs.wts.repository;

import main.java.com.focuslabs.wts.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDAO extends JpaRepository<Notification, Long>{

}
