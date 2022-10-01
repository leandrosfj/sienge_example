package br.com.softplan.util;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@UtilityClass
public class NumberUtils {

	public static double toScaledDouble(final double value) {

		return BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}

	public static String format(final double value) {

		final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

		return decimalFormat.format(value);
	}

}
