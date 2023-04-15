package com.example.NBD;

import com.example.NBD.Room.Exceptions.RoomNotFoundException;
import com.example.NBD.Room.RoomRepository;
import com.example.NBD.Room.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @Test
    public void addRoomTest() {
        roomService = new RoomService(roomRepository);
        roomService.deleteAll();
        roomService.addRoom(UUID.randomUUID(),3,250.0, false);
        roomService.addRoom(UUID.randomUUID(),1,500.0, false);
    }
    @Test
    public void deleteRoomTest() {
        UUID roomNumber = UUID.randomUUID();
        Integer roomCapacity = 3;
        Double roomPrice = 85.0;
        Boolean isRent = false;
        roomService = new RoomService(roomRepository);
        roomService.deleteAll();
        roomService.addRoom(roomNumber, roomCapacity, roomPrice, isRent);
        roomService.deleteRoom(roomNumber);
        assertThrows(RoomNotFoundException.class, () ->roomService.findRoom(roomNumber));
    }

    @Test
    public void updatePriceTest() {
        UUID roomNumber = UUID.randomUUID();
        Integer roomCapacity = 3;
        Double roomPrice = 85.0;
        Boolean isRent = false;
        Double newPrice = 120.0;
        roomService = new RoomService(roomRepository);
        roomService.deleteAll();
        roomService.addRoom(roomNumber, roomCapacity, roomPrice, isRent);
        roomService.priceUpdate(newPrice,roomService.findRoom(roomNumber));
        assertEquals(roomService.findRoom(roomNumber).getRoomPrice(),newPrice);

    }
    @Test
    public void findByTest() {
        UUID roomNumber = UUID.randomUUID();
        Integer roomCapacity = 3;
        Double roomPrice = 85.0;
        Boolean isRent = false;
        roomService = new RoomService(roomRepository);
        roomService.deleteAll();
        roomService.addRoom(roomNumber, roomCapacity, roomPrice, isRent);
        assertEquals(roomService.findRoom(roomNumber).getRoomNumber(),roomNumber);
    }

}
