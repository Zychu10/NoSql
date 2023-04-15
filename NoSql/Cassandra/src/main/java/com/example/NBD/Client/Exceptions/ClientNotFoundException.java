package com.example.NBD.Client.Exceptions;


import com.example.NBD.Exceptions.NbdException;

import java.util.UUID;

public class ClientNotFoundException extends NbdException {

    public ClientNotFoundException(UUID clientId) {
        super(String.format("Client is not found in database {clientId=%s}",
                clientId));
    }
}
