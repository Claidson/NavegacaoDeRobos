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
    private Boolean resultado;

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }
    private String caminho;
    private double peso;
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
        this.resultado = false;
        
       // this.valor = valor;
	//this.custo = custo;
        
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
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
    
    
    private int valor;// Busca uniforme
	
	private int custo;
	
	private Nodo noPai;	
	private Nodo noEsquerda;
	private Nodo noDireita;
	
	public Nodo(int valor) {
		this.valor = valor;
		this.custo = 0;
	}
	
	
	public int getValor() {
		return valor;
	}

	public Nodo getNoEsquerda() {
		return noEsquerda;
	}

	public void setNoEsquerda(Nodo noEsquerda) {
		this.noEsquerda = noEsquerda;
		this.noEsquerda.setNoPai(this);
	}

	public Nodo getNoDireita() {
		return noDireita;
	}

	public void setNoDireita(Nodo noDireita) {
		this.noDireita = noDireita;
		this.noDireita.setNoPai(this);
	}

	public Nodo getNoPai() {
		return noPai;
	}

	public void setNoPai(Nodo noPai) {
		this.noPai = noPai;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
    
}
