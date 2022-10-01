package br.com.softplan.service.invoice;

import br.com.softplan.model.invoice.Invoice;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeradorObservacaoTest {

	private GeradorObservacao geradorObservacao;

	@Before
	public void setup() {

		this.geradorObservacao = new GeradorObservacao();

	}

	@Test
	public void shouldReturnObsInPluralFormWithInvoiceIds() {

		final List<Integer> invoiceIdList = Arrays.asList(1, 2);
		final List<Integer> invoiceIdList1 = Arrays.asList(6, 7, 8, 9, 10);
		final List<Integer> invoiceIdList2 = Arrays.asList(11, 12, 13, 14, 98715);

		assertEquals("Fatura das notas fiscais de simples remessa: 1 e 2.", this.geradorObservacao.geraObservacao(invoiceIdList));
		assertEquals("Fatura das notas fiscais de simples remessa: 6, 7, 8, 9 e 10.", this.geradorObservacao.geraObservacao(invoiceIdList1));
		assertEquals("Fatura das notas fiscais de simples remessa: 11, 12, 13, 14 e 98715.", this.geradorObservacao.geraObservacao(invoiceIdList2));

	}

	@Test
	public void shouldReturnObsInSingularFormWithInvoiceId() {

		final List<Integer> invoiceIdList = Collections.singletonList(1);

		assertEquals("Fatura da nota fiscal de simples remessa: 1.", this.geradorObservacao.geraObservacao(invoiceIdList));
	}

	@Test
	public void shouldReturnObsInPluralFormaWhitInvoicList() {

		final String expectedObs = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30. Total = 1.550,30.";

		final List<Invoice> invoices = new ArrayList<>();

		invoices.add(Invoice.builder().cod(1).value(10.0).build());
		invoices.add(Invoice.builder().cod(2).value(35.0).build());
		invoices.add(Invoice.builder().cod(3).value(5.0).build());
		invoices.add(Invoice.builder().cod(4).value(1500.0).build());
		invoices.add(Invoice.builder().cod(5).value(0.3).build());


		assertEquals(expectedObs, this.geradorObservacao.geraObservacaoCompleta(invoices));
	}

	@Test
	public void shouldReturnObsInSingularFormaWhitInvoicListOfOneElement() {

		final String expectedObs = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 10,00. Total = 10,00.";

		final List<Invoice> invoices = new ArrayList<>();

		invoices.add(Invoice.builder().cod(1).value(10.0).build());

		assertEquals(expectedObs, this.geradorObservacao.geraObservacaoCompleta(invoices));
	}


}