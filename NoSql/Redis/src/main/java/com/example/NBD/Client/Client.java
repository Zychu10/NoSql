package com.example.NBD.Client;


import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
public class Client {

    @Id
    private String clientId;

    @Setter
    @NotNull
    private String firstName;

    @Setter
    @NotNull
    private String lastName;

}
