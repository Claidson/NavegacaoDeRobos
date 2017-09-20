/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Claidson
 */
public class BuscaDeCustoUniforme {
    
    //Nodo[] mapa = new Nodo[100];
    private final int MAX_NODO = 20;
    private Nodo nodoLista[];
    private double adjMat[][];
    private int Nnodos;
    private ArrayList<Transicoes> valores;
    public String caminhoFinal = "";
    private List<Point> pontos = new ArrayList<>(20);
    public List<Point> pont = new ArrayList<>(20);

// ------------------------------------------------------------
    public BuscaDeCustoUniforme() {
        this.valores = new ArrayList<Transicoes>();
        nodoLista = new Nodo[MAX_NODO];

        adjMat = new double[MAX_NODO][MAX_NODO];
        Nnodos = 0;
        for (int y = 0; y < MAX_NODO; y++) {
            for (int x = 0; x < MAX_NODO; x++) {
                adjMat[x][y] = 0;
            }
        }

        carregarRotas();
        leituraPontos();

    }
// ------------------------------------------------------------

    public void addNodos(String rot) {
        nodoLista[Nnodos++] = new Nodo(rot);
    }
// ------------------------------------------------------------

    public void addEdge(int start, int end, double value) {
        adjMat[start][end] = value;
        adjMat[end][start] = value;

    }
// ------------------------------------------------------------

 public void CustoUniforme(int start, int end) {

        ArrayList<caminho> fila = new ArrayList<>();
        fila.add(new caminho(start, 0));
        int fim = -1;
        boolean continua = true;
        caminho ca = new caminho();
        double value = 0;

        int v2;
        if (start == end) {
            JOptionPane.showMessageDialog(null, "Estados Iguais");
            Point[] p = new Point[1];
            p[0] = pontos.get(start);
            gravarPontos(p);
            caminhoFinal = "";
            fim = start;
        } else {
            while (!fila.isEmpty() && continua) {
                int v1 = fila.get(0).getVertice();
                double v = fila.get(0).getValor();
                fila.remove(0);
                
                nodoLista[v1].foiVisitado = true;
                nodoLista[end].foiVisitado = false;
                
                while ((v2 = getNodoNaoVisitado(v1)) != -1) {
                    nodoLista[v2].foiVisitado = true;
                    if (v2 == end) {
                    	if(fim == -1) {
                    		fim = v1;
                    		value = v + adjMat[v1][v2];
                    	}else {
                    		double atual = v + adjMat[v1][v2];
                    		if(atual <= value) {
                    			fim = v1;
                    			nodoLista[v2].pai = v1;
                    		}else {
                    			continua = false;
                    		}
                    	}
                    	  
                    } else {
                        nodoLista[v2].pai = v1;
                        double valor = v + adjMat[v1][v2];
                        fila.add(new caminho(v2, valor));
                    }

                }
                Collections.sort(fila);

            }

        }
        if(start != end){
            retrocesso(fim, end);
        }
        

        for (int j = 0; j < Nnodos; j++) {
            nodoLista[j].foiVisitado = false;
            nodoLista[j].setPai(-1);
        }
    }
// ------------------------------------------------------------

// ------------------------------------------------------------- 
    public int getNodoNaoVisitado(int v) {

        for (int j = 0; j < Nnodos; j++) {
            if (adjMat[v][j] != 0 && nodoLista[j].foiVisitado == false) {
                return j;
            }
        }
        return -1;
    }
// ------------------------------------------------------------

    private void retrocesso(int vertice, int chegada) {

        int i = 0;
        Point[] p = new Point[20];
        ArrayList<Nodo> List = new ArrayList<>();
        List.add(nodoLista[vertice]);

        int valor = nodoLista[vertice].pai;
        p[i++] = pontos.get(chegada);
        p[i++] = pontos.get(vertice);
        
        while (valor != -1) {
            List.add(nodoLista[valor]);
            p[i++] = pontos.get(valor);
            valor = nodoLista[valor].pai;
        }

        for (int j = List.size() - 1; j >= 0; j--) {
            caminhoFinal = caminhoFinal + "" + List.get(j).rotulo + " ->";
        }

        caminhoFinal = caminhoFinal + "" + nodoLista[chegada].rotulo + "\n";

        double value = 0;
        double tempo = 0;
        for (int j = List.size() - 1; j >= 0; j--) {
            String destino = nodoLista[j].rotulo;
            int start = nodoLista[j].pai;
            if (start != -1) {
                String origem = nodoLista[start].rotulo;
                for (Transicoes t : valores) {
                    if ((t.getStart().equalsIgnoreCase(origem) && t.getEnd().equalsIgnoreCase(destino))
                            || (t.getStart().equalsIgnoreCase(destino) && t.getEnd().equalsIgnoreCase(origem))) {
                        value += t.getValue();
                        tempo += t.getTempo();
                    }
                }
            }
        }
        for (Transicoes t : valores) {
            if ((t.getStart().equalsIgnoreCase(nodoLista[vertice].rotulo) && 
                    t.getEnd().equalsIgnoreCase(nodoLista[chegada].rotulo))
                    || (t.getStart().equalsIgnoreCase(nodoLista[chegada].rotulo) && 
                    t.getEnd().equalsIgnoreCase(nodoLista[vertice].rotulo))) {
                value += t.getValue();
                tempo += t.getTempo();
            }
        }
        int minuto = (int) tempo;
        int inteira = minuto / 60;
        int resto = minuto % 60;
        
        String t = inteira + " horas e " + resto + " minutos ";
        NumberFormat formatter = new DecimalFormat("#0.00");
        String v = formatter.format(value);
        gravarPontos(p);
        caminhoFinal += "" + t + "\nValor: " + v + "\n";

    }

    private void gravarPontos(Point[] pon) {

        try {
            File file = new File("resultado.txt");
            

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int j = 0; j < pon.length; j++) {
                if (pon[j] != null) {
                    bw.write(pon[j].x + ";" + pon[j].y + "\n");
                    pont.add(pon[j]);
                }
            }
            bw.flush();
            bw.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }

    private void carregarRotas() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Arquivos/valores.txt"), "ISO-8859-1"));
            String linha;
            
            while ((linha = br.readLine()) != null) {
                String rota[] = new String[4];
                rota = linha.split(";");
                int time = Integer.parseInt(rota[2]);
                double value = Double.parseDouble(rota[3]);
                valores.add(new Transicoes(rota[0], rota[1], time, value));
                
            }
            
            br.close();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public void leituraPontos() {
        try {
            BufferedReader myBuffer = new BufferedReader(new InputStreamReader(
                    getClass().getResourceAsStream("/Arquivos/PONTOS.txt")));
                    

            // loop que lê e imprime todas as linhas do arquivo
            String pontos = myBuffer.readLine();
            
            while (pontos != null) {
                if (pontos != null) {
                    String[] valores = pontos.split(";");
                    this.pontos.add(new Point(Integer.parseInt(valores[1]), Integer.parseInt(valores[2])));
                }
                pontos = myBuffer.readLine();
                
            }
            

            myBuffer.close();
        } catch (Exception e) {
        }

    }
    
}
