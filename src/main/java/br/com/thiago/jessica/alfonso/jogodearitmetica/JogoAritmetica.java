/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiago.jessica.alfonso.jogodearitmetica;

import static br.com.thiago.jessica.alfonso.jogodearitmetica.Operacao.ADICAO;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import br.edu.unidavi.webdev.poo.basics.Jogo;

/**
 *
 * @author blinkn
 */
public class JogoAritmetica extends Jogo<String, Double> {
    
    //private int respostaCorreta;
    private int pontosMinimos;
    private int pontosPorAcerto;
    private int numeroExpressoes;
    private int pontos;
    private Operacao[] operacoes;
    private Expressao expressao = null;

    public JogoAritmetica(int pontosMinimos, int pontosPorAcerto, int numeroExpressoes, Operacao[] operacoes){
        this.pontosMinimos = pontosMinimos;
        this.pontosPorAcerto = pontosPorAcerto;
        this.numeroExpressoes = numeroExpressoes;
        this.operacoes = operacoes;
    }
    
    public void run() {
    	Scanner scanner = new Scanner(System.in);
    	do {
    		Random rand = new Random();
    		int posOperacao = rand.nextInt( operacoes.length );
    		int n1 = rand.nextInt(10)+1;
            int n2 = rand.nextInt(10)+1;
            setExpressao(operacoes[posOperacao], n1, n2);
            System.out.println(this.expressao);
            double resposta = scanner.nextInt();
            jogar(resposta);
    	} while(this.numeroExpressoes > 0);
    }
    
    public void setExpressao(Operacao op, int n1, int n2) {
    	this.expressao = new Expressao(op, n1, n2);
    	this.numeroExpressoes--;
    }
    
    public String getExpressao() {
    	return this.expressao.toString();
    }

    public String jogar(Double resp) {
        if (resp.doubleValue() == this.expressao.getResposta().doubleValue()) {
        	this.pontos += this.pontosPorAcerto;
        	return "OK";
        } else {
        	return "ERR";
        }
    }
    
    public boolean won(){
        return this.pontos >= this.pontosMinimos && this.numeroExpressoes <= 0;
    }
   
    public static void main(String[] args){
    	Operacao[] op = new Operacao[] {Operacao.ADICAO, Operacao.SUBTRACAO};
        JogoAritmetica jogo = new JogoAritmetica(2, 1, 3, op);
        jogo.run();
        //jogo.setExpressao(Operacao.ADICAO, 1, 3);
        System.out.println(jogo.won());
    }
    
}
