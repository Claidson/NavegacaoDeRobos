/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Fernando
 */
public class BuscaBidirecional {

    public BuscaBidirecional() {
    }

    public Nodo[][] buscar(Nodo nodo[][]) {
        int a[] = null;
        int b[] = null;
        Queue<Nodo> filaA = new LinkedList<Nodo>();
        Queue<Nodo> filaB = new LinkedList<Nodo>();
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (nodo[i][j].getChegada()){a[0]=i;a[1]=j;nodo[i][j].setVisitadoA(Boolean.TRUE);filaA.add(nodo[i][j]);}
                if (nodo[i][j].getSaida()){b[0]=i;b[1]=j;nodo[i][j].setVisitadoB(Boolean.TRUE);filaB.add(nodo[i][j]);}
            }
            if ((a==null)||(b==null)){
                System.out.println("Erro: Inicio ou chegada selecionado!");
                return null;
            }
        }/*
        while (!filaA.isEmpty() || !filaB.isEmpty()){
            Nodo nodoA = filaA.remove();
            int i = nodoA.getI()-1;
            int j = nodoA.getJ()-1;
            if (nodo[i][j]!=null)
                if (!nodo[i][j].getVisitadoA())
                    if (!nodo[i][j].getEstado())        
            
            
            
            
            
            
        }*/
        

        return nodo;
    }

}
