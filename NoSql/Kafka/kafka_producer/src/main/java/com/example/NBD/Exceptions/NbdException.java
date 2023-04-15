package com.example.NBD.Exceptions;

import lombok.Getter;

@Getter
public class NbdException extends RuntimeException{

    protected NbdException(String message) {super(message);}
}
