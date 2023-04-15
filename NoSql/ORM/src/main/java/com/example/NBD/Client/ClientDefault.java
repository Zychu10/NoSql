package com.example.NBD.Client;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Setter;

import javax.persistence.Column;

public class ClientDefault extends Client{

    @Column
    @Setter
    @NotNull
    private Double discount = 0.7;

    @Builder
    public ClientDefault(Integer id, String firstName, String lastName, Double discount){
        super(id, firstName, lastName);
        this.discount = discount;
    }
    
}
