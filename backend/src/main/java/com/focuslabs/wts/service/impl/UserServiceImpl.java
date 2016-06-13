package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.repository.UserRepository;
import com.focuslabs.wts.service.IUserService;
import com.focuslabs.wts.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserVo getNumberOfUsers() {
        return new UserVo(userRepository.findAll().size());
    }
}
