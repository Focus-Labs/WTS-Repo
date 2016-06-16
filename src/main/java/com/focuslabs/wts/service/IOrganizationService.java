package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.Organization;

import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public interface IOrganizationService {

    Long getNumberOfOrganizations();
    List<Organization> getAllOrganizations();
    Organization getOrganization(String organizationId);

}
