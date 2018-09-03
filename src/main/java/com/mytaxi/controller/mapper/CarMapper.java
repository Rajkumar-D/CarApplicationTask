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
    /**
     * Make carDO object using the given carDTO object.
     * 
     * @param carDTO
     * @return carDO
     */
    public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(carDTO.getLicensePlate(), carDTO.getName(), carDTO.getSeatCount(), carDTO.getRating(), carDTO.getEngineType(), carDTO.getColor(), carDTO.getConvertible());
    }


    /**
     * Create carDTO object using the given carDO.
     * 
     * @param carDO
     * @return CarDTO
     */
    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO carDTO = null;
        if (carDO != null)
            carDTO =
                new CarDTO(
                    carDO.getId(), carDO.getLicensePlate(), carDO.getName(), carDO.getSeatCount(), carDO.getRating(), carDO.getManufacturer().getId(), carDO.getEngineType(),
                    carDO.getColor(), carDO.getConvertible());

        return carDTO;
    }


    /**
     * Create catDTO list using the given list
     * 
     * @param drivers
     * @returnList<CarDTO>
     */
    public static List<CarDTO> makeCarDTOList(Collection<CarDO> drivers)
    {
        return drivers.stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
}
