package br.com.thiago.jessica.alfonso.jogodearitmetica;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JogoAritmeticaTest {

	@Test(expected=AssertionError.class)
	public void deveRetornarErroSemTerminarJogo() {
		Operacao[] op = new Operacao[] {Operacao.ADICAO};
		JogoAritmetica jg = new JogoAritmetica(6, 1, 10, op);
		
		jg.setExpressao(Operacao.ADICAO, 1, 2);
		Assert.assertEquals("2+1", jg.getExpressao());
		String resp = jg.jogar(3.0);
		Assert.assertEquals("OK", resp);
		
		jg.setExpressao(Operacao.ADICAO, 9, 8);
		Assert.assertEquals("9+8", jg.getExpressao());
		resp = jg.jogar(17.0);
		Assert.assertEquals("OK", resp);
		
		Assert.assertEquals(false, jg.won());
		
		jg.setExpressao(Operacao.ADICAO, 4, 4);
		Assert.assertEquals("4+4", jg.getExpressao());
		resp = jg.jogar(9.0);
		Assert.assertEquals("ERR", resp);
		
		jg.setExpressao(Operacao.ADICAO, 1, 4);
		Assert.assertEquals("4+1", jg.getExpressao());
		resp = jg.jogar(5.0);
		Assert.assertEquals("OK", resp);
		
		Assert.assertEquals(true, jg.won());
	}
	
	@Test
	public void deveFuncionar() {
		Operacao[] op = new Operacao[] {Operacao.ADICAO};
		JogoAritmetica jg = new JogoAritmetica(6, 1, 10, op);
		
		jg.setExpressao(Operacao.ADICAO, 1, 2);
		Assert.assertEquals("2+1", jg.getExpressao());
		String resp = jg.jogar(3.0);
		Assert.assertEquals("OK", resp);
		
		jg.setExpressao(Operacao.ADICAO, 9, 8);
		Assert.assertEquals("9+8", jg.getExpressao());
		resp = jg.jogar(17.0);
		Assert.assertEquals("OK", resp);
		
		Assert.assertEquals(false, jg.won());
		
		jg.setExpressao(Operacao.ADICAO, 4, 4);
		Assert.assertEquals("4+4", jg.getExpressao());
		resp = jg.jogar(9.0);
		Assert.assertEquals("ERR", resp);
		
		jg.setExpressao(Operacao.ADICAO, 1, 4);
		Assert.assertEquals("4+1", jg.getExpressao());
		resp = jg.jogar(5.0);
		Assert.assertEquals("OK", resp);
		
		jg.setExpressao(Operacao.ADICAO, 3, 5);
		Assert.assertEquals("5+3", jg.getExpressao());
		resp = jg.jogar(8.0);
		Assert.assertEquals("OK", resp);
		
		jg.setExpressao(Operacao.ADICAO, 7, 2);
		Assert.assertEquals("7+2", jg.getExpressao());
		resp = jg.jogar(8.0);
		Assert.assertEquals("ERR", resp);
		
		jg.setExpressao(Operacao.ADICAO, 1, 6);
		Assert.assertEquals("6+1", jg.getExpressao());
		resp = jg.jogar(7.0);
		Assert.assertEquals("OK", resp);
		
		jg.setExpressao(Operacao.ADICAO, 9, 3);
		Assert.assertEquals("9+3", jg.getExpressao());
		resp = jg.jogar(12.0);
		Assert.assertEquals("OK", resp);
		
		jg.setExpressao(Operacao.ADICAO, 2, 1);
		Assert.assertEquals("2+1", jg.getExpressao());
		resp = jg.jogar(2.0);
		Assert.assertEquals("ERR", resp);
		
		Expressao exp = new Expressao(Operacao.ADICAO, 7, 3);
		Assert.assertEquals("7+3", exp.toString());
		resp = jg.jogar(10.0, exp);
		Assert.assertEquals("OK", resp);
		
		Assert.assertEquals(true, jg.won());
	}

}
