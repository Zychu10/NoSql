package com.example.NBD.Rent;

import com.example.NBD.Client.Client;
import com.example.NBD.Room.Room;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @Setter
    @NotNull
    private Float rentCost;

    @ManyToOne
    @Setter
    private Client client;

    @ManyToOne
    @Setter
    private Room room;
}
