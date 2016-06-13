package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.repository.LocationRepository;
import com.focuslabs.wts.service.ILocationService;
import com.focuslabs.wts.vo.LocationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class LocationServiceImpl implements ILocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public LocationVo getNumberOdLocations() {
        return new LocationVo(locationRepository.findAll().size());
    }
}
