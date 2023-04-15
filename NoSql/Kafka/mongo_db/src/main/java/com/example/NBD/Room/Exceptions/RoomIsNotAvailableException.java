package com.example.NBD.Room.Exceptions;

import com.example.NBD.Exceptions.NbdException;

public class RoomIsNotAvailableException extends NbdException {

    public RoomIsNotAvailableException(Integer roomNumber) {
        super(String.format("Room is not available in this moment {roomNumber=%s}", roomNumber));
    }
}
