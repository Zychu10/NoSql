package com.example.NBD.Rent;

import com.example.NBD.Client.ClientService;
import com.example.NBD.Room.Exceptions.RoomIsNotAvailableException;
import com.example.NBD.Rent.Exceptions.RentAlreadyExistException;
import com.example.NBD.Rent.Exceptions.RentNotFoundException;
import com.example.NBD.Room.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository rentRepository;

    private final ClientService clientService;

    private final RoomService roomService;

    public Rent findRent(UUID roomNumber, UUID clientId){
        return rentRepository.findByRoomNumberAndId(roomNumber, clientId).orElseThrow(()-> new RentNotFoundException(roomNumber, clientId));
    }

    public List<Rent> getAllRents() { return rentRepository.findAll(); }

    public void checkDuplicate(UUID roomNumber, UUID clientId) {
        if(rentRepository.existsByRoomNumberAndId(roomNumber, clientId)) {
            throw new RentAlreadyExistException(roomNumber, clientId);
        }
    }

    public void deleteRent(Float rentCost, UUID roomNumber, UUID clientId) {
        rentRepository.delete(rentRepository.findByRoomNumberAndId(roomNumber,clientId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId)));
    }

    public void isRentExist(UUID roomNumber, UUID clientId){
        if(!rentRepository.existsByRoomNumberAndId(roomNumber, clientId)){
            throw new RentNotFoundException(roomNumber, clientId);
        }
    }

    private void isRoomAvailable(UUID roomNumber){
        if(roomService.findRoom(roomNumber).getIsRent()){
            throw new RoomIsNotAvailableException(roomNumber);
        }
    }

        public Rent addRent(Double rentCost, UUID roomNumber, UUID clientId) {
        checkDuplicate(roomNumber, clientId);
        isRoomAvailable(roomNumber);
        roomService.findRoom(roomNumber).setIsRent(true);
        return rentRepository.save(Rent.builder()
                .id(UUID.randomUUID())
                .clientId(clientId)
                .roomNumber(roomNumber)
                .rentCost(rentCost)
                .build());
    }
    public void deleteAll() {
        if(!getAllRents().isEmpty())
            rentRepository.deleteAll();
    }
}
