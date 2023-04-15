package com.example.NBD.Client;


import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findById(String id);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}
