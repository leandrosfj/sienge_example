package br.com.softplan.service.invoice;

import br.com.softplan.model.invoice.Invoice;
import br.com.softplan.util.NumberUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

class GeradorObservacao {

	private static final String OBS_PATTERN = "Fatura {0, choice, 1#da nota fiscal|1<das notas fiscais} de simples remessa: ";

	private static final String OBS_TOTAL_PATTERN = " Total = {0}.";

	private static final String OBS_INVOICE_LIST_DELIMITER = ", ";

	private static final String OBS_LAST_DELIMITER_REGEX_PATTERN = "(?s), (?!.*?, )";

	private static final String OBS_INVOICE_LIST_LAST_CONJUNCTION = " e ";

	private static final String OBS_INVOICE_LIST_SUFFIX = ".";

	@Deprecated
	public String geraObservacao(final List<Integer> lista) {

		if(CollectionUtils.isEmpty(lista)) {
			return "";
		}

		final String obsPrefix = MessageFormat.format(OBS_PATTERN, lista.size());

		return lista
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(OBS_INVOICE_LIST_DELIMITER, obsPrefix, OBS_INVOICE_LIST_SUFFIX))
				.replaceAll(OBS_LAST_DELIMITER_REGEX_PATTERN, OBS_INVOICE_LIST_LAST_CONJUNCTION);
	}

	public String geraObservacaoCompleta(final List<Invoice> lista) {

		if(CollectionUtils.isEmpty(lista)) {
			return "";
		}

		final double total = lista.stream().map(Invoice::getValue).mapToDouble(Double::doubleValue).sum();
		final String totalMsg = MessageFormat.format(OBS_TOTAL_PATTERN, NumberUtils.format(total));

		final String obsPrefix = MessageFormat.format(OBS_PATTERN, lista.size());

		return lista
				.stream()
				.map(Invoice::getDescription)
				.collect(Collectors.joining(OBS_INVOICE_LIST_DELIMITER, obsPrefix, OBS_INVOICE_LIST_SUFFIX))
				.replaceAll(OBS_LAST_DELIMITER_REGEX_PATTERN, OBS_INVOICE_LIST_LAST_CONJUNCTION)
				.concat(totalMsg);

	}

}