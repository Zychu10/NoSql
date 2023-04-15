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


    public Client fetchClient(String clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
    }

    public void deleteClient(String id) {
        clientRepository.delete(fetchClient(id));
    }

    public void checkDuplicate(String firstName, String lastName) {
        if (clientRepository.existsByFirstNameAndLastName(firstName, lastName)) {
            throw new ClientCloneException(firstName, lastName);
        }
    }

    public Client addDefaultClient(String firstName, String lastName, Double discount) {
        checkDuplicate(firstName, lastName);
        ClientDefault defaultClient = ClientDefault.builder()
                .firstName(firstName)
                .lastName(lastName)
                .discount(discount)
                .build();
        return clientRepository.save(defaultClient);

    }

    public Client addDeluxeClient(String firstName, String lastName, Double discount) {
        checkDuplicate(firstName, lastName);
        ClientDeluxe deluxeClient = ClientDeluxe.builder()
                .firstName(firstName)
                .lastName(lastName)
                .discount(discount)
                .build();
        return clientRepository.save(deluxeClient);

    }

    public Client addPremiumClient(String firstName, String lastName, Double discount) {
        checkDuplicate(firstName, lastName);
        ClientPremium premiumClient = ClientPremium.builder()
                .firstName(firstName)
                .lastName(lastName)
                .discount(discount)
                .build();
        return clientRepository.save(premiumClient);
    }

    public void deleteAll() {
        if(!clientRepository.findAll().isEmpty())
            clientRepository.deleteAll();
    }
}
