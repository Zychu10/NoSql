package com.example.NBD.Client;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "client")
public class Client {

    @PrimaryKey
    private UUID id;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

}
