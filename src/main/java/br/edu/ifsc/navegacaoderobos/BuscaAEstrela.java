/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

import java.util.ArrayList;

/**
 *
 * @author Marcao
 */
public class BuscaAEstrela {

    Nodo nodoAtual = new Nodo(0, 0);
    int x, y;

    public BuscaAEstrela() {
    }

    public String buscar(Nodo[][] nodo) {
        nodoAtual.setPeso(1000);
        ArrayList<Nodo> lista = new ArrayList();
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (nodo[i][j].getSaida()) {
                    nodo[i][j].setVisitadoB(Boolean.TRUE);
                    nodo[i][j].setCaminho(i + ";" + j);
                    lista.add(nodo[i][j]);
                }
                if (nodo[i][j].getChegada()) {
                    x = i;
                    y = j;
                }
            }
        }
        while (!lista.isEmpty()) {
            nodoAtual = lista.get(0);
            int teste = 0;
            int remove = 0;
            for (Nodo no : lista) {
                teste++;
                if ((no.getPeso() + previsaoPeso(no)) < (nodoAtual.getPeso() + previsaoPeso(nodoAtual))) {
                    nodoAtual = no;
                    remove = teste-1;
                }
            }
            nodoAtual.setVisitadoB(Boolean.TRUE);
            lista.remove(remove);
            String caminho = nodoAtual.getCaminho();
            int i = nodoAtual.getI() + 1;
            int j = nodoAtual.getJ();
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            j++;
            i--;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            i--;
            j--;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            i++;
            j--;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                                                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            i++;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                                                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1.4)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            j = j + 2;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                                                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1.4)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            i = i - 2;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                                                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1.4)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
            j = j - 2;
            if (nodo[i][j] != null) {
                if (!nodo[i][j].getVisitadoA()) {
                    if (!nodo[i][j].getEstado()) {
                        if (!nodo[i][j].getChegada()) {
                            nodo[i][j].setVisitadoA(Boolean.TRUE);
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                            lista.add(nodo[i][j]);
                        } else {
                            nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                            System.out.println(nodo[i][j].getPeso());
                            return caminho + ";" + i + ";" + j;
                        }
                    }
                } else {
                    if ((nodo[i][j].getPeso()) > (nodoAtual.getPeso() + 1.4)) {
                        nodo[i][j].setPeso(nodoAtual.getPeso() + 1.4);
                        nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                    }

                }
            }
        }

    return new String();
}



    

    public double previsaoPeso(Nodo nodo) {
        double a = Math.abs(nodo.getI() - x);
        double b = Math.abs(nodo.getJ() - y);
        if (a>b){
            return ((b*1.4) + (a-b));
        }else{
            return ((a*1.4) + (b-a));
        }            
       
    }
}
