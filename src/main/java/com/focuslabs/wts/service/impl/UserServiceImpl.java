package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.repository.UserRepository;
import com.focuslabs.wts.service.IUserService;
import com.focuslabs.wts.vo.EventVo;
import com.focuslabs.wts.vo.LocationVo;
import com.focuslabs.wts.vo.OrganizationVo;
import com.focuslabs.wts.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Long getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User create(UserVo user) {
        return userRepository.save(new User(user.getEmail(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getAboutMe(),user.getEducation()));
    }

    @Override
    public User update(UserVo user) {
        User oldUser = userRepository.findOne(user.getId());
        if(oldUser != null) {
            oldUser.setEmail((user.getEmail() != null && !user.getEmail().isEmpty()) ? user.getEmail() : oldUser.getEmail());
            oldUser.setPassword((user.getPassword() != null && !user.getPassword().isEmpty()) ? user.getPassword() : oldUser.getPassword());
            oldUser.setFirstName((user.getFirstName() != null && !user.getFirstName().isEmpty()) ? user.getFirstName() : oldUser.getFirstName());
            oldUser.setLastName((user.getLastName() != null && !user.getLastName().isEmpty()) ? user.getLastName() : oldUser.getLastName());
            oldUser.setAboutMe((user.getAboutMe() != null && !user.getAboutMe().isEmpty()) ? user.getAboutMe() : oldUser.getAboutMe());
            oldUser.setEducation((user.getEducation() != null && !user.getEducation().isEmpty()) ? user.getEducation() : oldUser.getEducation());
            return userRepository.save(oldUser);
        }
        return null;
    }

}
