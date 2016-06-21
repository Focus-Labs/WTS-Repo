package com.focuslabs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.focuslabs.wts.MainApp;
import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.entity.Organization;
import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.repository.LocationRepository;
import com.focuslabs.wts.repository.OrganizationRepository;
import com.focuslabs.wts.repository.UserRepository;
import com.focuslabs.wts.vo.LocationVo;
import com.focuslabs.wts.vo.OrganizationVo;
import com.focuslabs.wts.vo.UserVo;
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
public class OrganizationControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LocationRepository locationRepository;
    private Organization organization;
    private Location location;
    private User admin;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        organizationRepository.deleteAll();
        userRepository.deleteAll();
        locationRepository.deleteAll();
        location = locationRepository.save(new Location("Addis Ababa"));
        admin = userRepository.save(new User("email@gmail.com","password","firstName","lastName","about Me","education level"));
        organization = organizationRepository.save(new Organization("organization","homepage.com",admin,location));

    }

    @Test
    public void getNumberOfOrganizations() throws Exception {
        mockMvc.perform(get("/organizations/numberOfOrganizations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.numberOfOrganizations",is("1")));
    }

    @Test
    public void getAllOrganizations() throws Exception {
        mockMvc.perform(get("/organizations/allOrganizations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$[0].name",is("organization")))
                .andExpect(jsonPath("$[0].homePage", is("homepage.com")));
    }

    @Test
    public void getOrganization() throws Exception {
        mockMvc.perform(get("/organizations/organization?organizationId=" + organization.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(organization.getId())))
                .andExpect(jsonPath("$.name",is("organization")))
                .andExpect(jsonPath("$.homePage", is("homepage.com")));
    }

    @Test
    public void updateOrganization() throws Exception {
        OrganizationVo o = new OrganizationVo(organization.getId(),"Xhub","",null,null);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(o);
        mockMvc.perform(put("/organizations/update").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(organization.getId())))
                .andExpect(jsonPath("$.name",is("Xhub")))
                .andExpect(jsonPath("$.homePage", is("homepage.com")));
    }

    @Test
    public void createOrganization() throws Exception {
        organizationRepository.deleteAll();
        userRepository.deleteAll();
        locationRepository.deleteAll();
        location = locationRepository.save(new Location("Addis Ababa"));
        admin = userRepository.save(new User("email@gmail.com","password","firstName","lastName","about Me","education level"));
        OrganizationVo o = new OrganizationVo("organization","homepage.com",new LocationVo(location.getId(),location.getName()),new UserVo(admin.getId(),"","","","","",""));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(o);
        mockMvc.perform(post("/organizations/create").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name", is("organization")))
                .andExpect(jsonPath("$.homePage", is("homepage.com")))
                .andExpect(jsonPath("$.admin.id", is(admin.getId())))
                .andExpect(jsonPath("$.admin.email", is("email@gmail.com")))
                .andExpect(jsonPath("$.admin.password", is("password")))
                .andExpect(jsonPath("$.admin.firstName", is("firstName")))
                .andExpect(jsonPath("$.admin.lastName", is("lastName")))
                .andExpect(jsonPath("$.admin.aboutMe", is("about Me")))
                .andExpect(jsonPath("$.admin.education", is("education level")))
                .andExpect(jsonPath("$.location.id",is(location.getId())))
                .andExpect(jsonPath("$.location.name", is("Addis Ababa")));
    }


}
