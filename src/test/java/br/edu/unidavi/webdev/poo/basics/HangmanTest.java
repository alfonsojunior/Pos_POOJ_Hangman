package br.edu.unidavi.webdev.poo.basics;

import org.junit.Test;

import org.junit.Assert;

public class HangmanTest {


	@Test
	public void deveRetornarPlaceHolderParaInstanceof(){
		Hangman hangman  = new Hangman("instanceof");
		String placeholder = hangman.jogar('u');
		Assert.assertEquals("**********", placeholder);
	}

	@Test
	public void deveRetornarPlaceHolderParaInstanceofComUmaLetraCerta(){
		Hangman hangman  = new Hangman("instanceof");
		String placeholder = hangman.jogar('i');
		Assert.assertEquals("i*********", placeholder);
	}


	@Test
	public void deveRetornarPlaceHolderParaFor(){
		Hangman hangman  = new Hangman("for");
		String placeholder = hangman.jogar('u');
		Assert.assertEquals("***", placeholder);
	}

	@Test
	public void deveRetornarPlaceHolderParaForComTodasCertas(){
		Hangman hangman  = new Hangman("for");
		String placeholder = hangman.jogar('u');
		placeholder = hangman.jogar('f');
		placeholder = hangman.jogar('o');
		placeholder = hangman.jogar('r');
		Assert.assertEquals("for", placeholder);
	}

	@Test
	public void deveVencerComApenas1Erro(){
		Hangman hangman  = new Hangman("for");
		String placeholder = hangman.jogar('u');
		placeholder = hangman.jogar('f');
		placeholder = hangman.jogar('o');
		placeholder = hangman.jogar('r');
		Assert.assertEquals(true, hangman.won());
		Assert.assertEquals(1, hangman.getWrongAttempts());
	}

	@Test
	public void devePerderApos6Erros(){
		Hangman hangman  = new Hangman("public");
		String placeholder = hangman.jogar('a');
		placeholder = hangman.jogar('e');
		placeholder = hangman.jogar('i');
		placeholder = hangman.jogar('o');
		placeholder = hangman.jogar('u');
		placeholder = hangman.jogar('s');
		placeholder = hangman.jogar('t');
		placeholder = hangman.jogar('l');
		placeholder = hangman.jogar('z');
		Assert.assertEquals(false, hangman.won());
		Assert.assertEquals(6, hangman.getWrongAttempts());
	}


}
