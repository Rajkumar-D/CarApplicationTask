package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mytaxi.domainobject.ManufacturerDO;

/**
 * Entity Mapper class for car table.
 * @author rajkumar
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO
{
    @JsonIgnore
    private Long id;

    @NotNull(message = "License Plate can not be null!")
    private String licensePlate;

    private String name;

    @NotNull(message = "Seat count can not be null!")
    private Integer seatCount;

    @NotNull(message = "Rating can not be null!")
    private Integer rating;
    
    private ManufacturerDO manufacturer;


    public CarDTO()
    {

    }


    public CarDTO(
        Long id, @NotNull(message = "License Plate can not be null!") String licensePlate, String name, @NotNull(message = "Seat count can not be null!") Integer seatCount,
        @NotNull(message = "Rating can not be null!") Integer rating, ManufacturerDO manufacturer)
    {
        super();
        this.id = id;
        this.licensePlate = licensePlate;
        this.name = name;
        this.seatCount = seatCount;
        this.rating = rating;
        this.manufacturer=manufacturer;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public Integer getSeatCount()
    {
        return seatCount;
    }


    public void setSeatCount(Integer seatCount)
    {
        this.seatCount = seatCount;
    }


    public Integer getRating()
    {
        return rating;
    }


    public void setRating(Integer rating)
    {
        this.rating = rating;
    }


    public ManufacturerDO getManufacturer()
    {
        return manufacturer;
    }


    public void setManufacturer(ManufacturerDO manufacturer)
    {
        this.manufacturer = manufacturer;
    }
    
    
    
}
