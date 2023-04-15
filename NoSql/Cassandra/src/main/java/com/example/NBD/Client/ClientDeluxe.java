package com.example.NBD.Client;


import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@TypeAlias("DeluxeClient")
public class ClientDeluxe extends Client{

    @Setter
    private Double discount = 0.8;

    @Builder
    public ClientDeluxe(UUID id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }
}
