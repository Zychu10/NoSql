package com.example.NBD;

import com.example.NBD.Client.ClientPremium;
import com.example.NBD.Client.ClientRepository;
import com.example.NBD.Client.ClientService;
import com.example.NBD.Room.Exceptions.RoomNotFoundException;
import com.example.NBD.Room.RoomRepository;
import com.example.NBD.Room.RoomService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
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
