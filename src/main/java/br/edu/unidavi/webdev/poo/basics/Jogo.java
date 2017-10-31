package br.edu.unidavi.webdev.poo.basics;

public abstract class Jogo<R,V> {
	
	public abstract R jogar(V valor);
	public abstract boolean won();
	
	public boolean lost() {
		return !won();
	}
	
}
