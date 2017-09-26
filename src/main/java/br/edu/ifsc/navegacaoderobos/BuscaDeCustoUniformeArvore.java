/*
A estratégia de busca uniforme é uma pequena modificação da estratégia de busca em largura. 
Na busca em largura primeiro expande-se o nó raiz, depois todos os nós gerados por esse, 
e assim por diante até que se chegue ao estado meta. 
Ou seja, todos os nós que estão numa profundidade d da árvore serão expandidos e visitados 
antes que os nós que estão numa profundidade d+1.
A estratégia de busca uniforme é basicamente a mesma coisa.
Mas ao invés de pegar o primeiro nó expandido que está na lista aguardando processamento, 
o nó que possui o menor custo (g(N)) será escolhido para ser expandido. 
Se certas condições sempre forem cumpridas, garante-se que a primeira solução encontrada será a mais barata. 
Uma condição é a seguinte: o custo do caminho nunca deve ir diminuindo conforme avançamos por ele, 
em outras palavras, é importante que:
g(Sucessor)>=g(N) em todos os nós N, g(N) é o custo conhecido de ir-se da raiz até o nódulo N.
Abaixo está sendo apresentado o pseudocódigo do mesmo.

Algoritmo Busca - Uniforme
1. Definir um conjunto L de nós iniciais
2. Ordene L em ordem crescente de custo
3. Se L é vazio
    Então Busca não foi bem sucedida
    Senão seja n o primeiro nó de L;
4. Se n é um nó objetivo
    Então
        Retornar caminho do nó inicial até N;
        Parar
    Senão
        Remover n de L;
        Adicionar em L todos os nós filhos de n, rotulando cada nó com o seu caminho até o nó inicial;
        Ordene L em ordem crescente de custo;
        Volte ao passo 3.
 */
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
