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
 * @author aluno
 */
public class BuscaUniforme {
    
    public BuscaUniforme() {
    }

    public String buscar(Nodo nodo[][]) {
        Queue<Nodo> filaNodo = new LinkedList<Nodo>();

        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (nodo[i][j].getChegada()) {
                    nodo[i][j].setVisitadoA(Boolean.TRUE);
                    nodo[i][j].setCaminho(i + ";" + j);
                    filaNodo.add(nodo[i][j]);
                }
                if (nodo[i][j].getSaida()) {
                    nodo[i][j].setVisitadoB(Boolean.TRUE);
                    nodo[i][j].setCaminho(";" + i + ";" + j);
                }
            }

        }
        while (!filaNodo.isEmpty()) {
            int i;
            int j;
            if (!filaNodo.isEmpty()) {
                Nodo nodoA = filaNodo.remove();
                String caminho = nodoA.getCaminho();
                i = nodoA.getI() + 1;
                j = nodoA.getJ();
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                j++;
                i--;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                i--;
                j--;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                i++;
                j--;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                i++;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                j = j + 2;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                i = i - 2;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
                }
                j = j - 2;
                if (Verifica(nodo, i, j, caminho, filaNodo)) {
                    return caminho + nodo[i][j].getCaminho();
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
