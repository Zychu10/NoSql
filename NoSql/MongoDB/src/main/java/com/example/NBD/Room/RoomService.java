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

    public void checkDuplicateRoom(Integer roomNumber){
       if(roomRepository.existsByRoomNumber(roomNumber)){
           throw new RoomAlreadyExistException(roomNumber);
       }
    }

    public void deleteRoom(Integer roomNumber){
       roomRepository.delete(findRoom(roomNumber));
    }

    public Room addRoom(Integer roomNumber, Integer roomCapacity, Double roomPrice, Boolean isRent ) {
       checkDuplicateRoom(roomNumber);
       Room room = Room.builder()
               .roomNumber(roomNumber)
               .roomCapacity(roomCapacity)
               .roomPrice(roomPrice)
               .isRent(isRent)
               .build();
       return roomRepository.save(room);
    }

    public void deleteAll() {
       if(!getAllRooms().isEmpty()) {
           roomRepository.deleteAll();
       }
    }

    public void priceUpdate(Double newPrice, Room room) {
       updateRoom(room.getId(),room.getRoomNumber(),room.getRoomCapacity(), newPrice, room.getIsRent());
    }

    public Room updateRoom(String id, Integer roomNumber, Integer roomCapacity, Double price, Boolean isRent) {
       if(findRoom(roomNumber) != null) {
           return roomRepository.save(Room.builder()
                   .id(id)
                   .roomNumber(roomNumber)
                   .roomCapacity(roomCapacity)
                   .roomPrice(price)
                   .isRent(isRent)
                   .build());
       }
       else
           throw new RoomNotFoundException(roomNumber);
    }
}
