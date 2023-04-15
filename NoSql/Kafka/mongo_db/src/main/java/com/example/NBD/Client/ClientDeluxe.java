package com.example.NBD.Client;


import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
@TypeAlias("DeluxeClient")
public class ClientDeluxe extends Client{

    @Setter
    @NotNull
    private Double discount = 0.8;

    @Builder
    public ClientDeluxe(String id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }
}
