package com.focuslabs.wts.vo;

import com.focuslabs.wts.entity.Traveler;

/**
 * Created by Samson Tekleab on 3/24/2016.
 */
public class TravelerVO implements SearchResultVO{

    private Traveler traveler;

    public TravelerVO(Traveler traveler) {
        this.traveler = traveler;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }
}
