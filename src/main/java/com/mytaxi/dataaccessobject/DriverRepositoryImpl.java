package com.mytaxi.dataaccessobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.mytaxi.datatransferobject.DriverSearchDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.exception.SearchException;

/**
 * Implementation class for Driver custom search API.
 * @author rajkumar
 *
 */
@Repository
public class DriverRepositoryImpl implements DriverRepositoryCustom
{
    @PersistenceContext
    private EntityManager em;


    /**
     * To get driver by car details.
     * 
     * @param DriverSearchDTO
     * @return List<DriverDO>
     * throws SearchException
     */
    @Override
    public List<DriverDO> findByQuery(DriverSearchDTO driverSearchDTO) throws SearchException
    {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DriverDO> query = cb.createQuery(DriverDO.class);
        Root<DriverDO> driver = query.from(DriverDO.class);
        Join<DriverDO, Object> car = driver.join("carDO");

        List<Predicate> predicateList = new ArrayList<Predicate>();

        if (driverSearchDTO.getUserName() != null)
            predicateList.add(cb.equal(driver.get("username"), driverSearchDTO.getUserName()));
        if (driverSearchDTO.getOnlineStatus() != null)
            predicateList.add(cb.equal(driver.get("onlineStatus"), driverSearchDTO.getOnlineStatus()));
        if (driverSearchDTO.getLicensePlate() != null)
            predicateList.add(cb.equal(car.get("licensePlate"), driverSearchDTO.getLicensePlate()));
        if (driverSearchDTO.getName() != null)
            predicateList.add(cb.equal(car.get("name"), driverSearchDTO.getName()));
        if (driverSearchDTO.getSeatCount() != null)
            predicateList.add(cb.equal(car.get("seatCount"), driverSearchDTO.getSeatCount()));
        if (driverSearchDTO.getRating() != null)
            predicateList.add(cb.equal(car.get("rating"), driverSearchDTO.getRating()));
        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(predicates);

        return em.createQuery(query).getResultList();
    }

}
