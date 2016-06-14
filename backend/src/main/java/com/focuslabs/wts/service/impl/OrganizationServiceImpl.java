package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.repository.OrganizationRepository;
import com.focuslabs.wts.service.IOrganizationService;
import com.focuslabs.wts.vo.OrganizationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public OrganizationVo getNumberOfOrganizations() {
        return new OrganizationVo(organizationRepository.count());
    }
}
