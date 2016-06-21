package com.focuslabs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.repository.UserRepository;
import com.focuslabs.wts.vo.UserVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by baba on 6/13/2016.
 */
@EnableWebSecurity
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
@WebAppConfiguration
public class UserControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    UserRepository userRepository;
    private User user;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
            userRepository.deleteAll();
            user = userRepository.save(new User("email@gmail.com","password","firstName","lastName","about Me","education level"));

    }

    @Test
    public void getNumberOfUsers() throws Exception {
        mockMvc.perform(get("/users/numberOfUsers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.numberOfUsers",is("1")));
    }

    @Test
    public void getAllUsers() throws Exception {
        mockMvc.perform(get("/users/allUsers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].email",is("email@gmail.com")))
                .andExpect(jsonPath("$[0].password", is("password")))
                .andExpect(jsonPath("$[0].firstName", is("firstName")))
                .andExpect(jsonPath("$[0].lastName", is("lastName")))
                .andExpect(jsonPath("$[0].aboutMe", is("about Me")))
                .andExpect(jsonPath("$[0].education", is("education level")));
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(get("/users/user?userId=" + user.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(user.getId())))
                .andExpect(jsonPath("$.email", is("email@gmail.com")))
                .andExpect(jsonPath("$.password", is("password")))
                .andExpect(jsonPath("$.firstName", is("firstName")))
                .andExpect(jsonPath("$.lastName", is("lastName")))
                .andExpect(jsonPath("$.aboutMe", is("about Me")))
                .andExpect(jsonPath("$.education", is("education level")));
    }

    @Test
    public void updateUser() throws Exception {
        UserVo u = new UserVo(user.getId(),"baba@gmail.com","","Nebyu","dawit","","");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(u);
        System.out.println(json);
        mockMvc.perform(put("/users/update").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(u.getId())))
                .andExpect(jsonPath("$.email", is("baba@gmail.com")))
                .andExpect(jsonPath("$.password", is("password")))
                .andExpect(jsonPath("$.firstName", is("Nebyu")))
                .andExpect(jsonPath("$.lastName", is("dawit")))
                .andExpect(jsonPath("$.aboutMe", is("about Me")))
                .andExpect(jsonPath("$.education", is("education level")));
    }

    @Test
    public void createUser() throws Exception {
        userRepository.deleteAll();
        UserVo u = new UserVo("email@gmail.com","password","firstName","lastName","about Me","education level");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(u);
        System.out.println(json);
        mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.email", is("email@gmail.com")))
                .andExpect(jsonPath("$.password", is("password")))
                .andExpect(jsonPath("$.firstName", is("firstName")))
                .andExpect(jsonPath("$.lastName", is("lastName")))
                .andExpect(jsonPath("$.aboutMe", is("about Me")))
                .andExpect(jsonPath("$.education", is("education level")));
    }

}