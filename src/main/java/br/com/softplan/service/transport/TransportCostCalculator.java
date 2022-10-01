package br.com.softplan.service.transport;

import br.com.softplan.enums.RoadType;
import br.com.softplan.model.transport.TransportData;
import br.com.softplan.util.NumberUtils;

public class TransportCostCalculator {

	private static final Double PLUS_PER_KM_WHEN_OVER_WEIGHT = 0.02;

	private static final Integer MAX_WEIGHT_TON = 5;


	public double calculate(final TransportData transportData) {

		if(transportData == null || !transportData.isValid()) {
			return 0d;
		}

		final double pavementRoadCost = this.calculatePavementRoadCost(transportData);

		final double unpavementRoadCost = this.calculateUnpavementRoadCost(transportData);

		final double extraWeightCost = this.calculateExtraWeightCost(transportData);

		final double vehicleMultiplyingFactor = transportData.getVehicleType().getMultiplyingFactor();

		final double transportCost = ((pavementRoadCost + unpavementRoadCost) * vehicleMultiplyingFactor) + extraWeightCost;

		return NumberUtils.toScaledDouble(transportCost);
	}

	private double calculatePavementRoadCost(final TransportData transportData) {

		return transportData.getDistanceInPavementRoad() * RoadType.PAVEMENT_ROAD.getPricePerKm();
	}

	private double calculateUnpavementRoadCost(final TransportData transportData) {

		return transportData.getDistanceInUnpavementRoad() * RoadType.UNPAVEMENT_ROAD.getPricePerKm();
	}

	private int calculateExtraWeigthTon(final TransportData transportData) {

		return transportData.getWeightTon() <= MAX_WEIGHT_TON ? 0 : transportData.getWeightTon() - MAX_WEIGHT_TON;
	}

	private double calculateExtraWeightCost(final TransportData transportData) {

		final int extraWeigth = this.calculateExtraWeigthTon(transportData);

		return extraWeigth * PLUS_PER_KM_WHEN_OVER_WEIGHT * transportData.getTotalDistance();
	}


}
