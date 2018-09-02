package com.mytaxi.service.car;

import java.util.List;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * Car service interface.
 * @author rajkumar
 *
 */
public interface CarService
{
    CarDO find(Long carId) throws EntityNotFoundException;

    CarDO save(CarDO CarDO) throws ConstraintsViolationException;
    
    void delete(Long carId) throws EntityNotFoundException;
    
    List<CarDO> find(OnlineStatus onlineStatus);
    
    CarDO findByName(String name) throws EntityNotFoundException;
    
    
}
