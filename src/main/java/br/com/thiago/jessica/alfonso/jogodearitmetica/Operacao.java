/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiago.jessica.alfonso.jogodearitmetica;

/**
 *
 * @author blinkn
 */
public enum Operacao {
    
    ADICAO(1), SUBTRACAO(2), MULTIPLICACAO(3), DIVISAO(4);
    
    private final int operacao;

    private Operacao(int operacao) {
        this.operacao = operacao;
    }

    public int getOperacao() {
        return operacao;
    }
    
    public String getOperacaoString() {
    	switch (operacao) {
    		case 1:
    			return "+";
    		case 2:
    			return "-";
    		case 3:
    			return "*";
    		case 4:
    			return "/";
    		default:
    			return "";
    	}
    }
    

}
