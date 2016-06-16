package com.focuslabs.wts.service;

import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.vo.LocationVo;

import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public interface ILocationService {

    Long getNumberOdLocations();
    List<Location> getAllLocations();
    Location getLocation(String locationId);

}
