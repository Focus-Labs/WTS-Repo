package com.focuslabs.wts.repository;

import com.focuslabs.wts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by baba on 4/3/2016.
 */
@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.userName=?1 and a.password=?2 and a.active=?3")
    public Account findAccount(String userName,String password,boolean active);

}
