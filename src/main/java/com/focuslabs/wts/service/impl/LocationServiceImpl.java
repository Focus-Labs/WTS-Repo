package com.focuslabs.wts.service.impl;

import com.focuslabs.wts.entity.Location;
import com.focuslabs.wts.repository.LocationRepository;
import com.focuslabs.wts.service.ILocationService;
import com.focuslabs.wts.vo.LocationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
@Service
@Transactional
public class LocationServiceImpl implements ILocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Long getNumberOdLocations() {
        return locationRepository.count();
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocation(String locationId) {
        return locationRepository.findOne(locationId);
    }

    @Override
    public Location create(LocationVo locationVo) {
        return locationRepository.save(new Location(locationVo.getName()));
    }

    @Override
    public Location update(LocationVo l) {
        Location location = locationRepository.findOne(l.getId());
        if(location != null) {
            location.setName((l.getName() != null && !l.getName().isEmpty()) ? l.getName() : location.getName());
            return locationRepository.save(location);
        }
        return null;
    }
}
