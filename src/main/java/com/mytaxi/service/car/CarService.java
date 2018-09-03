package com.mytaxi.service.car;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.ManufacturerDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * Car service interface.
 * @author rajkumar
 *
 */
@Service
public interface CarService
{
    CarDO find(Long carId) throws EntityNotFoundException;

    CarDO save(CarDO CarDO) throws ConstraintsViolationException,EntityNotFoundException;
    
    void delete(Long carId) throws EntityNotFoundException;
    
    List<CarDO> find(OnlineStatus onlineStatus);
    
    CarDO findByName(String name) throws EntityNotFoundException;
    
    ManufacturerDO findManufacturer(Long manId) throws EntityNotFoundException;
    
}
