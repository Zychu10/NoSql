package com.example.NBD.Client.Exceptions;


import com.example.NBD.Exceptions.NbdException;

public class ClientNotFoundException extends NbdException {

    public ClientNotFoundException(String clientId) {
        super(String.format("Client is not found in database {clientId=%s}",
                clientId));
    }
}
