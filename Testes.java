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
public class Testes {
    
    private Grafo grafo1;
    private Grafo grafo2;
    private Grafo grafo3;
    private Grafo grafo4;
    private Grafo grafo5;
    private Grafo grafo6;
    
    public Testes() {
        this.instanciarGrafos();
    }
    
    public void realizarTestes() {
        try {
            this.testeAdjacencia();
            this.testeGrauVertice();
            this.testeGrafoRegular();
            this.testeVerticeIsolado();
            this.testeVerticePendente();
            this.testeGrafoNulo();
            this.testeGrafoCompleto();
            this.testeGrafoConexo();
            this.testeGrafoEuleriano();
            this.testeGrafoUnicursal();
            this.testeNumArestas();
            this.testeHasCiclo();
            this.testeGrauEntrada();
            this.testeFConexo();
            System.out.println("Testes realizados com sucesso. Nenhum erro encontrado.");
        } catch (Exception e) {
            System.err.println("Uma exceção foi encontrado ao realizar os testes: " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
    
    private void instanciarGrafos() {
        instanciarGrafo1();
        instanciarGrafo2();
        instanciarGrafo3();
        instanciarGrafo4();
        instanciarGrafo5();
        instanciarGrafo6();
    }
    
    private void instanciarGrafo1() {
        /* Instanciando grafo igual ao da imagem:
           https://pt.wikipedia.org/wiki/Teoria_dos_grafos#/media/File:6n-graf.svg */
        
        /* Instanciando um grafo com nome G1                                       */
        this.grafo1 = new Grafo("G1");
        
        /* Instanciando vértices      */  
        Vertice v1  = new Vertice("1");
        Vertice v2  = new Vertice("2");
        Vertice v3  = new Vertice("3");
        Vertice v4  = new Vertice("4");
        Vertice v5  = new Vertice("5");
        Vertice v6  = new Vertice("6");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v2, v5 });
        v2.setAdjacencias(new Vertice[]{ v1, v3, v5 });
        v3.setAdjacencias(new Vertice[]{ v2, v4 });
        v4.setAdjacencias(new Vertice[]{ v3, v5, v6 });
        v5.setAdjacencias(new Vertice[]{ v1, v2, v4 });
        v6.setAdjacencias(new Vertice[]{ v4 });
        
        /* Inserindo vértices no grafo                                             */
        this.grafo1.setVertices(new Vertice[]{ v1, v2, v3, v4, v5, v6 });
    }
    
    private void instanciarGrafo2() {
        /* Instanciando grafo igual ao da imagem:
           https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Prim_Algorithm_0.svg/250px-Prim_Algorithm_0.svg.png */
        
        /* Instanciando um grafo com nome G2                                       */
        this.grafo2 = new Grafo("G2");
        
        /* Instanciando vértices      */  
        Vertice v1  = new Vertice("A");
        Vertice v2  = new Vertice("B");
        Vertice v3  = new Vertice("C");
        Vertice v4  = new Vertice("D");
        Vertice v5  = new Vertice("E");
        Vertice v6  = new Vertice("F");
        Vertice v7  = new Vertice("G");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v2, v4 });
        v2.setAdjacencias(new Vertice[]{ v1, v3, v4, v5 });
        v3.setAdjacencias(new Vertice[]{ v2, v5 });
        v4.setAdjacencias(new Vertice[]{ v1, v2, v5, v6 });
        v5.setAdjacencias(new Vertice[]{ v2, v3, v4, v6, v7 });
        v6.setAdjacencias(new Vertice[]{ v4, v5, v7 });
        v7.setAdjacencias(new Vertice[]{ v5, v6 });
        
