package br.com.softplan.model.invoice;

import br.com.softplan.util.NumberUtils;
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
public class Invoice {

	private int cod;

	private double value;

	public String getDescription() {

		return this.cod + " cujo valor é R$ " + NumberUtils.format(this.value);
	}

}
