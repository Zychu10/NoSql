package com.example.NBD.Client;


import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends CassandraRepository<Client, UUID> {
    @AllowFiltering
    Optional<Client> findById(UUID id);
    @AllowFiltering
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}
