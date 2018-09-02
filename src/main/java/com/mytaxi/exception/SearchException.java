package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Search Exception handler class.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Coule not search based on the given search criteria")
public class SearchException extends Exception
{
    static final long serialVersionUID = 978854235678348L;


    public SearchException(String message)
    {
        super(message);
    }

}
