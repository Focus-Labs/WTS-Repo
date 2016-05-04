package com.focuslabs.wts.controller;

import com.focuslabs.wts.MainApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Samson Tekleab on 4/22/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
@WebAppConfiguration
@IntegrationTest
public class AccountControllerTest {

    MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));



    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateAccount() throws Exception {
        mockMvc.perform(post("/accounts/createLocalAccount/")
                .param("username", "kunta")
                .param("password", "kinte")
                .param("email", "kunta@africa.com")
                .param("companyName", "East Indian Company")
                .param("startedDate", Date.from(Instant.now()).toString())
                .param("cityId", String.valueOf(new Random(Long.MAX_VALUE).nextLong()))
                .param("address", "Downing Street")
                .param("phoneNo", "+44 123 456 6789")
                .param("logoPic", "lp"))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(contentType));

    }

    @Test
    public void testCreateAccount1() throws Exception {

    }

    @Test
    public void testAuthenticate() throws Exception {

    }

    @Test
    public void testNumOfLocals() throws Exception {

    }

    @Test
    public void testNumOfTravelers() throws Exception {

    }
}