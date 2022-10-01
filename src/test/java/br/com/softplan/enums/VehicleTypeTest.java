package br.com.softplan.enums;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class VehicleTypeTest {

	private static final Double BOX_TRUCK_MF = 1.0;

	private static final Double DUMPER_TRUCK_MF = 1.05;

	private static final Double SEMI_TRACTOR_TRAILER_MF = 1.12;

	private static final String BOX_TRUCK_DESCRIPTION = "Caminhão Baú";

	private static final String DUMPER_TRUCK_DESCRIPTION = "Caminhão Caçamba";

	private static final String SEMI_TRACTOR_TRAILER_DESCRIPTION = "Carreta";

	@Test
	public void shouldReturnBoxTruckMultiplyingFactor() {

		assertThat(VehicleType.BOX_TRUCK.getMultiplyingFactor(), is(BOX_TRUCK_MF));

	}

	@Test
	public void shouldReturnDumperTruckMultiplyingFactor() {

		assertThat(VehicleType.DUMPER_TRUCK.getMultiplyingFactor(), is(DUMPER_TRUCK_MF));
	}

	@Test
	public void shouldReturnSemiTractorTrailerMultiplyingFactor() {

		assertThat(VehicleType.SEMI_TRACTOR_TRAILER.getMultiplyingFactor(), is(SEMI_TRACTOR_TRAILER_MF));
	}


	@Test
	public void shouldReturnNullWhenVehicleIdIsInvalid() {

		assertNull(VehicleType.valueOf(0));
		assertNull(VehicleType.valueOf(4));
	}

	@Test
	public void shouldReturnBoxTruck() {

		assertEquals(VehicleType.BOX_TRUCK, VehicleType.valueOf(1));
	}

	@Test
	public void shouldReturnDumperTruck() {

		assertEquals(VehicleType.DUMPER_TRUCK, VehicleType.valueOf(2));
	}

	@Test
	public void shouldReturnSemiTractorTrailer() {

		assertEquals(VehicleType.SEMI_TRACTOR_TRAILER, VehicleType.valueOf(3));
	}


	@Test
	public void shouldReturnBoxTruckDescription() {

		assertEquals(VehicleType.BOX_TRUCK.getTypeDescription(), BOX_TRUCK_DESCRIPTION);
	}

	@Test
	public void shouldReturnDumperTruckDescription() {

		assertEquals(VehicleType.DUMPER_TRUCK.getTypeDescription(), DUMPER_TRUCK_DESCRIPTION);
	}

	@Test
	public void shouldReturnSemiTractorTrailerDescription() {

		assertEquals(VehicleType.SEMI_TRACTOR_TRAILER.getTypeDescription(), SEMI_TRACTOR_TRAILER_DESCRIPTION);
	}


}