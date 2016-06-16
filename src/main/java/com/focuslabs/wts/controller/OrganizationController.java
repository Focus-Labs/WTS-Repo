package com.focuslabs.wts.controller;

import com.focuslabs.wts.entity.Organization;
import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.service.IOrganizationService;
import com.focuslabs.wts.vo.EventVo;
import com.focuslabs.wts.vo.LocationVo;
import com.focuslabs.wts.vo.OrganizationVo;
import com.focuslabs.wts.vo.UserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
@CrossOrigin
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    IOrganizationService organizationService;

    @RequestMapping(value = "/numberOfOrganizations",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "number of organizations", notes = "return number of organizations")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = Long.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> numberOfOrganiztions() {
        try {
            return new ResponseEntity<Object>(organizationService.getNumberOfOrganizations(), HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/allOrganizations",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get all organizations", notes = "return all organizations")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = OrganizationVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    public ResponseEntity<?> getAllOrganizations() {
        try {
            List<OrganizationVo> organizations = new ArrayList<>();
            organizationService.getAllOrganizations().stream().forEach(o -> {
                User u = o.getAdmin();
                UserVo admin = new UserVo(u.getId(),u.getEmail(),u.getPassword(),u.getFirstName(),u.getLastName(),u.getAboutMe(),u.getEducation());
                LocationVo location = new LocationVo(o.getAddress().getId(),o.getAddress().getName());
                OrganizationVo organization = new OrganizationVo(o.getId(),o.getName(),o.getHomepage(),location,admin);
                o.getMembers().stream().forEach(m -> {
                    organization.getMembers().add(new UserVo(m.getId(), m.getEmail(), m.getPassword(), m.getFirstName(), m.getLastName(), m.getAboutMe(), m.getEducation()));
                });
                o.getFollowers().stream().forEach(f -> {
                    organization.getFollowers().add(new UserVo(f.getId(), f.getEmail(), f.getPassword(), f.getFirstName(), f.getLastName(), f.getAboutMe(), f.getEducation()));
                });
                o.getEvents().stream().forEach(e -> {
                    organization.getEvents().add(new EventVo(e.getId(),e.getTitle(),e.getDate(),e.getLength(),e.getShort_desc(),e.getLong_desc(),e.getWhere_about(),e.getEvent_icon_Location(),e.getEvent_pic_Location()));
                });
                organizations.add(organization);
            });
            return new ResponseEntity<Object>(organizations, HttpStatus.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
        }
    }

    @RequestMapping(value = "/organization",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "get organization with specified organization id", notes = "return the specified organizationId")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = OrganizationVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @ApiImplicitParam(name = "organizationId", required = true, dataType = "string", paramType = "query", value = "unique organization Id")
    public ResponseEntity<?> getOrganization(@RequestParam(value = "organizationId", required = true) String organizationId) {
        if(organizationId != null && !organizationId.isEmpty()) {
            try {
                Organization o = organizationService.getOrganization(organizationId);
                LocationVo location = new LocationVo(o.getAddress().getId(),o.getAddress().getName());
                User u = o.getAdmin();
                UserVo admin = new UserVo(u.getId(),u.getEmail(),u.getPassword(),u.getFirstName(),u.getLastName(),u.getAboutMe(),u.getEducation());
                OrganizationVo organization = new OrganizationVo(o.getId(),o.getName(),o.getHomepage(),location,admin);
                return new ResponseEntity<Object>(organization, HttpStatus.valueOf(200));
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Object>(e.getMessage(), HttpStatus.valueOf(500));
            }
        }
        return new ResponseEntity<Object>("Parameter Error", HttpStatus.valueOf(500));
    }

}
