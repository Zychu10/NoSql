package com.example.NBD;


import com.example.NBD.Client.ClientDefault;
import com.example.NBD.Kafka.JsonKafkaProducer;
import com.example.NBD.Rent.Rent;
import com.example.NBD.Room.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootTest
class TestApplicationTests {

	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	@Test
	void contextLoads() {
	}

	@Test
	void sendTest() {
		Rent rent = Rent.builder()
				.id("1")
				.rentCost(200.0)
				.client(ClientDefault.builder()
						.id("1")
						.firstName("Jan")
						.lastName("Dab")
						.discount(0.7)
						.build())
				.room(Room.builder()
						.id("1")
						.roomNumber(1)
						.roomCapacity(2)
						.roomPrice(200.0)
						.isRent(false)
						.build())
				.build();
		jsonKafkaProducer.sendMessage(rent);
	}
}
