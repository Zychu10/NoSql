package com.example.NBD.Client;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

public class ClientPremium extends Client{
    @Column
    @Setter
    @NotNull
    private Double discount = 0.9;

    @Builder
    public ClientPremium(Integer id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }
}
