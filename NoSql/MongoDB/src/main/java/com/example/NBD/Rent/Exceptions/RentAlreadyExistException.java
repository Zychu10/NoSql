package com.example.NBD.Rent.Exceptions;

import com.example.NBD.Exceptions.NbdException;

public class RentAlreadyExistException extends NbdException {

    public RentAlreadyExistException(Integer roomNumber, String clientId) {
        super(String.format("Rent already exists {roomNumber=%s, clientId=&s}",
                roomNumber, clientId));
    }
}

