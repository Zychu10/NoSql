package com.example.NBD.Room.Exceptions;

import com.example.NBD.Exceptions.NbdException;

import java.util.UUID;

public class RoomIsNotAvailableException extends NbdException {

    public RoomIsNotAvailableException(UUID roomNumber) {
        super(String.format("Room is not available in this moment {roomNumber=%s}", roomNumber));
    }
}
