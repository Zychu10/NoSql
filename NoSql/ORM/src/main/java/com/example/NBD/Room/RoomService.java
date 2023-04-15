package com.example.NBD.Room;

import com.example.NBD.Room.Exceptions.RoomAlreadyExistException;
import com.example.NBD.Room.Exceptions.RoomNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

   private final RoomRepository roomRepository;

   public Room findRoom(Integer roomNumber){
       return roomRepository.findByRoomNumber(roomNumber).orElseThrow(() -> new RoomNotFoundException(roomNumber));
   }

   public List<Room> getAllRooms() { return roomRepository.findAll(); }

    private void checkDuplicateRoom(Integer roomNumber){
       if(roomRepository.existsByRoomNumber(roomNumber)){
           throw new RoomAlreadyExistException(roomNumber);
       }
    }

    private void deleteRoom(Integer roomNumber){
       roomRepository.delete(findRoom(roomNumber));
    }

    private Room addRoom(Integer roomNumber, Integer roomCapacity, Float roomPrice, Boolean isRent ) {
       checkDuplicateRoom(roomNumber);
       Room room = Room.builder()
               .roomNumber(roomNumber)
               .roomCapacity(roomCapacity)
               .roomPrice(roomPrice)
               .isRent(isRent)
               .build();
       return roomRepository.save(room);
    }


}
