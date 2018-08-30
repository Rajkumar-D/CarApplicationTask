package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.mytaxi.domainvalue.OnlineStatus;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "uc_car", columnNames = {"license_plate"}))
public class CarDO
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false, name = "license_plate")
    @NotNull(message = "License Plate can not be null!")
    private String licensePlate;

    @Column(nullable = false)
    @NotNull(message = "Car name can not be null!")
    private String name;

    @NotNull(message = "Seat count can not be null!")
    private Integer seatCount;

    private Boolean convertible;

    @NotNull(message = "Rating can not be null!")
    private Integer rating;

    private String engineType;

    private String color;

    @OneToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerDO manufacturer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OnlineStatus onlineStatus;


    public CarDO(
        @NotNull(message = "License Plate can not be null!") String licensePlate,
        @NotNull(message = "Car name can not be null!") String name, @NotNull(message = "Seat count can not be null!") Integer seatCount,
        @NotNull(message = "Rating can not be null!") Integer rating, ManufacturerDO manufacturer)
    {
        super();
        this.licensePlate=licensePlate;
        this.name = name;
        this.seatCount = seatCount;
        this.rating = rating;
        this.manufacturer = manufacturer;
        this.onlineStatus = OnlineStatus.ONLINE;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
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


    public Boolean getConvertible()
    {
        return convertible;
    }


    public void setConvertible(Boolean convertible)
    {
        this.convertible = convertible;
    }


    public Integer getRating()
    {
        return rating;
    }


    public void setRating(Integer rating)
    {
        this.rating = rating;
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


    public ManufacturerDO getManufacturer()
    {
        return manufacturer;
    }


    public void setManufacturer(ManufacturerDO manufacturer)
    {
        this.manufacturer = manufacturer;
    }


    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }


    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

}
