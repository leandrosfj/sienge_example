package br.com.softplan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum VehicleType {

	BOX_TRUCK(1, "Caminhão Baú", 1.0),
	DUMPER_TRUCK(2, "Caminhão Caçamba", 1.05),
	SEMI_TRACTOR_TRAILER(3, "Carreta", 1.12);

	private final int id;

	private final String typeDescription;

	private final double multiplyingFactor;

	public static VehicleType valueOf(final int id) {

		switch (id) {
			case 1:
				return BOX_TRUCK;
			case 2:
				return DUMPER_TRUCK;
			case 3:
				return SEMI_TRACTOR_TRAILER;
			default:
				return null;
		}
	}
}
