package com.example.NBD;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.example.NBD.Client.ClientDefault;
import com.example.NBD.Client.ClientService;
import com.example.NBD.Rent.Rent;
import com.example.NBD.Rent.RentRepository;
import com.example.NBD.Rent.RentService;
import com.example.NBD.Room.Room;
import com.example.NBD.Room.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TestApplicationTests {

	@Autowired
	private RentRepository rentRepository;

	private RentService rentService;
	private ClientService clientService;
	private RoomService roomService;

	@Test
	void contextLoads() {
	}

	@Test
	void rentExist() {
		rentService = new RentService(rentRepository,clientService,roomService);
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
		assertSame(rentService.findRent(1,"1").getClass(), Rent.class);
	}
}
