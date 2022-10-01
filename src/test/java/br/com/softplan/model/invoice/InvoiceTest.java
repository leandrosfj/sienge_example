package br.com.softplan.model.invoice;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InvoiceTest {

	@Test
	public void shoulReturnCodAndValueInDescriptionFormat() {

		final Invoice invoice = Invoice.builder().cod(1).value(100.52).build();

		assertThat("1 cujo valor é R$ 100,52", is(invoice.getDescription()));
	}

}