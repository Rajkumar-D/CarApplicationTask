package com.mytaxi.datatransferobject;

import com.mytaxi.domainvalue.OnlineStatus;

/**
 * Mapper class for driver search API
 * @author rajkumar
 */
public class DriverSearchDTO
{

    private String userName;

    private OnlineStatus onlineStatus;

    private String licensePlate;

    private String name;

    private Integer seatCount;

    private Integer rating;


    public DriverSearchDTO(String userName, OnlineStatus onlineStatus, String licensePlate, String name, Integer seatCount, Integer rating)
    {
        super();
        this.licensePlate = licensePlate;
        this.name = name;
        this.seatCount = seatCount;
        this.rating = rating;
        this.onlineStatus = onlineStatus;
        this.userName = userName;

    }


    public String getUserName()
    {
        return userName;
    }


    public void setUserName(String userName)
    {
        this.userName = userName;
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

}
