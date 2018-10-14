/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.prático.grafos;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Instanciando grafo igual ao da imagem:
           https://pt.wikipedia.org/wiki/Teoria_dos_grafos#/media/File:6n-graf.svg */
        
        /* Instanciando um grafo com nome G                                        */
        Grafo grafo = new Grafo("G");
        
        /* Instanciando vértices      */  
        Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        Vertice v3 = new Vertice("3");
        Vertice v4 = new Vertice("4");
        Vertice v5 = new Vertice("5");
        Vertice v6 = new Vertice("6");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v2, v5 });
        v2.setAdjacencias(new Vertice[]{ v1, v3, v5 });
        v3.setAdjacencias(new Vertice[]{ v2, v4 });
        v4.setAdjacencias(new Vertice[]{ v3, v5, v6 });
        v5.setAdjacencias(new Vertice[]{ v1, v2, v4 });
        v6.setAdjacencias(new Vertice[]{ v4 });
        
        /* Inserindo vértices no grafo                                             */
        grafo.setVertices(new Vertice[]{ v1, v2, v3, v4, v5, v6 });
        
        /* Executando verificações                                                 */
        System.out.println("Lista de adjacências:\n" + grafo.toString());
        System.out.println("Matriz de adjacências:\n" + grafo.montarMatriz().toString() + "\n");
        System.out.println("1 e 2 são adjacentes? " + escreverResposta(grafo.isAdjacente(v1, v2)));
        System.out.println("Grau do vértice 1?    " + grafo.getGrau(v1));
        System.out.println("Grafo é regular?      " + escreverResposta(grafo.isRegular()));
        System.out.println("Vértice 6 é isolado?  " + escreverResposta(grafo.isIsolado(v6)));
        System.out.println("Vértice 6 é pendente? " + escreverResposta(grafo.isPendente(v6)));
        System.out.println("Grafo é nulo?         " + escreverResposta(grafo.isNulo()));
        System.out.println("Grafo é completo?     " + escreverResposta(grafo.isCompleto()));
        System.out.println("Grafo é conexo?       " + escreverResposta(grafo.isConexo()));
        System.out.println("Grafo é euleriano?    " + escreverResposta(grafo.isEuleriano()));
        System.out.println("Grafo é unicursal?    " + escreverResposta(grafo.isUnicursal()));
        System.out.println("Grafo é hamiltoniano? " + escreverResposta(grafo.isHamiltoniano()));
        System.out.println("Número de arestas?    " + grafo.getNumArestas());
        System.out.println("Possui algum ciclo?   " + escreverResposta(grafo.hasCiclo()));
        System.out.println("Possui ciclo ímpar?   " + escreverResposta(grafo.hasCicloImpar()));
        System.out.println("É bipartido?          " + escreverResposta(grafo.isBipartido()));
        System.out.println("Grafo complementar: \n" + grafo.getComplementar().toString());
    }
    
    public static String escreverResposta(boolean resposta) {
        return resposta == true ? "Sim" : "Não";
    }
    
}
