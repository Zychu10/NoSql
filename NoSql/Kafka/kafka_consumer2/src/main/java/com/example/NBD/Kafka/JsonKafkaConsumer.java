package com.example.NBD.Kafka;


import com.example.NBD.Client.ClientRepository;
import com.example.NBD.Client.ClientService;
import com.example.NBD.Rent.Rent;
import com.example.NBD.Rent.RentRepository;
import com.example.NBD.Rent.RentService;
import com.example.NBD.Room.RoomRepository;
import com.example.NBD.Room.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Autowired
    private RentRepository rentRepository;

    private ClientService clientService;

    private RoomService roomService;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Rent rent){
        LOGGER.info(String.format("Json message recieved -> %s", rent.toString()));
        RentService rentService = new RentService(rentRepository,clientService,roomService);
        rentService.saveRent(rent);
    }
}
