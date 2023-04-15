package com.example.NBD.Room;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "rooms")
public class Room {

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
