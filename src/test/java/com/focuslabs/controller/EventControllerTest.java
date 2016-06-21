package com.focuslabs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.Event;
import com.focuslabs.wts.repository.EventRepository;
import com.focuslabs.wts.vo.EventVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by baba on 6/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
@WebAppConfiguration
public class EventControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    EventRepository eventRepository;
    private Event event;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        eventRepository.deleteAll();
        event = eventRepository.save(new Event("title",new Date(),"2 hours","short description","long description","where about","icon location","pic location"));

    }

    @Test
    public void getNumberOfEvents() throws Exception {
        mockMvc.perform(get("/events/numberOfEvents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.numberOfEvents",is("1")));
    }

    @Test
    public void getAllEvents() throws Exception {
        mockMvc.perform(get("/events/allEvents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].id",is(event.getId())))
                .andExpect(jsonPath("$[0].title",is(event.getTitle())))
//                .andExpect(jsonPath("$[0].date",is(event.getDate())))
                .andExpect(jsonPath("$[0].length", is(event.getLength())))
                .andExpect(jsonPath("$[0].shortDescription",is(event.getShort_desc())))
                .andExpect(jsonPath("$[0].longDescription",is(event.getLong_desc())))
                .andExpect(jsonPath("$[0].whereAbout",is(event.getWhere_about())))
                .andExpect(jsonPath("$[0].eventIconLocation",is(event.getEvent_icon_Location())))
                .andExpect(jsonPath("$[0].eventPictureLocation",is(event.getEvent_pic_Location())));
    }

    @Test
    public void getEvent() throws Exception {
        mockMvc.perform(get("/events/event?eventId=" + event.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(event.getId())))
                .andExpect(jsonPath("$.title", is(event.getTitle())))
//                .andExpect(jsonPath("$.date",is(event.getDate())))
                .andExpect(jsonPath("$.length", is(event.getLength())))
                .andExpect(jsonPath("$.shortDescription",is(event.getShort_desc())))
                .andExpect(jsonPath("$.longDescription",is(event.getLong_desc())))
                .andExpect(jsonPath("$.whereAbout",is(event.getWhere_about())))
                .andExpect(jsonPath("$.eventIconLocation",is(event.getEvent_icon_Location())))
                .andExpect(jsonPath("$.eventPictureLocation",is(event.getEvent_pic_Location())));
    }

    @Test
    public void updateEvent() throws Exception {
        EventVo e = new EventVo(event.getId(),"Test",new Date(),"1:30","","","where About","event icon location","");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(e);
        mockMvc.perform(put("/events/update").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id",is(event.getId())))
                .andExpect(jsonPath("$.title",is("Test")))
//                .andExpect(jsonPath("$.date",is(event.getDate())))
                .andExpect(jsonPath("$.length", is("1:30")))
                .andExpect(jsonPath("$.shortDescription",is(event.getShort_desc())))
                .andExpect(jsonPath("$.longDescription",is(event.getLong_desc())))
                .andExpect(jsonPath("$.whereAbout",is("where About")))
                .andExpect(jsonPath("$.eventIconLocation",is("event icon location")))
                .andExpect(jsonPath("$.eventPictureLocation", is(event.getEvent_pic_Location())));
    }

    @Test
    public void createEvent() throws Exception {
        eventRepository.deleteAll();
        EventVo e = new EventVo("title",new Date(),"2 hours","short description","long description","where about","icon location","pic location");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(e);
        mockMvc.perform(post("/events/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.title",is("title")))
//                .andExpect(jsonPath("$.date",is(event.getDate())))
                .andExpect(jsonPath("$.length", is("2 hours")))
                .andExpect(jsonPath("$.shortDescription",is("short description")))
                .andExpect(jsonPath("$.longDescription",is("long description")))
                .andExpect(jsonPath("$.whereAbout",is("where about")))
                .andExpect(jsonPath("$.eventIconLocation",is("icon location")))
                .andExpect(jsonPath("$.eventPictureLocation", is("pic location")));
    }


}
