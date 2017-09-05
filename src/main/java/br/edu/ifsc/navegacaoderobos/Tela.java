/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.navegacaoderobos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */

public class Tela extends JFrame {
public Tela() {
// painel com os dados
int i = 50;
int j = 50;
JPanel pGrid = new JPanel(new GridLayout(i, j));
    for (i = 1;i<51;i++){
        for (j = 1; j<51;j++){
            pGrid.add(new Button(i+" "+j));
        }
    }

// painel do JFrame
this.setLayout(new BorderLayout());
this.getContentPane().add(pGrid, BorderLayout.CENTER);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("Cadastro");
this.setSize(1080, 800);
this.setResizable(true);
this.setLocationRelativeTo(null);
this.setVisible(true);
}
public static void main(String[] args) {
JFrame.setDefaultLookAndFeelDecorated(true);
new Tela();
}
}