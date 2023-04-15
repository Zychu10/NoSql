package com.example.NBD.Room;


import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;


import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends CassandraRepository<Room, UUID> {
    @AllowFiltering
    Optional<Room> findByRoomNumber(UUID roomNumber);
    @AllowFiltering
    boolean existsByRoomNumber(UUID roomNumber);
}
