/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.prático.grafos;

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
