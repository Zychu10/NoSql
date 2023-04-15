package com.example.NBD.Room.Exceptions;

import com.example.NBD.Exceptions.NbdException;

public class RoomNotFoundException extends NbdException {

    public RoomNotFoundException(Integer roomNumber){
        super(String.format("Room is not found {roomNumber=%s}", roomNumber));
    }
}
