package com.example.NBD.Rent;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;
import java.util.UUID;

public interface RentRepository extends CassandraRepository<Rent, UUID> {
    @AllowFiltering
    Optional<Rent> findById(UUID id);

    @AllowFiltering
    Optional<Rent> findByRoomNumberAndId(UUID roomNumber, UUID id);
    @AllowFiltering
    boolean existsByRoomNumberAndId(UUID roomNumber, UUID id);
}
