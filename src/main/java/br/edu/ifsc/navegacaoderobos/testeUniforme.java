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
public class testeUniforme {
    public static void main(String[] args) {
 
		
		Nodo no0 = new Nodo(0);
		Nodo no1 = new Nodo(1);
		Nodo no2 = new Nodo(2);
                Nodo no3 = new Nodo(3);
		Nodo no4 = new Nodo(4);
		Nodo no5 = new Nodo(5);
		Nodo no6 = new Nodo(6);
		
		no0.setNoEsquerda(no1);
		no0.setNoDireita(no2);
		
		no1.setNoEsquerda(no3);
		no1.setNoDireita(no4);
		
		no2.setNoEsquerda(no5);
		no2.setNoDireita(no6);
				
	
		
	
		BuscaDeCustoUniformeArvore bcu = new BuscaDeCustoUniformeArvore(6);
		bcu.buscarResultado(no0);
		bcu.exibirTextoResultado();
    }
}
