package com.example.NBD.Client;


import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
@TypeAlias("DeluxeClient")
@JsonTypeName("DeluxeClient")
public class ClientDeluxe extends Client{

    @Setter
    @NotNull
    private Double discount = 0.8;

    @Builder
    public ClientDeluxe(String id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + super.getClientId() + '\'' +
                ", firstName=" + super.getFirstName() +
                ", lastName=" + super.getLastName() + '\'' +
                "discount" + discount + '\'' +
                '}';
    }
}
