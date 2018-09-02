package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mytaxi.datatransferobject.DriverSearchDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.exception.SearchException;

/**
 * Interface for Driver custom search API.
 * @author rajkumar
 *
 */
@Repository
public interface DriverRepositoryCustom
{

    List<DriverDO> findByQuery(DriverSearchDTO carSearchDTO) throws SearchException;
}
