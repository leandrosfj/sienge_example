package br.com.softplan;

import br.com.softplan.enums.VehicleType;
import br.com.softplan.model.transport.TransportData;
import br.com.softplan.service.transport.TransportCostCalculator;

import java.util.ArrayList;
import java.util.List;

class Main {


	public static void main(final String[] args) {

		final List<TransportData> transports = new ArrayList<>();

		transports.add(TransportData
				.builder()
				.vehicleId(VehicleType.DUMPER_TRUCK.getId())
				.distanceInPavementRoad(100)
				.weightTon(8)
				.build());

		transports.add(TransportData
				.builder()
				.vehicleId(VehicleType.BOX_TRUCK.getId())
				.distanceInUnpavementRoad(60)
				.weightTon(4)
				.build());

		transports.add(TransportData
				.builder()
				.vehicleId(VehicleType.SEMI_TRACTOR_TRAILER.getId())
				.distanceInUnpavementRoad(180)
				.weightTon(12)
				.build());

		transports.add(TransportData
				.builder()
				.vehicleId(VehicleType.BOX_TRUCK.getId())
				.distanceInPavementRoad(80)
				.distanceInUnpavementRoad(20)
				.weightTon(6)
				.build());

		transports.add(TransportData
				.builder()
				.vehicleId(VehicleType.DUMPER_TRUCK.getId())
				.distanceInPavementRoad(50)
				.distanceInUnpavementRoad(30)
				.weightTon(5)
				.build());

		logResultToConsole(transports);
	}

	private static void logResultToConsole(final List<TransportData> transports) {

		final TransportCostCalculator transportCostCalculator = new TransportCostCalculator();
		final List<Double> transportCosts = new ArrayList<>();

		final String header = "|      Vehicle      | Pavement Road Distance | Unpavement Road Distance | Total Distance | Weight (Tons) | Transport Cost |";
		final String rowFormat = "| %-17s | %19d Km | %21d Km | %11d Km | %11d t | %14.2f |%n";
		final String summaryFormat = "|                                                                                    Total Transport Cost: %14.2f |%n";
		final String separator = "---------------------------------------------------------------------------------------------------------------------------";

		System.out.println(separator);
		System.out.println(header);
		System.out.println(separator);

		transports.forEach(transportData -> {

			final Double transportCost = transportCostCalculator.calculate(transportData);

			transportCosts.add(transportCost);

			System.out.printf(rowFormat, transportData.getVehicleType().getTypeDescription(), transportData.getDistanceInPavementRoad(), transportData.getDistanceInUnpavementRoad(), transportData.getTotalDistance(), transportData.getWeightTon(), transportCost);
		});

		System.out.println(separator);

		final Double totalTransportCust = transportCosts.stream().mapToDouble(Double::doubleValue).sum();
		System.out.printf(summaryFormat, totalTransportCust);

		System.out.println(separator);
	}

}
