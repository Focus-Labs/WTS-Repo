package com.focuslabs.wts.controller;

import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.service.IUserService;
import com.focuslabs.wts.vo.EventVo;
import com.focuslabs.wts.vo.LocationVo;
import com.focuslabs.wts.vo.OrganizationVo;
import com.focuslabs.wts.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 4/3/2016.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "/numberOfUsers", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "number of users", notes = "return number of users")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> numberOfUsers() {
        try {
            return new ResponseEntity<Object>("{\"numberOfUsers\" : \"" + userService.getNumberOfUsers() + "\"}", HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/allUsers",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get all users", notes = "return all users")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = UserVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserVo> users = new ArrayList<>();
            userService.getAllUsers().stream().forEach(u -> {
                UserVo user = new UserVo(u.getId(), u.getEmail(), u.getPassword(), u.getFirstName(), u.getLastName(), u.getAboutMe(), u.getEducation());
                u.getEvents().stream().forEach(e -> {
                    user.getEvents().add(new EventVo(e.getId(), e.getTitle(), e.getDate(),e.getLength(), e.getShort_desc(), e.getLong_desc(), e.getWhere_about(), e.getEvent_icon_Location(), e.getEvent_pic_Location()));
                });
                u.getOrganizations().stream().forEach(o -> {
                    UserVo admin = new UserVo(o.getAdmin().getId(), o.getAdmin().getEmail(), o.getAdmin().getPassword(), o.getAdmin().getFirstName(), o.getAdmin().getLastName(), o.getAdmin().getAboutMe(), o.getAdmin().getEducation());
                    LocationVo location = new LocationVo(o.getAddress().getId(), o.getAddress().getName());
                    user.getOrganizations().add(new OrganizationVo(o.getId(), o.getName(), o.getHomepage(), location, admin));
                });
                users.add(user);
            });
            return new ResponseEntity<Object>(users, HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get user with specified user id", notes = "return the specified user")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = UserVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @ApiImplicitParam(name = "userId", required = true, dataType = "string", paramType = "query", value = "unique user Id")
    public ResponseEntity<?> getUser(@RequestParam(value = "userId", required = true) String userId) {
        if(userId != null && !userId.isEmpty()) {
            try {
                User u = userService.getUser(userId);
                UserVo user = new UserVo(u.getId(),u.getEmail(),u.getPassword(),u.getFirstName(),u.getLastName(),u.getAboutMe(),u.getEducation());
                return new ResponseEntity<Object>(user, HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = MediaType.ALL_VALUE)
    @ResponseBody
    @ApiOperation(value = "update user", notes = "return the modified user")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = UserVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> updateUser(@RequestBody UserVo user) {
        if(user != null) {
            try {
                User u = userService.updateUser(user);
                UserVo user1 = new UserVo(u.getId(),u.getEmail(),u.getPassword(),u.getFirstName(),u.getLastName(),u.getAboutMe(),u.getEducation());
                return new ResponseEntity<Object>(user1,HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }



}
