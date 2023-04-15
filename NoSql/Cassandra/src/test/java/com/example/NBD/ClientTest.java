package com.example.NBD;

import com.example.NBD.Client.ClientRepository;
import com.example.NBD.Client.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {
    @Autowired
    private ClientRepository clientRepository;

    private ClientService clientService;

    @Test
    public void addTest() {
        String firstName = "Adam";
        String lastName = "Wozniak";
        Double discount = 0.7;
        clientService = new ClientService(clientRepository);
        clientService.deleteAll();
        clientService.addDefaultClient(firstName,lastName, discount);
    }

}
