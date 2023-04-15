package com.example.NBD.Client;


import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findById(String clientId);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}
