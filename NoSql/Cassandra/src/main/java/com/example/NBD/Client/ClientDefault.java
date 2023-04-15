package com.example.NBD.Client;


import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.UUID;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("defaultClient")
public class ClientDefault extends Client {


    @Setter
    private Double discount = 0.7;

    @Builder
    public ClientDefault(UUID id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }

}
