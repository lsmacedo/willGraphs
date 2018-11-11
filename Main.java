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
        Testes testes = new Testes();
        testes.realizarTestes();
        
        /* Instanciando grafo igual ao da imagem:
           https://pt.wikipedia.org/wiki/Teoria_dos_grafos#/media/File:6n-graf.svg */
        
        /* Instanciando um grafo com nome G                                        */
        Grafo grafo = new Grafo("G");
        
        /* Instanciando vértices      */  
        Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        Vertice v3 = new Vertice("3");
        Vertice v4 = new Vertice("4");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v2, v3, v4 });
        v2.setAdjacencias(new Vertice[]{ v4, v1, v3 });
        v3.setAdjacencias(new Vertice[]{ v1, v4, v2 });
        v4.setAdjacencias(new Vertice[]{ v1, v2, v3 });
        
        /* Inserindo vértices no grafo                                             */
        grafo.setVertices(new Vertice[]{ v1, v2, v3, v4 });
        
        /* Executando verificações                                                 */
        System.out.println("\n" + grafo.toString());;
        System.out.println("Matriz de adjacências:\n" + grafo.montarMatriz().toString() + "\n");
        System.out.println("1 e 2 são adjacentes?      " + escreverBooleano(grafo.isAdjacente(v1, v2)));
        System.out.println("Grau do vértice 1?         " + grafo.getGrau(v1));
        System.out.println("Grafo é regular?           " + escreverBooleano(grafo.isRegular()));
        System.out.println("Vértice 4 é isolado?       " + escreverBooleano(grafo.isIsolado(v4)));
        System.out.println("Vértice 4 é pendente?      " + escreverBooleano(grafo.isPendente(v4)));
        System.out.println("Grafo é nulo?              " + escreverBooleano(grafo.isNulo()));
        System.out.println("Grafo é completo?          " + escreverBooleano(grafo.isCompleto()));
        System.out.println("Grafo é conexo?            " + escreverBooleano(grafo.isConexo()));
        System.out.println("Grafo é fortemente conexo? " + escreverBooleano(grafo.isFConexo()));
        System.out.println("Grafo é euleriano?         " + escreverBooleano(grafo.isEuleriano()));
        System.out.println("Grafo é unicursal?         " + escreverBooleano(grafo.isUnicursal()));
        System.out.println("Grafo é hamiltoniano?      " + escreverBooleano(grafo.isHamiltoniano()));
        System.out.println("Número de arestas?         " + grafo.getNumArestas());
        System.out.println("Possui algum ciclo?        " + escreverBooleano(grafo.hasCiclo()));
        System.out.println("Possui ciclo ímpar?        " + escreverBooleano(grafo.hasCicloImpar()));
        System.out.println("É bipartido?               " + escreverBooleano(grafo.isBipartido()));
        System.out.println("\n" + grafo.getComplementar().toString()); //@toDo
    }
    
    public static String escreverBooleano(boolean resposta) {
        return resposta == true ? "Sim" : "Não";
    }
    
}
