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

/**
 *
 * @author blinkn
 */
public class JogoAritmetica {
    
    private int respostaCorreta;
    private int pontosMinimos;
    private int pontosPorAcerto;
    private int numeroExpressoes;
    private int pontos;
    private Operacao[] operacoes;

    public JogoAritmetica(int pontosMinimos, int pontosPorAcerto, int numeroExpressoes, Operacao[] operacoes){
        this.pontosMinimos = pontosMinimos;
        this.pontosPorAcerto = pontosPorAcerto;
        this.numeroExpressoes = numeroExpressoes;
        this.operacoes = operacoes;
    }
    
    private String geraExpressao(Operacao operacao){
        Random rand = new Random();
        int n1 = rand.nextInt(10)+1;
        int n2 = rand.nextInt(10)+1;
        switch(operacao){
            case ADICAO:
                this.respostaCorreta = n1+n2;
                return n1+"+"+n2;
            case SUBTRACAO:
                this.respostaCorreta = n1-n2;
                return n1+"-"+n2;
            case MULTIPLICACAO:
                this.respostaCorreta = n1*n2;
                return n1+"*"+n2;
            case DIVISAO:
                this.respostaCorreta = n1/n2;
                return n1+"/"+n2;
            default: 
                return "Operacao nao definida";              
        }
    }

    public void jogar() {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        do {
            int posOperacao = rand.nextInt( operacoes.length );
            String expressao = geraExpressao(operacoes[posOperacao]);
            System.out.println(expressao);
            int resposta = scanner.nextInt();
            if (resposta == this.respostaCorreta){
                this.pontos += this.pontosPorAcerto;
            }
            this.numeroExpressoes--;
        } while(this.numeroExpressoes > 0);
        
        won();
       
    }
    
    public void won(){
        if(pontos >= this.pontosMinimos){
            System.out.println("Venceu!");
        }else{
            System.out.println("Perdeu");
        }
    }
   
    public static void main(String[] args){
    	//ArrayList<Operacao> op = new ArrayList<Operacao>();
    	Operacao[] op = new Operacao[] {Operacao.ADICAO, Operacao.SUBTRACAO};
        JogoAritmetica jogo = new JogoAritmetica(6, 1, 10, op);
        jogo.jogar();
    }
    
}
