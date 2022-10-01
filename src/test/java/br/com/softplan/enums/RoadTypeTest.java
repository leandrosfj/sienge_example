package br.com.softplan.enums;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoadTypeTest {

	private static final Double PAVIMENT_ROAD_PRICE = 0.54;

	private static final Double UNPAVIMENT_ROAD_PRICE = 0.62;

	private static final String PAVEMENT_ROAD_DESCRIPTION = "Pavimentada";

	private static final String UNPAVEMENT_ROAD_DESCRIPTION = "Não Pavimentada";


	@Test
	public void shouldReturnPavementRoadPrice() {

		assertThat(RoadType.PAVEMENT_ROAD.getPricePerKm(), is(PAVIMENT_ROAD_PRICE));

	}

	@Test
	public void shouldReturnUnpavementRoadPrice() {

		assertThat(RoadType.UNPAVEMENT_ROAD.getPricePerKm(), is(UNPAVIMENT_ROAD_PRICE));
	}


	@Test
	public void shouldReturnPavementRoadTypeDescription() {

		assertThat(RoadType.PAVEMENT_ROAD.getRoadTypeDescription(), is(PAVEMENT_ROAD_DESCRIPTION));
	}

	@Test
	public void shouldReturnUnpavementRoadTypeDescription() {

		assertThat(RoadType.UNPAVEMENT_ROAD.getRoadTypeDescription(), is(UNPAVEMENT_ROAD_DESCRIPTION));
	}

}