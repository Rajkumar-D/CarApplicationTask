package com.mytaxi.service.car;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.dataaccessobject.ManufacturerRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.ManufacturerDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * 
 * Service to encapsulate the link between DAO and controller and to have business logic for some car specific things.
 * <p/>
 * @author rajkumar
 */

@Service
public class DefaultCarService implements CarService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    private final CarRepository carRepository;

    private final ManufacturerRepository manRepository;


    @Autowired
    public DefaultCarService(final CarRepository carRepository, ManufacturerRepository manRepository)
    {
        this.carRepository = carRepository;
        this.manRepository = manRepository;
    }


    /**
     * Selects a car by id.
     *
     * @param dcarId
     * @return found car
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    public CarDO find(Long carId) throws EntityNotFoundException
    {
        return findCarChecked(carId);

    }


    /**
     * Save the given car.
     *
     * @param carDo
     * @return
     * @throws ConstraintsViolationException if a car already exists with the given license_plate, ... .
     */
    @Override
    public CarDO save(CarDO carDO) throws ConstraintsViolationException
    {
        CarDO car;
        try
        {
            car = carRepository.save(carDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a car: {}", carDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }


    /**
     * Delete car by Id
     * 
     * @param carId
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void delete(Long carId) throws EntityNotFoundException
    {
        CarDO carDO = findCarChecked(carId);
        carRepository.delete(carDO);
    }


    /**
     * Find car by onlineStatue
     * 
     * @param onlineStatus
     * @return List<CarDO>
     * @throws EntityNotFoundException
     */
    @Override
    public List<CarDO> find(OnlineStatus onlineStatus)
    {
        return carRepository.findByOnlineStatus(onlineStatus);

    }


    /**
     * Find car by car name
     * 
     * @param name
     * @return CarDO
     * @throws EntityNotFoundException
     */
    public CarDO findByName(String name) throws EntityNotFoundException
    {
        return carRepository.findByName(name);
    }


    public ManufacturerDO findManufacturer(Long manId) throws EntityNotFoundException
    {
        return manRepository.findById(manId).orElseThrow(() -> new EntityNotFoundException("Could not find Manufacturer entity with id: " + manId));
    }


    /**
     * @param carId
     * @return CarDO
     * @throws EntityNotFoundException
     */
    private CarDO findCarChecked(Long carId) throws EntityNotFoundException
    {
        return carRepository.findById(carId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }

}
