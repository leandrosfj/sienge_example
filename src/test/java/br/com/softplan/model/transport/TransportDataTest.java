package br.com.softplan.model.transport;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransportDataTest {

	@Test
	public void shouldBeNotValidWhenNoData() {

		final TransportData transportData = TransportData
				.builder()
				.vehicleId(0)
				.distanceInPavementRoad(0)
				.distanceInUnpavementRoad(0)
				.weightTon(0)
				.build();

		assertFalse(transportData.isValid());
	}

	@Test
	public void shouldBeValidWhenDataIsPresent() {

		final TransportData transportData = TransportData
				.builder()
				.vehicleId(1)
				.distanceInPavementRoad(10)
				.distanceInUnpavementRoad(0)
				.weightTon(1)
				.build();

		assertTrue(transportData.isValid());
	}

	@Test
	public void shouldBeNotValidWhenVehicleNotExists() {

		final TransportData transportData = TransportData
				.builder()
				.vehicleId(5)
				.distanceInPavementRoad(10)
				.distanceInUnpavementRoad(0)
				.weightTon(1)
				.build();

		assertFalse(transportData.isValid());
	}

	@Test
	public void shouldBeNotValidWhenVehicleIsZero() {

		final TransportData transportData = TransportData
				.builder()
				.vehicleId(0)
				.distanceInPavementRoad(10)
				.distanceInUnpavementRoad(0)
				.weightTon(1)
				.build();

		assertFalse(transportData.isValid());
	}

}