package com.focuslabs.wts.controller;

import com.focuslabs.wts.MainApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Samson Tekleab on 4/22/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
public class EventControllerTest {

    MockMvc mockMvc;

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
    public void testInviteToEvent() throws Exception {

    }

    @Test
    public void testAcceptInvite() throws Exception {

    }

    @Test
    public void testUploadToEvent() throws Exception {

    }

    @Test
    public void testPostToEvent() throws Exception {

    }

    @Test
    public void testVote() throws Exception {

    }
}