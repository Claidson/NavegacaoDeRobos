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
        Queue<Nodo> fila = new LinkedList<Nodo>();
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (nodo[i][j].getChegada()){a[0]=i;a[1]=j;}
                if (nodo[i][j].getSaida()){b[0]=i;b[1]=j;}
            }
        }

        return nodo;
    }

}
