package br.com.softplan.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoadType {

	PAVEMENT_ROAD("Pavimentada", 0.54),
	UNPAVEMENT_ROAD("Não Pavimentada", 0.62);


	private final String roadTypeDescription;

	private final double pricePerKm;
}
