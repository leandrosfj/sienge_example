package br.com.softplan.util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumberUtilsTest {

	@Test
	public void shouldReturn0When0isScaledDouble() {

		final double value = 0.0;

		assertThat(NumberUtils.toScaledDouble(value), is(0.0));
	}

	@Test
	public void shouldReturn100dot55When100dot553isScaledDouble() {

		final double value = 100.553;

		assertThat(NumberUtils.toScaledDouble(value), is(100.55));
	}


	@Test
	public void shouldReturn100dot55When100dot554isScaledDouble() {

		final double value = 100.554;

		assertThat(NumberUtils.toScaledDouble(value), is(100.55));
	}


	@Test
	public void shouldReturn100dot56When100dot555isScaledDouble() {

		final double value = 100.555;

		assertThat(NumberUtils.toScaledDouble(value), is(100.56));
	}


	@Test
	public void shouldReturn100dot56When100dot556isScaledDouble() {

		final double value = 100.556;

		assertThat(NumberUtils.toScaledDouble(value), is(100.56));
	}

	@Test
	public void shouldReturn100comma00whenFormated() {

		final double value = 100.0;

		assertThat(NumberUtils.format(value), is("100,00"));
	}


	@Test
	public void shouldReturn100comma30whenFormated() {

		final double value = 100.3;

		assertThat(NumberUtils.format(value), is("100,30"));
	}


	@Test
	public void shouldReturn1dot500comma00whenFormated() {

		final double value = 1500.0;

		assertThat(NumberUtils.format(value), is("1.500,00"));
	}


	@Test
	public void shouldReturn0comma50whenFormated() {

		final double value = 0.5;

		assertThat(NumberUtils.format(value), is("0,50"));
	}


	@Test
	public void shouldReturn15dot644dot750comma37whenFormated() {

		final double value = 15644750.37;

		assertThat(NumberUtils.format(value), is("15.644.750,37"));
	}

	@Test
	public void shouldReturn0comma00When0dot0IsFormated() {

		final double value = 0.0;

		assertThat(NumberUtils.format(value), is("0,00"));
	}

	@Test
	public void shouldReturn100comma55When100dot553IsFormated() {

		final double value = 100.553;

		assertThat(NumberUtils.format(value), is("100,55"));
	}


	@Test
	public void shouldReturn100comma55When100dot554IsFormated() {

		final double value = 100.554;

		assertThat(NumberUtils.format(value), is("100,55"));
	}


	@Test
	public void shouldReturn100comma56When100dot555IsFormated() {

		final double value = 100.555;

		assertThat(NumberUtils.format(value), is("100,56"));
	}


	@Test
	public void shouldReturn100comma56When100dote556IsFormated() {

		final double value = 100.556;

		assertThat(NumberUtils.format(value), is("100,56"));
	}


}