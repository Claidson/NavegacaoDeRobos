/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

/**
 *
 * @author Fernando
 */
public class main {
    public static void main(String[] args) {
        int i;
        int j;
        Nodo[][] nodo = new Nodo[55][55];
        for (i = 1; i < 51; i++) {            
            for (j = 1; j < 51; j++) {
                nodo[i][j] = new Nodo(i,j);
            }
    }

        nodo[10][10].setSaida(Boolean.TRUE);
       nodo[10][40].setChegada(Boolean.TRUE);
       /*for (i = 1; i < 49; i++) {            
           
        nodo[i][30].setEstado(Boolean.TRUE);
         }*/
        
        
       // BuscaBidirecional busca = new BuscaBidirecional();
        BuscaAEstrela busca = new BuscaAEstrela();
        String r = busca.buscar(nodo);
        String[] res = r.split(";");
        for (int f = 0;f<res.length;f=f+2){
            nodo[Integer.parseInt(res[f])][Integer.parseInt(res[f+1])].setResultado(Boolean.TRUE);
        }
        Tela tela = new Tela(nodo);
        tela.setVisible(true);
}}
