package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The selected car is associated with other driver ...")
public class CarAlreadyInUseException extends Exception
{

    static final long serialVersionUID = -4456789123244229948L;


    public CarAlreadyInUseException(String message)
    {
        super(message);
    }

}
