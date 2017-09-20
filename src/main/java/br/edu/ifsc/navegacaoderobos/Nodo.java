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
public class Nodo {
    private Boolean estado;
    private Boolean saida;
    private Boolean chegada;
    private Boolean visitadoA;
    private Boolean visitadoB;
    private String caminho;
    private float peso;
    private int i;
    private int j;
    public String rotulo;
    public int pai = -1;
    public Boolean foiVisitado;
    
        public Nodo(String rot) {
        rotulo = rot;
        visitadoA = false;

    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getPai() {
        return this.pai;
    }

    public Nodo(int i, int j) {
        this.i = i;
        this.j = j;
        this.estado = false;
        this.visitadoA = false;
        this.visitadoB = false;
        this.chegada = false;
        this.saida = false;
        this.caminho = "";
        this.peso = 0;
    }

    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getVisitadoA() {
        return visitadoA;
    }

    public void setVisitadoA(Boolean visitadoA) {
        this.visitadoA = visitadoA;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public Boolean getSaida() {
        return saida;
    }

    public void setSaida(Boolean saida) {
        this.saida = saida;
    }

    public Boolean getChegada() {
        return chegada;
    }

    public void setChegada(Boolean chegada) {
        this.chegada = chegada;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
        public Boolean getVisitadoB() {
        return visitadoB;
    }

    public void setVisitadoB(Boolean visitadoB) {
        this.visitadoB = visitadoB;
    }
    
    
}
