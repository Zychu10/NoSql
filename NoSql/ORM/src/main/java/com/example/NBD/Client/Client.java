package com.example.NBD.Client;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;


@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int clientId;

    @Column(length = 100)
    @Setter
    @NotNull
    private String firstName;

    @Column(length = 100)
    @Setter
    @NotNull
    private String lastName;

}
