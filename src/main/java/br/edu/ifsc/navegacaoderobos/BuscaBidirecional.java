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

    public String buscar(Nodo nodo[][]) {
        Queue<Nodo> filaA = new LinkedList<Nodo>();
        Queue<Nodo> filaB = new LinkedList<Nodo>();
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (nodo[i][j].getSaida()) {
                    nodo[i][j].setVisitadoA(Boolean.TRUE);
                    nodo[i][j].setCaminho(i + ";" + j);
                    filaA.add(nodo[i][j]);
                }
                if (nodo[i][j].getChegada()) {
                    nodo[i][j].setVisitadoB(Boolean.TRUE);
                    nodo[i][j].setCaminho(";" + i + ";" + j);
                    filaB.add(nodo[i][j]);
                }
            }
        }
        while (!filaA.isEmpty() || !filaB.isEmpty()) {
            int i;
            int j;
            if (!filaA.isEmpty()) {
                Nodo nodoA = filaA.remove();
                String caminho = nodoA.getCaminho();
                i = nodoA.getI() + 1;
                j = nodoA.getJ();
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                j++;
                i--;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                i--;
                j--;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                i++;
                j--;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                i++;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                j = j + 2;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                i = i - 2;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
                j = j - 2;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoA()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoB()) {
                                nodo[i][j].setVisitadoA(Boolean.TRUE);
                                nodo[i][j].setCaminho(caminho + ";" + i + ";" + j);
                                filaA.add(nodo[i][j]);
                            } else {
                                return caminho+nodo[i][j].getCaminho();
                            }
                        }
                    }
                }
            }
            if (!filaB.isEmpty()) {
                Nodo nodoB = filaB.remove();
                String caminho = nodoB.getCaminho();
                i = nodoB.getI() + 1;
                j = nodoB.getJ();
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                j++;
                i--;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                i--;
                j--;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                i++;
                j--;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                i++;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                j = j + 2;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                i = i - 2;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
                j = j - 2;
                if (nodo[i][j] != null) {
                    if (!nodo[i][j].getVisitadoB()) {
                        if (!nodo[i][j].getEstado()) {
                            if (!nodo[i][j].getVisitadoA()) {
                                nodo[i][j].setVisitadoB(Boolean.TRUE);
                                nodo[i][j].setCaminho(";" + i + ";" + j + caminho);
                                filaB.add(nodo[i][j]);
                            } else {
                                return nodo[i][j].getCaminho()+caminho;
                            }
                        }
                    }
                }
            }
        }

        return "não deu";
    }

}
