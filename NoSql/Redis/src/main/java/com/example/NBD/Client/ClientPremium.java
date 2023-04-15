package com.example.NBD.Client;


import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
@TypeAlias("PremiumClient")
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
