package com.example.NBD.Client;

import com.example.NBD.Client.Exceptions.ClientCloneException;
import com.example.NBD.Client.Exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Client fetchClient(Integer clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
    }

    private void deleteClient(Integer id) {
        clientRepository.delete(fetchClient(id));
    }

    private void checkDuplicate(String firstName, String lastName) {
        if (clientRepository.existsByFirstNameAndLastName(firstName, lastName)) {
            throw new ClientCloneException(firstName, lastName);
        }
    }

    private Client addDefaultClient(String firstName, String lastName) {
        checkDuplicate(firstName, lastName);
        ClientDefault defultClient = ClientDefault.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return clientRepository.save(defultClient);

    }
}
