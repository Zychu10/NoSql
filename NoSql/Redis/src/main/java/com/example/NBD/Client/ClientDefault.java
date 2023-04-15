package com.example.NBD.Client;


import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
@TypeAlias("defaultClient")
public class ClientDefault extends Client {


    @Setter
    @NotNull
    private Double discount = 0.7;

    @Builder
    public ClientDefault(String id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }

}
