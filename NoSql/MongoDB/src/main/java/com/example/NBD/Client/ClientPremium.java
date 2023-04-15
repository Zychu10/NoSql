package com.example.NBD.Client;


import lombok.Builder;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


public class ClientPremium extends Client{

    @Setter
    @NotNull
    private Double discount = 0.9;

    @Builder
    public ClientPremium(String id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }
}
