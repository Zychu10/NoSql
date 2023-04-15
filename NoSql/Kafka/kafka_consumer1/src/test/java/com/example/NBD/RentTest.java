package com.example.NBD;

import com.example.NBD.Client.ClientRepository;
import com.example.NBD.Client.ClientService;
import com.example.NBD.Rent.RentRepository;
import com.example.NBD.Rent.RentService;
import com.example.NBD.Room.RoomRepository;
import com.example.NBD.Room.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RentTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RentRepository rentRepository;

    private ClientService clientService;

    private RoomService roomService;

    private RentService rentService;

//    @Test
//    public void AddTest() {
//        Double rentCost = 0.9 * 250;
//        clientService = new ClientService(clientRepository);
//        roomService = new RoomService(roomRepository);
//        rentService = new RentService(rentRepository, clientService, roomService);
//        String firstName = "Adam";
//        String lastName = "Wozniak";
//        Double discount = 0.7;
//        clientService.deleteAll();
//        clientService.addDefaultClient(firstName,lastName, discount);
//        roomService.deleteAll();
//        Integer roomNumber = 1;
//        Integer roomCapacity = 3;
//        Double roomPrice = 85.0;
//        Boolean isRent = false;
//        roomService.addRoom(roomNumber,roomCapacity,roomPrice,isRent);
//        rentService.addRent(rentCost,roomNumber,clientRepository.f)
//    }
    @Test
    public void nestedTest() {
        clientService = new ClientService(clientRepository);
        roomService = new RoomService(roomRepository);
        rentService = new RentService(rentRepository,clientService,roomService);
        rentService.deleteAll();
        roomService.deleteAll();
        clientService.deleteAll();
        rentService.addRent(123.5,roomService.addRoom(10,2,100.5,false).getRoomNumber(),
                clientService.addDefaultClient("Jan","plan", 0.7).getClientId());

    }
}
