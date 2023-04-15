package com.example.NBD.Rent;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RentRepository extends MongoRepository<Rent,String> {
    Optional<Rent> findById(String id);


    Optional<Rent> findByRoomRoomNumberAndClientClientId(Integer roomNumber, String clientId);

    boolean existsByRoomRoomNumberAndClientClientId(Integer roomNumber, String clientId);
}
