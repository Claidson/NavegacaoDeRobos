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
    private Boolean visitado;
    private String caminho;
    private float peso;

    public Nodo() {
        this.estado = false;
        this.visitado = false;
        this.caminho = "";
        this.peso = 0;
    }

    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
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
    
    
    
    
}
