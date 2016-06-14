package com.focuslabs.wts.vo;

/**
 * Created by baba on 6/13/2016.
 */
public class LocationVo {

    private long numberOfLocations;

    public LocationVo() {
    }

    public LocationVo(long numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public long getNumberOfLocation() {
        return numberOfLocations;
    }

    public void setNumberOfLocation(long numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }
}
