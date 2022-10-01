package br.com.softplan.service.transport;

import br.com.softplan.enums.VehicleType;
import br.com.softplan.model.transport.TransportData;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransportCostCalculatorTest {

	private TransportCostCalculator transportCostCalculator;

	@Before
	public void setUp() {

		this.transportCostCalculator = new TransportCostCalculator();
	}

	@Test
	public void shouldReturnZeroForNoDataProvided() {

		final TransportData transportData = TransportData.builder().build();

		final double transportCost = this.transportCostCalculator.calculate(transportData);

		assertThat(transportCost, is(0d));
	}

	@Test
	public void shouldReturnZeroForNull() {

		final double transportCost = this.transportCostCalculator.calculate(null);

		assertThat(transportCost, is(0d));
	}

	@Test
	public void shouldReturn56dot7WhenWeight5AndPavementRoad100ForDumperTruck() {


		final TransportData transportData = TransportData
				.builder()
				.vehicleId(VehicleType.DUMPER_TRUCK.getId())
				.distanceInPavementRoad(100)
				.weightTon(5)
				.build();

		final double transportCost = this.transportCostCalculator.calculate(transportData);

		assertThat(transportCost, is(56.7));

	}

	@Test
	public void shouldReturn62dot7WhenWeight8AndPavementRoad100ForDumperTruck() {

		final TransportData transportData = TransportData
				.builder()
				.vehicleId(VehicleType.DUMPER_TRUCK.getId())
				.distanceInPavementRoad(100)
				.weightTon(8)
				.build();

		final double transportCost = this.transportCostCalculator.calculate(transportData);

		assertThat(transportCost, is(62.7));

	}


	@Test
	public void shouldReturn37dot2WhenWeight4AndUnpavementRoad60ForBoxTruck() {


		final TransportData transportData2 = TransportData
				.builder()
				.vehicleId(VehicleType.BOX_TRUCK.getId())
				.distanceInUnpavementRoad(60)
				.weightTon(4)
				.build();

		assertThat(this.transportCostCalculator.calculate(transportData2), is(37.2));
	}

	@Test
	public void shouldReturn150dot19WhenWeight12AndUnpavementRoad180ForSemiTractorTrailer() {


		final TransportData transportData3 = TransportData
				.builder()
				.vehicleId(VehicleType.SEMI_TRACTOR_TRAILER.getId())
				.distanceInUnpavementRoad(180)
				.weightTon(12)
				.build();

		assertThat(this.transportCostCalculator.calculate(transportData3), is(150.19));

	}

	@Test
	public void shouldReturn57dot6WhenWeight6AndPavementeRoad80AndUnpavementRoad20ForBoxTruck() {


		final TransportData transportData4 = TransportData
				.builder()
				.vehicleId(VehicleType.BOX_TRUCK.getId())
				.distanceInPavementRoad(80)
				.distanceInUnpavementRoad(20)
				.weightTon(6)
				.build();

		assertThat(this.transportCostCalculator.calculate(transportData4), is(57.6));

	}

	@Test
	public void shouldReturn47dot88WhenWeight5AndPavementRoad50AndUnpavementRoad30ForDumperTruck() {


		final TransportData transportData5 = TransportData
				.builder()
				.vehicleId(VehicleType.DUMPER_TRUCK.getId())
				.distanceInPavementRoad(50)
				.distanceInUnpavementRoad(30)
				.weightTon(5)
				.build();

		assertThat(this.transportCostCalculator.calculate(transportData5), is(47.88));

	}

}