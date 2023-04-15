package com.example.NBD.Room.Exceptions;

import com.example.NBD.Exceptions.NbdException;

public class RoomAlreadyExistException extends NbdException {

    public RoomAlreadyExistException(Integer roomNumber){
        super(String.format("Room is already in database {roomNumber=%s}", roomNumber));
    }
}
