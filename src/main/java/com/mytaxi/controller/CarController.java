package com.mytaxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.ManufacturerDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;
import com.mytaxi.service.car.DefaultCarService;

/**
 * All operations with a car will be routed by this controller.
 * <p/>
 * @author rajkumar
 */
@RestController
@RequestMapping("v1/cars")
public class CarController
{
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(CarController.class);
    
    private final CarService carService;


    @Autowired
    public CarController(final CarService carService)
    {
        this.carService = carService;
    }


    @GetMapping("/{carId}")
    public CarDTO getCar(@Valid @PathVariable long carId) throws EntityNotFoundException
    {
        return CarMapper.makeCarDTO(carService.find(carId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException, EntityNotFoundException
    {
            ManufacturerDO manDO = carService.findManufacturer(carDTO.getManufacturerId());
            CarDO carDO = CarMapper.makeCarDO(carDTO);
            carDO.setManufacturer(manDO);
            return CarMapper.makeCarDTO(carService.save(carDO));
    }
    
    @PutMapping("/{carId}")
    public CarDTO updateCar(@Valid @PathVariable long carId,@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException, EntityNotFoundException
    {
            ManufacturerDO manDO = carService.findManufacturer(carDTO.getManufacturerId());
            CarDO carDO = CarMapper.makeCarDO(carDTO);
            carDO.setManufacturer(manDO);
            carDO.setId(carId);
            return CarMapper.makeCarDTO(carService.save(carDO));
    }


    @DeleteMapping("/{carId}")
    public void deleteDriver(@Valid @PathVariable long carId) throws EntityNotFoundException
    {
        carService.delete(carId);
    }


    @GetMapping
    public List<CarDTO> findCars(@RequestParam OnlineStatus onlineStatus)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        return CarMapper.makeCarDTOList(carService.find(onlineStatus));
    }

}
