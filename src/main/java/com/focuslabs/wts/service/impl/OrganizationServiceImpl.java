package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.entity.Organization;
import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.repository.LocationRepository;
import com.focuslabs.wts.repository.OrganizationRepository;
import com.focuslabs.wts.repository.UserRepository;
import com.focuslabs.wts.service.IOrganizationService;
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
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Long getNumberOfOrganizations() {
        return organizationRepository.count();
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganization(String organizationId) {
        return organizationRepository.findOne(organizationId);
    }

    @Override
    public Organization create(OrganizationVo o) throws Exception{
        if(o.getAdmin() != null) {
            if(o.getLocation() != null) {
                User user = userRepository.findOne(o.getAdmin().getId());
                Location location = locationRepository.findOne(o.getLocation().getId());
                if(user != null) {
                    if(location != null) {
                        return organizationRepository.save(new Organization(o.getName(),o.getHomePage(),user,location));
                    }
                    throw new Exception("The specified location for organization '" + o.getName() + "' is not a valid location.");
                }
                throw new Exception("The specified Administrator for organization '" + o.getName() + "' is not a valid user.");
            }
            throw new Exception("Location is not set for organization '" + o.getName() + "'.");
        }
        throw new Exception("Administrator is not specified for organization '" + o.getName() + "'.");
    }

    @Override
    public Organization update(OrganizationVo o) {
        Organization organization = organizationRepository.findOne(o.getId());
        if(organization != null) {
            organization.setHomepage((o.getHomePage() != null && !o.getHomePage().isEmpty()) ? o.getHomePage() : organization.getHomepage());
            organization.setName((o.getName() != null && !o.getName().isEmpty()) ? o.getName() : organization.getName());
            return organizationRepository.save(organization);
        }
        return null;
    }

}
