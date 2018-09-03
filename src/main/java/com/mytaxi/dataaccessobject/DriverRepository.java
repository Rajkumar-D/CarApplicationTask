package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;

/**
 * Database Access Object for driver table.
 * <p/>
 */
@Repository
public interface DriverRepository extends CrudRepository<DriverDO, Long>, DriverRepositoryCustom
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);

}
