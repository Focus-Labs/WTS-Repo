package com.focuslabs.wts.vo;

import java.io.Serializable;

/**
 * Created by baba on 6/13/2016.
 */
public class OrganizationVo implements Serializable {

    private int numberOfOrganizations;

    public OrganizationVo() {
    }

    public OrganizationVo(int numberOfOrganizations) {
        this.numberOfOrganizations = numberOfOrganizations;
    }

    public int getNumberOfOrganizations() {
        return numberOfOrganizations;
    }

    public void setNumberOfOrganizations(int numberOfOrganizations) {
        this.numberOfOrganizations = numberOfOrganizations;
    }
}
