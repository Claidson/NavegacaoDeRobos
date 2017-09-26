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
 * @author Claidson
 */
public class BuscaUniforme {
    
    public BuscaUniforme() {
    }

    public String buscar(Nodo nodo[][]) {
        Queue<Nodo> filaNodo = new LinkedList<Nodo>();

        for (int i = 1; i < 51; i++) {
            
            //pega o ponto inicial e a partir dele coloca  na fila 
            for (int j = 1; j < 51; j++) {
                if (nodo[i][j].getChegada()) {
                    nodo[i][j].setVisitadoA(Boolean.TRUE);
                    nodo[i][j].setCaminho(i + ";" + j);
                    filaNodo.add(nodo[i][j]);
                }
                if (nodo[i][j].getSaida()) {
                    nodo[i][j].setVisitadoB(Boolean.TRUE);
                    nodo[i][j].setCaminho(";" + i + ";" + j);
                    System.out.println(" i e j" +i+ " "+ j);
                }
            }

        }
        while (!filaNodo.isEmpty()) {
            int linha;
            int coluna;
            if (!filaNodo.isEmpty()) {
                
                //pega o ultimo e atribui linha e coluna
                Nodo nodoFila = filaNodo.remove();
                String caminho = nodoFila.getCaminho();
                
                linha = nodoFila.getI() + 1;
                coluna = nodoFila.getJ();
                /*[ ][ ][ ]
                  [ ][x][ ]
                  [ ][x][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
                coluna++;
                linha--;
                   /*[ ][ ][ ]
                     [ ][x][x]
                     [ ][ ][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
                linha--;
                coluna--;
                 /*[ ][x][ ]
                   [ ][x][ ]
                   [ ][ ][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
                linha++;
                coluna--;
                 /*[ ][ ][ ]
                   [x][x][ ]
                   [ ][ ][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
                
                //diagonais
                
                
                   linha++;
                 /*[ ][ ][ ]
                   [ ][x][ ]
                   [x][x][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
                 
                coluna = coluna + 2;
                /*[ ][ ][ ]
                   [ ][x][ ]
                   [ ][ ][x]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
               
                linha = linha - 2;
                  /*[ ][ ][x]
                    [ ][x][ ]
                    [ ][ ][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
               
                coluna = coluna - 2;
                  /*[x][ ][ ]
                    [ ][x][ ]
                    [ ][ ][ ]*/
                if (Verifica(nodo, linha, coluna, caminho, filaNodo)) {
                    return caminho + nodo[linha][coluna].getCaminho();
                }
            }

        }

        return "Algo que esta errado nao esta certo";
    }

    public boolean Verifica(Nodo[][] nodo, int i, int j, String caminho, Queue<Nodo> filaA) {
        if (nodo[i][j] != null) {
            if (!nodo[i][j].getVisitadoA()) {
                if (!nodo[i][j].getEstado()) {
                    if (!nodo[i][j].getVisitadoB()) {
                        nodo[i][j].setVisitadoA(Boolean.TRUE);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                        filaA.add(nodo[i][j]);
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
