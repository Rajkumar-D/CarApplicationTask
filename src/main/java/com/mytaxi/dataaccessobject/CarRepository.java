package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;

/**
 * Database Access Object for car table.
 * <p/>
 *  @author rajkumar
 */
public interface CarRepository extends CrudRepository<CarDO, Long>
{
    List<CarDO> findByOnlineStatus(OnlineStatus onlineStatus);
    
    CarDO findByName(String name);
    
    List<CarDO> findBySeatCount(int seatCount);
}
