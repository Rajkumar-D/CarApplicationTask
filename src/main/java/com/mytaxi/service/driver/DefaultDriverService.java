package com.mytaxi.service.driver;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.datatransferobject.DriverSearchDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.exception.SearchException;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */

@Service
public class DefaultDriverService implements DriverService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    private final DriverRepository driverRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public DefaultDriverService(final DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }


    /**
     * Selects a driver by id.
     *
     * @param driverId
     * @return found driver
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    public DriverDO find(Long driverId) throws EntityNotFoundException
    {
        return findDriverChecked(driverId);
    }


    /**
     * Creates a new driver.
     *
     * @param driverDO
     * @return
     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
     */
    @Override
    public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException
    {
        DriverDO driver;
        try
        {
            driver = driverRepository.save(driverDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a driver: {}", driverDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }

        return driver;
    }


    /**
     * Deletes an existing driver by id.
     *
     * @param driverId
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setDeleted(true);
    }


    /**
     * Update the location for a driver.
     *
     * @param driverId
     * @param longitude
     * @param latitude
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
    }


    /**
     * Synchronized call to Set a car to a driver
     * 
     * @param driverId
     * @param carId
     * throws EntityNotFoundException
     */
    @Override
    @Transactional
    public synchronized void associateCar(long driverId, CarDO carDO) throws EntityNotFoundException, CarAlreadyInUseException
    {
        if (carDO.isAssociated())
        {
            LOG.warn("CarAlreadyInUseException - Car [ " + carDO.getLicensePlate() + " ] is already associated with a driver");
            throw new CarAlreadyInUseException("CarAlreadyInUseException while associating the car with the driver");
        }

        DriverDO driverDO = findDriverChecked(driverId);
        if (driverDO.getOnlineStatus().equals(OnlineStatus.OFFLINE))
        {
            LOG.warn("EntityNotFoundException - Driver [ " + driverDO.getUsername() + " ] cannot be associated with car as he is offline");
            throw new EntityNotFoundException("EntityNotFoundException while associating the car with the driver. Driver is Offline");
        }
        driverDO.setCarDO(carDO);
        carDO.setAssociated(true);
        driverRepository.save(driverDO);
    }


    @Override
    public void dissociateCar(long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        CarDO carDO = driverDO.getCarDO();

        carDO.setAssociated(false);
        driverDO.setCarDO(null);

        driverRepository.save(driverDO);
    }


    /**
     * Find drivers by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<DriverDO> find(OnlineStatus onlineStatus)
    {
        return driverRepository.findByOnlineStatus(onlineStatus);
    }


    /**
     * Find driver by Query. This will search using custom repository method
     * 
     * @param DriverSearchDTO
     * @return List<DriverDO
     */
    @Override
    public List<DriverDO> findByQuery(DriverSearchDTO carSearchDTO) throws SearchException
    {
        return driverRepository.findByQuery(carSearchDTO);

    }


    /**
     * Finds the DriverDO object.
     * 
     * @param driverId
     * @return
     * @throws EntityNotFoundException
     */
    private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException
    {
        return driverRepository.findById(driverId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }

}
