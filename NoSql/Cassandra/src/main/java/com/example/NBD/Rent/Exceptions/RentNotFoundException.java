package com.example.NBD.Rent.Exceptions;

import com.example.NBD.Exceptions.NbdException;

import java.util.UUID;

public class RentNotFoundException extends NbdException {

    public RentNotFoundException(UUID roomNumber, UUID clientId){
        super(String.format("Rent is not found in database {roomNumber=%s, clientId=&s}",
                roomNumber, clientId));
    }
}
