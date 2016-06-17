package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.entity.Organization;
import com.focuslabs.wts.entity.User;
import com.focuslabs.wts.repository.OrganizationRepository;
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
    public Organization updateOrganization(OrganizationVo o) {
        Organization organization = organizationRepository.findOne(o.getId());
        if(organization != null) {
            organization.setHomepage((o.getHomePage() != null && !o.getHomePage().isEmpty()) ? o.getHomePage() : organization.getHomepage());
            organization.setName((o.getName() != null && !o.getName().isEmpty()) ? o.getName() : organization.getName());
            return organizationRepository.save(organization);
        }
        return null;
    }

}
