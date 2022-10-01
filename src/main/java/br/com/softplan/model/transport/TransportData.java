package br.com.softplan.model.transport;


import br.com.softplan.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportData {

	private int distanceInPavementRoad;

	private int distanceInUnpavementRoad;

	private int vehicleId;

	private int weightTon;

	public VehicleType getVehicleType() {

		return VehicleType.valueOf(this.vehicleId);
	}

	public int getTotalDistance() {

		return this.distanceInPavementRoad + this.distanceInUnpavementRoad;

	}

	public boolean isValid() {

		return VehicleType.valueOf(this.vehicleId) != null && (this.distanceInPavementRoad > 0 || this.distanceInUnpavementRoad > 0);
	}

}
