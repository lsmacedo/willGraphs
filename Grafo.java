/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.prático.grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Lucas
 */
public class Grafo {
    private final String nome;
    private Vertice[]    vertices;
    
    public Grafo(String nome) {
        this.nome = nome;
    }    
    
    /**
     * Define os vértices do grafo.
     * @param vertices 
     */
    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }
    
    /**
     * Informa se um vértice A é adjacente a um vértice B.
     * @param verticeA
     * @param verticeB
     * @return 
     */
    public boolean isAdjacente(Vertice verticeA, Vertice verticeB) {
        return verticeA.isAdjacente(verticeB);
    }
    
    /**
     * Informa se este grafo é regular.
     * Para isto percorre todos os vértices e verifica se algum tem grau diferente
     * do primeiro.
     * @return 
     */
    public boolean isRegular() {
        boolean isRegular = true;
        int primeiroGrau  = this.vertices[0].getGrau();
        for (int i = 1; i < this.vertices.length; i++) {
            if (this.vertices[i].getGrau() != primeiroGrau) {
                isRegular = false;
                break;
            }
        }
        return isRegular;
    }
    
    /**
     * Informa se um vértice é isolado.
     * @param vertice
     * @return 
     */
    public boolean isIsolado(Vertice vertice) {
        return vertice.isIsolado();
    }
    
    /**
     * Informa se este grafo é nulo.
     * Para isto verifica se todos os vértices são isolados.
     * @return 
     */
    public boolean isNulo() {
        boolean isNulo = true;
        for (Vertice vertice : this.vertices) {
            if (!vertice.isIsolado()) {
                isNulo = false;
                break;
            }
        }
        return isNulo;
    }
    
    /**
     * Informa se este grafo é completo.
     * Para isto verifica se o grau de todos os vértices é maior ou igual ao 
     * número de vértices - 1
     * @return 
     */
    public boolean isCompleto() {
        boolean isCompleto = true;
        for (Vertice vertice : this.vertices) {
            if (vertice.getGrau() < this.vertices.length - 1) {
                isCompleto = false;
                break;
            }
        }
        return isCompleto;
    }
    
    /**
     * Informa se este grafo é euleriano.
     * Para isto verifica se todos os vértices possuem grau par.
     * @return 
     */
    public boolean isEuleriano() {
        boolean euleriano = true;
        for (Vertice v : vertices) {
            if (v.getGrau() % 2 != 0) {
                euleriano = false;
                break;
            }
        }
        return euleriano;
    }
    
    /**
     * Informa se este grafo é unicursal.
     * Para isto verifica se possui dois vértices com grau ímpar.
     * @return 
     */
    public boolean isUnicursal() {
        int numGrausImpares = 0;
        for (Vertice v : vertices) {
            if (v.getGrau() % 2 != 0) {
                numGrausImpares++;
            }
        }
        return numGrausImpares == 2;
    }
    
    /**
     * Obtem o grafo complementar a este.
     * Para isto, percorre todos os vértices e obtem os vértices com que não são
     * adjacentes.
     * @return 
     */
    public Grafo getComplementar() {
        Grafo gComplementar = new Grafo(this.nome + " - Complementar");
        Vertice[] verticesComplementares = new Vertice[this.vertices.length];
        for (int i = 0; i < this.vertices.length; i++) {
            Vertice v = this.vertices[i];
            Vertice vComplementar = new Vertice(v.getNome());
            vComplementar.setAdjacencias(v.getComplementar(this.vertices));
            verticesComplementares[i] = vComplementar;
        }
        gComplementar.setVertices(verticesComplementares);
        return gComplementar;
    }
    
    /**
     * Devolve o número de arestas de um grafo não dirigido.
     * @return 
     */
    public int getNumArestas() {
        int numArestas = 0;
        for (Vertice vertice : this.vertices) {
            numArestas += vertice.getAdjacencias().length;
        }
        return numArestas / 2;
    }
    
    public boolean isHamiltoniano() {
        if (this.vertices.length >= 3) {
            for (Vertice v : this.vertices) {
                if (v.getGrau() < this.vertices.length / 2) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Informa se este grafo é conexo.
     * Para isto verifica se cada vértice consegue chegar em qualquer outro.
     * @return 
     */
    public boolean isConexo() {
        boolean isConexo = true;
        HashMap<Vertice, Boolean> visitados = new HashMap<>();
        visitados = this.resetarMap(visitados);
        
        for (Vertice v : this.vertices) {
            this.buscaProfundidade(visitados, v);
            if (visitados.containsValue(false)) {
                isConexo = false;
                break;
            }
            visitados = this.resetarMap(visitados);
        }
        
        return isConexo;
    }
    
    /**
     * Caminha recursivamente pelos vértices adjacentes a V, e adiciona
     * true no map a cada vértice visitado.
     * @param visitados
     * @param v 
     */
    private void buscaProfundidade(HashMap<Vertice, Boolean> visitados, Vertice v) {
        visitados.put(v, true);
        Vertice[] adjacentes = v.getAdjacencias();
        for (Vertice w : adjacentes) {
            if (!visitados.get(w)) {
                buscaProfundidade(visitados, w);
            }
        }
    }
    
    /**
     * Inicia o map com false em todas as posições.
     * @param map
     * @return 
     */
    private HashMap resetarMap(HashMap<Vertice, Boolean> map) {
        map = new HashMap<>();
        for (Vertice vertice : this.vertices) {
            map.put(vertice, false);
        }
        return map;
    }
    
    /**
     * Informa se um vértice é pendente.
     * @param vertice
     * @return 
     */
    public boolean isPendente(Vertice vertice) {
        return vertice.isPendente();
    }
    
    public Boolean[][] montarMatriz() {
        Boolean[][] matriz = new Boolean[this.vertices.length][this.vertices.length];
        
        for (int x = 0; x < this.vertices.length; x++) {
            ArrayList<Vertice> adjacencias = new ArrayList(Arrays.asList(this.vertices[x].getAdjacencias()));
            for (int y = 0; y < this.vertices.length; y++) {
                matriz[x][y] = adjacencias.contains(this.vertices[y]);
            }
        }
        
        return matriz;
    }
    
    /**
     * Informa se este grafo é bipartido.
     * Para isto verifica se não possui nenhum ciclo impar.
     * @return 
     */
    public boolean isBipartido() {
        return !this.hasCicloImpar();
    }
    
    /**
     * Informa se este grafo possui algum ciclo.
     * @return 
     */
    public boolean hasCiclo() {
        //static int pre[1000], post[1000];
        //bool GRAPHhasCycle( Graph G) 
        //{
        //   GRAPHdfs( G);
        //
        //   for (vertex v = 0; v < G->V; ++v) {
        //      for (link a = G->adj[v]; a != NULL; a = a->next) {
        //         vertex w = a->w;
        //         if (post[v] < post[w]) /* v-w é de retorno */
        //            return true;
        //      }
        //   } 
        //   /* post[v] > post[w] para todo arco v-w */
        //   return false;
        //}
        //@TODO
        return true;
    }
    
    /**
     * Informa se este grafo possui especificamente algum ciclo impar.
     * @return 
     */
    public boolean hasCicloImpar() {
        //@TODO
        return true;
    }
    
    /**
     * Informa o grau de um vértice enviado por parâmetro.
     * @param vertice
     * @return 
     */
    public int getGrau(Vertice vertice) {
        return vertice.getGrau();
    }
    
    @Override
    public String toString() {
        String string = "";
        for (Vertice v : this.vertices) {
            string += v.toString();
            for (Vertice adj : v.getAdjacencias()) {
                string += " - " + adj.toString();
            }
            string += "\n";
        }
        return string;
    }
    
}
