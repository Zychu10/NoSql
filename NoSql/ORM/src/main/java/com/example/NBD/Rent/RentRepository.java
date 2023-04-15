package com.example.NBD.Rent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent,Integer> {
    Optional<Rent> findById(Integer id);


    Optional<Rent> findByRoomRoomNumberAndClientClientId(Integer roomNumber, Integer clientId);

    boolean existsByRoomRoomNumberAndClientClientId(Integer roomNumber, Integer clientId);
}
