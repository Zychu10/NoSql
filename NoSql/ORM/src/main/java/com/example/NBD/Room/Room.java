package com.example.NBD.Room;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;


@Builder
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer roomNumber;

    @Column(length = 100)
    @Setter
    @NotNull
    private Integer roomCapacity;

    @Column(length = 100)
    @Setter
    @NotNull
    private Float roomPrice;


    @Column(length = 100)
    @Setter
    @NotNull
    private Boolean isRent = false;

}
