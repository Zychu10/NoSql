package com.example.NBD.Room.Exceptions;

import com.example.NBD.Exceptions.NbdException;

import java.util.UUID;

public class RoomNotFoundException extends NbdException {

    public RoomNotFoundException(UUID roomNumber){
        super(String.format("Room is not found {roomNumber=%s}", roomNumber));
    }
}
