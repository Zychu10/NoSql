package com.example.NBD.Rent;

import com.example.NBD.Client.ClientService;
import com.example.NBD.Rent.Exceptions.RentAlreadyExistException;
import com.example.NBD.Rent.Exceptions.RentNotFoundException;
import com.example.NBD.Room.Exceptions.RoomIsNotAvailableException;
import com.example.NBD.Room.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class RentService {

    private final RentRepository rentRepository;

    private final ClientService clientService;

    private final RoomService roomService;

    public Rent findRent(Integer roomNumber, String clientId){
        return rentRepository.findByRoomRoomNumberAndClientClientId(roomNumber, clientId).orElseThrow(()-> new RentNotFoundException(roomNumber, clientId));
    }

    public List<Rent> getAllRents() { return rentRepository.findAll(); }

    public void checkDuplicate(Integer roomNumber, String clientId) {
        if(rentRepository.existsByRoomRoomNumberAndClientClientId(roomNumber, clientId)) {
            throw new RentAlreadyExistException(roomNumber, clientId);
        }
    }

    public void deleteRent(Float rentCost, Integer roomNumber, String clientId) {
        rentRepository.delete(rentRepository.findByRoomRoomNumberAndClientClientId(roomNumber,clientId).orElseThrow(() -> new RentNotFoundException(roomNumber, clientId)));
    }

    public void isRentExist(Integer roomNumber, String clientId){
        if(!rentRepository.existsByRoomRoomNumberAndClientClientId(roomNumber, clientId)){
            throw new RentNotFoundException(roomNumber, clientId);
        }
    }

    private void isRoomAvailable(Integer roomNumber){
        if(roomService.findRoom(roomNumber).getIsRent()){
            throw new RoomIsNotAvailableException(roomNumber);
        }
    }

        public Rent addRent(Double rentCost, Integer roomNumber, String clientId) {
        checkDuplicate(roomNumber, clientId);
        isRoomAvailable(roomNumber);
        roomService.findRoom(roomNumber).setIsRent(true);
        return rentRepository.save(Rent.builder()
                .client(clientService.fetchClient(clientId))
                .room(roomService.findRoom(roomNumber))
                .rentCost(rentCost)
                .build());
    }
    public void deleteAll() {
        if(!getAllRents().isEmpty())
            rentRepository.deleteAll();
    }

    public Rent saveRent(Rent rent) {
        return rentRepository.save(rent);
    }
}
