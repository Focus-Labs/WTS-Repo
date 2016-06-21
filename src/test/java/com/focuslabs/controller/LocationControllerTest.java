package com.focuslabs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.repository.LocationRepository;
import com.focuslabs.wts.vo.LocationVo;
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
public class LocationControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    LocationRepository locationRepository;
    private Location location;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        locationRepository.deleteAll();
        location = locationRepository.save(new Location("Addis Ababa"));

    }

    @Test
    public void getNumberOfLocations() throws Exception {
        mockMvc.perform(get("/locations/numberOfLocations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.numberOfLocations",is("1")));
    }

    @Test
    public void getAllLocations() throws Exception {
        mockMvc.perform(get("/locations/allLocations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].name",is(location.getName())));
    }

    @Test
    public void getLocation() throws Exception {
        mockMvc.perform(get("/locations/location?locationId=" + location.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name",is(location.getName())));
    }

    @Test
    public void updateLocation() throws Exception {
        LocationVo l = new LocationVo(location.getId(),"Adama");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(l);
        mockMvc.perform(put("/locations/update").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name",is(l.getName())));
    }

    @Test
    public void createLocation() throws Exception {
        locationRepository.deleteAll();
        LocationVo l = new LocationVo("location");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(l);
        mockMvc.perform(post("/locations/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name",is("location")));
    }

}
