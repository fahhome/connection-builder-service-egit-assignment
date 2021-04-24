package fahmid.islam.connectionbuilderservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import fahmid.islam.connectionbuilderservice.dto.JoinResponse;
import fahmid.islam.connectionbuilderservice.entity.FlightSchedule;
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
		assertEquals(5, flightScheduleService.getFlightSchedules().size());
	}

	@Test
	public void testAllConnectingRows() {
		assertEquals(6, flightScheduleService.getConnectingFlights().size());
	}

	@Test
	public void testfindById() {

		FlightSchedule fs  = flightScheduleService.getFlightScheduleById(2);
		assertNotNull(fs);
	}

	@Test
	public void testControllerLogic() {

		List<JoinResponse> allConnections = flightScheduleService.getConnectingFlights();
		List<JoinResponse> lhm = new LinkedList<>();

		allConnections.stream().filter(row -> row != null)
				.filter(row -> row.getFirstDepAirport().equals("BOM")
						&& row.getSecondArrAirport().equals("JFK"))
				.filter(row -> row.getDifferenceOfCriticalTime() >= 2 && row.getDifferenceOfCriticalTime() <= 8)
				.forEachOrdered(row -> lhm.add(row));
		
		
		assertEquals(1, lhm.size());

	}


}
