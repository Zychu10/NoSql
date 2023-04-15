package com.example.NBD.Client;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClientPremium.class, name = "PremiumClient"),
        @JsonSubTypes.Type(value = ClientDeluxe.class, name= "DeluxeClient"),
        @JsonSubTypes.Type(value = ClientDefault.class, name= "DefaultClient")
})
public class Client {

    @Id
    private String clientId;

    @Setter
    @NotNull
    private String firstName;

    @Setter
    @NotNull
    private String lastName;

    @Override
    public String toString() {
        return "ClientDefault{" +
                "id='" + clientId + '\'' +
                ", firstName=" + firstName +
                ", lastName=" + lastName + '\'' +
                '}';
    }
}
