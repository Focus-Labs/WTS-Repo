package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.vo.UserVo;

import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public interface IUserService {

    Long getNumberOfUsers();
    List<User> getAllUsers();
    User getUser(String userId);
    User updateUser(UserVo user);

}
