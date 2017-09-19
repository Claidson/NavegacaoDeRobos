/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

/**
 *
 * @author aluno
 */
public class Transicoes {
    private String start;
    private String end;
    private double valor;
    private int tempo;
    
    public Transicoes(){
    }
    
    public Transicoes(String inicio, String fim, int tempo, double valor){
        this.start = inicio;
        this.end = fim;
        this.valor = valor;
        this.tempo = tempo;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public double getValue() {
        return valor;
    }

    public int getTempo() {
        return tempo;
    }
}
