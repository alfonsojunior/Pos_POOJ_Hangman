package br.com.thiago.jessica.alfonso.jogodearitmetica;

public class Expressao implements Cloneable {

	private Operacao op;
	private Integer n1 = 0, n2 = 0;
	private Double resposta = Double.valueOf("0");

	public Expressao(Operacao op, Integer n1, Integer n2) {
		this.op = op;
		this.n1 = n1;
		this.n2 = n2;
		if (n1 < n2) {
			int naux = this.n1;
			this.n1 = this.n2;
			this.n2 = naux;
		}
		switch (op) {
		case ADICAO:
			resposta = Double.valueOf(this.n1 + this.n2);
			break;
		case SUBTRACAO:
			resposta = Double.valueOf(this.n1 - this.n2);
			break;
		case MULTIPLICACAO:
			resposta = Double.valueOf(this.n1 * this.n2);
			break;
		case DIVISAO:
			resposta = Double.valueOf(this.n1 / this.n2);
			break;
		}
	}

	public String toString() {
		return n1 + op.getOperacaoString() + n2;
	}

	public Double getResposta() {
		return this.resposta;
	}

}
