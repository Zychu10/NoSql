package com.example.NBD.Client.Exceptions;

import com.example.NBD.Exceptions.NbdException;

public class ClientCloneException extends NbdException {
    public ClientCloneException(String firstName, String lastName) {
        super(String.format("Client is not found in database {firstName=%s, lastName=%s}",
                firstName, lastName));
    }
}
