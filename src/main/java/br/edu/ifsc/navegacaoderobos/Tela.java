/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class Tela extends JFrame {

    public Tela(Nodo nodo[][]) {
// painel com os dados
        int i = 50;
        int j = 50;
        javax.swing.JButton botao;
        JPanel pGrid = new JPanel(new GridLayout(i, j));
        for (i = 1; i < 51; i++) {
            for (j = 1; j < 51; j++) {
                botao = new JButton();
                if (nodo[i][j].getEstado()) {
                    botao.setBackground(Color.BLACK);
                } else if (nodo[i][j].getChegada()) {
                    botao.setBackground(Color.blue);
                } else if (nodo[i][j].getSaida()) {
                    botao.setBackground(Color.GREEN);
                } else if (nodo[i][j].getResultado()) {
                    botao.setBackground(Color.RED);
                } else if (nodo[i][j].getVisitadoB()) {
                    botao.setBackground(Color.yellow);
                } else if (nodo[i][j].getVisitadoA()) {
                    botao.setBackground(Color.ORANGE);
                }

                pGrid.add(botao);
            }
        }

// painel do JFrame
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pGrid, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("Cadastro");
        this.setSize(1080, 800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /*public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Tela();
    }*/
}
