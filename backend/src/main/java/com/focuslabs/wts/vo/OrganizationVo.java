package com.focuslabs.wts.vo;

import java.io.Serializable;

/**
 * Created by baba on 6/13/2016.
 */
public class OrganizationVo implements Serializable {

    private long numberOfOrganizations;

    public OrganizationVo() {
    }

    public OrganizationVo(long numberOfOrganizations) {
        this.numberOfOrganizations = numberOfOrganizations;
    }

    public long getNumberOfOrganizations() {
        return numberOfOrganizations;
    }

    public void setNumberOfOrganizations(long numberOfOrganizations) {
        this.numberOfOrganizations = numberOfOrganizations;
    }
}
