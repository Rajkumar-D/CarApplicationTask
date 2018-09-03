package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

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

    private String engineType;

    private String color;

    private Boolean convertible;

    private Long manufacturerId;


    public CarDTO()
    {

    }


    public CarDTO(
        Long id, @NotNull(message = "License Plate can not be null!") String licensePlate, String name, @NotNull(message = "Seat count can not be null!") Integer seatCount,
        @NotNull(message = "Rating can not be null!") Integer rating, Long manufacturerId, String engineType, String color, Boolean convertible)
    {
        super();
        this.id = id;
        this.licensePlate = licensePlate;
        this.name = name;
        this.seatCount = seatCount;
        this.rating = rating;
        this.manufacturerId = manufacturerId;
        this.engineType = engineType;
        this.color = color;
        this.convertible = convertible;
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


    public Long getManufacturerId()
    {
        return manufacturerId;
    }


    public void setManufacturerId(Long manufacturerId)
    {
        this.manufacturerId = manufacturerId;
    }


    public String getEngineType()
    {
        return engineType;
    }


    public void setEngineType(String engineType)
    {
        this.engineType = engineType;
    }


    public String getColor()
    {
        return color;
    }


    public void setColor(String color)
    {
        this.color = color;
    }


    public Boolean getConvertible()
    {
        return convertible;
    }


    public void setConvertible(Boolean convertible)
    {
        this.convertible = convertible;
    }

}
