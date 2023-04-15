package com.example.NBD.Room;


import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rooms")
public class Room implements Serializable {

    @Id
    private String id;

    @Setter
    @NotNull
    private Integer roomNumber;

    @Setter
    @NotNull
    private Integer roomCapacity;

    @Setter
    @NotNull
    private Double roomPrice;


    @Setter
    @NotNull
    private Boolean isRent = false;

}
