package com.example.NBD.Rent;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "rent")
public class Rent {

    @PrimaryKey
    private UUID id;

    private Double rentCost;


    private UUID clientId;


    private UUID roomNumber;
}
