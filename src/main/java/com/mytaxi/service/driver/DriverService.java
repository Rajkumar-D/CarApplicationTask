package com.mytaxi.service.driver;

import java.util.List;

import com.mytaxi.datatransferobject.DriverSearchDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.exception.SearchException;

public interface DriverService
{

    DriverDO find(Long driverId) throws EntityNotFoundException;


    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;


    void delete(Long driverId) throws EntityNotFoundException;


    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;


    void associateCar(long driverId, CarDO carDO) throws EntityNotFoundException, CarAlreadyInUseException;


    void dissociateCar(long driverId) throws EntityNotFoundException;


    List<DriverDO> find(OnlineStatus onlineStatus) throws EntityNotFoundException;;


    List<DriverDO> findByQuery(DriverSearchDTO carSearchDTO) throws SearchException;

}
