
package br.edu.ifsc.navegacaoderobos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Claidson
 */
public class BuscaDeCustoUniformeArvore {

    private Queue<Nodo> filaNos;
    private int valorBusca;
    private String textoResposta;


    public BuscaDeCustoUniformeArvore(int valorBusca) {
        this.filaNos = new LinkedList<Nodo>();
        this.setValorBusca(valorBusca);
    }


    public boolean buscarResultado(Nodo no) {
        if (isResultadoBusca(no)) {
          
            obterResultadoPai(no);
            return true;
        } else {
           
            if (no.getNoEsquerda() != null) {
                this.filaNos.add(no.getNoEsquerda());
            }
            if (no.getNoDireita() != null) {
                this.filaNos.add(no.getNoDireita());
            }

            Nodo noPonta = this.filaNos.poll();
            if (noPonta != null && buscarResultado(noPonta)) {
                return true;
            }
        }
        return false;
    }


    public int contarNosFolha() {
        if (this.filaNos != null) {
            return this.filaNos.size();
        }
        return 0;
    }

    public void obterResultadoPai(Nodo no) {
       
        String retorno = "";
        Nodo noValor = no;
        retorno += noValor.getValor();
        while (noValor.getNoPai() != null) {
            noValor = noValor.getNoPai();
            retorno = noValor.getValor() + ";" + retorno;
        }
        this.textoResposta = retorno;
    }

    public void exibirTextoResultado() {
        if (this.textoResposta != null) {
            System.out.println("O caminho percorrido sera: " + this.textoResposta);
        } else {
            System.out.println("O valor " + this.valorBusca + " nao foi encontrado.");
        }
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public void setTextoResposta(String textoResposta) {
        this.textoResposta = textoResposta;
    }

    public void setValorBusca(int valorBusca) {
        this.valorBusca = valorBusca;
    }

    public boolean isResultadoBusca(Nodo no) {
        return no.getValor() == valorBusca;
    }

    public int getValorBusca() {
        return valorBusca;
    }
}
