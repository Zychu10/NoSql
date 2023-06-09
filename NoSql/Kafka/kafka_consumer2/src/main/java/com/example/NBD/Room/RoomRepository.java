package com.example.NBD.Room;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {

    Optional<Room> findByRoomNumber(Integer roomNumber);

    boolean existsByRoomNumber(Integer roomNumber);
}