        /* Inserindo vértices no grafo                                             */
        this.grafo2.setVertices(new Vertice[]{ v1, v2, v3, v4, v5, v6, v7 });
    }
    
    private void instanciarGrafo3() {
        /* Instanciando grafo igual ao da imagem:
           http://www.ppgia.pucpr.br/~laplima/ensino/tap/contents/images/grafo02.gif */
        
        /* Instanciando um grafo com nome G3                                         */
        this.grafo3 = new Grafo("G3");
        
        /* Instanciando vértices      */  
        Vertice v1  = new Vertice("A");
        Vertice v2  = new Vertice("B");
        Vertice v3  = new Vertice("C");
        Vertice v4  = new Vertice("D");
        Vertice v5  = new Vertice("E");
        Vertice v6  = new Vertice("F");
        Vertice v7  = new Vertice("G");
        Vertice v8  = new Vertice("H");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v1, v2, v3, v4 });
        v2.setAdjacencias(new Vertice[]{ });
        v3.setAdjacencias(new Vertice[]{ v4, v6 });
        v4.setAdjacencias(new Vertice[]{  });
        v5.setAdjacencias(new Vertice[]{ v7 });
        v6.setAdjacencias(new Vertice[]{  });
        v7.setAdjacencias(new Vertice[]{  });
        v8.setAdjacencias(new Vertice[]{  });
        
        /* Inserindo vértices no grafo                                             */
        this.grafo3.setVertices(new Vertice[]{ v1, v2, v3, v4, v5, v6, v7, v8 });
    }
    
    private void instanciarGrafo4() {
        /* Instanciando um grafo com nome G4                                        */
        this.grafo4 = new Grafo("G4");
        
        /* Instanciando vértices      */  
        Vertice v1  = new Vertice("A");
        Vertice v2  = new Vertice("B");
        Vertice v3  = new Vertice("C");
        Vertice v4  = new Vertice("D");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v2, v4 });
        v2.setAdjacencias(new Vertice[]{ v1, v3 });
        v3.setAdjacencias(new Vertice[]{ v2, v3 });
        v4.setAdjacencias(new Vertice[]{ v1, v3 });
        
        /* Inserindo vértices no grafo                                             */
        this.grafo4.setVertices(new Vertice[]{ v1, v2, v3, v4 });
    }
    
    private void instanciarGrafo5() {
        /* Instanciando um grafo com nome G5                                       */
        this.grafo5 = new Grafo("G5");
        
        /* Instanciando vértices      */  
        Vertice v1  = new Vertice("A");
        Vertice v2  = new Vertice("B");
        Vertice v3  = new Vertice("C");
        Vertice v4  = new Vertice("D");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{  });
        v2.setAdjacencias(new Vertice[]{  });
        v3.setAdjacencias(new Vertice[]{  });
        v4.setAdjacencias(new Vertice[]{  });
        
        /* Inserindo vértices no grafo                                             */
        this.grafo5.setVertices(new Vertice[]{ v1, v2, v3, v4 });
    }
    
    private void instanciarGrafo6() {
        /* Instanciando um grafo com nome G5                                       */
        this.grafo6 = new Grafo("G6");
        
        /* Instanciando vértices      */  
        Vertice v1  = new Vertice("A");
        Vertice v2  = new Vertice("B");
        Vertice v3  = new Vertice("C");
        Vertice v4  = new Vertice("D");
        
        /* Definindo adjacências dos vértices   */    
        v1.setAdjacencias(new Vertice[]{ v2, v3, v4 });
        v2.setAdjacencias(new Vertice[]{ v1, v3, v4 });
        v3.setAdjacencias(new Vertice[]{ v1, v2, v4 });
        v4.setAdjacencias(new Vertice[]{ v1, v2, v3 });
        
        /* Inserindo vértices no grafo                                             */
        this.grafo6.setVertices(new Vertice[]{ v1, v2, v3, v4 });
    }
    
    private void testeAdjacencia() throws Exception {
        Grafo g1 = this.grafo1;
        if (!g1.isAdjacente(g1.getVertice("1"), g1.getVertice("2")))
            throw new Exception("Problema em isAdjacente");
        if (g1.isAdjacente(g1.getVertice("1"), g1.getVertice("6")))
            throw new Exception("Problema em isAdjacente");
    }
    
    private void testeGrauVertice() throws Exception {
        Grafo g3 = this.grafo3;
        if (g3.getGrau(g3.getVertice("A")) != 4)
            throw new Exception("Problema em getGrau");
        if (g3.getGrau(g3.getVertice("F")) != 0)
            throw new Exception("Problema em getGrau");
    }
    
    private void testeGrafoRegular() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g4 = this.grafo4;
        if (g1.isRegular())
            throw new Exception("Problema em isRegular");
        if (!g4.isRegular())
            throw new Exception("Problema em isRegular");
    }
    
    private void testeVerticeIsolado() throws Exception {
        Grafo g3 = this.grafo3;
        if (!g3.isIsolado(g3.getVertice("H")))
            throw new Exception("Problema em isIsolado");
        if (g3.isIsolado(g3.getVertice("E")))
            throw new Exception("Problema em isIsolado");
    }
    
    private void testeVerticePendente() throws Exception {
        Grafo g1 = this.grafo1;
        if (g1.isPendente(g1.getVertice("1")))
            throw new Exception("Problema em isPendente");
        if (!g1.isPendente(g1.getVertice("6")))
            throw new Exception("Problema em isPendente");
    }
    
    private void testeGrafoNulo() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g5 = this.grafo5;
        if (g1.isNulo())
            throw new Exception("Problema em isNulo");
        if (!g5.isNulo())
            throw new Exception("Problema em isNulo");
    }
    
    private void testeGrafoCompleto() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g6 = this.grafo6;
        if (g1.isCompleto())
            throw new Exception("Problema em isCompleto");
        if (!g6.isCompleto())
            throw new Exception("Problema em isCompleto");
    }
    
    private void testeGrafoConexo() throws Exception {
        Grafo g2 = this.grafo2;
        Grafo g3 = this.grafo3;
        if (!g2.isConexo())
            throw new Exception("Problema em isConexo");
        if (g3.isConexo())
            throw new Exception("Problema em isConexo");
    }
    
    private void testeGrafoEuleriano() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g4 = this.grafo4;
        if (g1.isEuleriano())
            throw new Exception("Problema em isEuleriano");
        if (!g4.isEuleriano())
            throw new Exception("Problema em isEuleriano");
    }
    
    private void testeGrafoUnicursal() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g2 = this.grafo2;
        if (g1.isUnicursal())
            throw new Exception("Problema em isUnicursal");
        if (!g2.isUnicursal())
            throw new Exception("Problema em isUnicursal");
    }
    
    private void testeNumArestas() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g2 = this.grafo2;
        if (g1.getNumArestas() != 7)
            throw new Exception("Problema em getNumArestas");
        if (g2.getNumArestas() != 11)
            throw new Exception("Problema em getNumArestas");
    }
    
    private void testeHasCiclo() throws Exception {
        Grafo g1 = this.grafo1;
        Grafo g3 = this.grafo3;
        
        if (!g1.hasCiclo())
            throw new Exception("Problema em hasCiclo");
        if (g3.hasCiclo())
            throw new Exception("Problema em hasCiclo");
    }
    
    private void testeGrauEntrada() throws Exception {
        Grafo g3 = this.grafo3;
        
        if (g3.getGrauEntrada(g3.getVertice("C")) != 1) 
            throw new Exception("Problema em getGrauEntrada");
        if (g3.getGrauEntrada(g3.getVertice("H")) != 0)
            throw new Exception("Problema em getGrauEntrada");
    }
    
    private void testeFConexo() throws Exception {
        Grafo g2 = this.grafo2;
        Grafo g6 = this.grafo6;
        
        if (!g6.isFConexo())
            throw new Exception("Problema em isFConexo");
        if (g2.isFConexo())
            throw new Exception("Problema em isFConexo");
    }
    
}
