/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.prático.grafos;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Lucas
 */
public class Grafo {
    private String    nome;
    private Vertice[] vertices;
    
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
    
    private HashMap resetarMap(HashMap<Vertice, Boolean> map) {
        map = new HashMap<>();
        for (Vertice vertice : this.vertices) {
            map.put(vertice, false);
        }
        return map;
    }
    
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
     * Informa se um vértice é pendente.
     * @param vertice
     * @return 
     */
    public boolean isPendente(Vertice vertice) {
        return vertice.isPendente();
    }
    
    /**
     * Informa o grau de um vértice enviado por parâmetro.
     * @param vertice
     * @return 
     */
    public int getGrau(Vertice vertice) {
        return vertice.getGrau();
    }
    
}
