package com.example.NBD.Rent.Exceptions;

import com.example.NBD.Exceptions.NbdException;

public class RentNotFoundException extends NbdException {

    public RentNotFoundException(Integer roomNumber, String clientId){
        super(String.format("Rent is not found in database {roomNumber=%s, clientId=&s}",
                roomNumber, clientId));
    }
}
