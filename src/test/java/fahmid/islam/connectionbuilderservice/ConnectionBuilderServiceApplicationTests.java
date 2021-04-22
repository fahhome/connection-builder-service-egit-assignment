package fahmid.islam.connectionbuilderservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import fahmid.islam.connectionbuilderservice.service.FlightScheduleService;

@SpringBootTest
class ConnectionBuilderServiceApplicationTests {

	@Autowired
	private FlightScheduleService flightScheduleService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testLoadDataForTestClass() {
		assertEquals(2, flightScheduleService.getFlightSchedules().size());
	}

}
