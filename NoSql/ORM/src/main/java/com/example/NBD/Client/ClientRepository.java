package com.example.NBD.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(Integer id);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

}
