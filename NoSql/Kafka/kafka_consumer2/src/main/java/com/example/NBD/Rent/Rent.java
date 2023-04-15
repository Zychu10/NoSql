package com.example.NBD.Rent;

import com.example.NBD.Client.Client;
import com.example.NBD.Room.Room;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rents")
public class Rent {

    @Id
    private String id;

    @NotNull
    private Double rentCost;

    @NotNull
    private Client client;

    @NotNull
    private Room room;
}
