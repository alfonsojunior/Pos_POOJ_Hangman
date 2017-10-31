package br.com.thiago.jessica.alfonso.jogodearitmetica;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ExpressaoTest {

	@Test
	public void test1() {
		Expressao exp = new Expressao(Operacao.ADICAO, 2, 2);
		Assert.assertEquals(Double.valueOf(4), exp.getResposta());
		Assert.assertEquals("2+2", exp.toString());
	}
	
	@Test
	public void test2() {
		Expressao exp = new Expressao(Operacao.SUBTRACAO, 2, 2);
		Assert.assertEquals(Double.valueOf(0), exp.getResposta());
		Assert.assertEquals("2-2", exp.toString());
	}

}
