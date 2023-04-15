package com.example.NBD.Client;


import lombok.Builder;
import lombok.Setter;

import java.util.UUID;


public class ClientPremium extends Client{

    @Setter
    private Double discount = 0.9;

    @Builder
    public ClientPremium(UUID id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }
}
