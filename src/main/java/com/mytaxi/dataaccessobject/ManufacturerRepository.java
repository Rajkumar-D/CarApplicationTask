package com.mytaxi.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.mytaxi.domainobject.ManufacturerDO;

public interface ManufacturerRepository extends CrudRepository<ManufacturerDO, Long>
{

}
