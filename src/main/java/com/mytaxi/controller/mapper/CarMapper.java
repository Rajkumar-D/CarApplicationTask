package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

/**
 * Mapper class for CarDO
 * @author rajkumar
 *
 */

public class CarMapper
{
    public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(carDTO.getLicensePlate(),carDTO.getName(), carDTO.getSeatCount(), carDTO.getRating(), carDTO.getManufacturer());
    }


    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO carDTO = new CarDTO(carDO.getId(), carDO.getLicensePlate(), carDO.getName(), carDO.getSeatCount(), carDO.getRating(), carDO.getManufacturer());

        return carDTO;
    }


    public static List<CarDTO> makeCarDTOList(Collection<CarDO> drivers)
    {
        return drivers.stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
}
