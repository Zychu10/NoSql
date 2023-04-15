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
@TypeAlias("defaultClient")
@JsonTypeName("defaultClient")
public class ClientDefault extends Client {


    @Setter
    @NotNull
    private Double discount = 0.7;

    @Builder
    public ClientDefault(String id, String firstName, String lastName, Double discount) {
        super(id, firstName, lastName);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ClientDefault{" +
                "id='" + super.getClientId() + '\'' +
                ", firstName=" + super.getFirstName() +
                ", lastName=" + super.getLastName() + '\'' +
                "discount" + discount + '\'' +
                '}';
    }
}
