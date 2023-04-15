package com.example.NBD.Rent.Exceptions;

import com.example.NBD.Exceptions.NbdException;

import java.util.UUID;

public class RentAlreadyExistException extends NbdException {

    public RentAlreadyExistException(UUID roomNumber, UUID clientId) {
        super(String.format("Rent already exists {roomNumber=%s, clientId=&s}",
                roomNumber, clientId));
    }
}

