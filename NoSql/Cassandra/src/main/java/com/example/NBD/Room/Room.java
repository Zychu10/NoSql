package com.example.NBD.Room;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Room {

    @PrimaryKey
    private UUID id;

    @Setter
    private UUID roomNumber;

    @Setter
    private Integer roomCapacity;

    @Setter
    private Double roomPrice;


    @Setter
    private Boolean isRent = false;

}
