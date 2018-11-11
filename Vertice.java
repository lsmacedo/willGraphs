/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.prático.grafos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class Vertice {
    private String    nome;
    private int       grau = 0;
    private Integer   topSort = null;
    private Vertice[] adjacencias;
    public int        inDegree = 0;
    
    public Vertice(String nome) {        
        this.nome     = nome;
    }
    
    /**
     * Devolve o grau do vértice.
     * @return 
     */
    public int getGrau() {
        return this.grau;
    }
    
    /**
     * Devolve o nome do vértice.
     * @return 
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Devolve o indice da ordenação topológica.
     * @return 
     */
    public Integer getTopSort() {
        return this.topSort;
    }
    
    /**
     * Devolve os vértices adjacentes a este.
     * @return 
     */
    public Vertice[] getAdjacencias() {
        return this.adjacencias;
    }
    
    /**
     * Define as adjacências do vértice e atualiza o grau.
     * @param adjacencias 
     */
    public void setAdjacencias(Vertice[] adjacencias) {
        this.adjacencias = adjacencias;
        this.grau = adjacencias.length;
    }
    
    /**
     * Define o indice da ordenação topológica.
     * @param topSort 
     */
    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }
    
    /**
     * Informa se este vértice é adjacente ao vértice recebido por parâmetro.
     * Para isto, verifica se o vértice recebido por parâmetro está incluído
     * no array de adjacências.
     * @param vertice
     * @return 
     */
    public boolean isAdjacente(Vertice vertice) {
        boolean isAdjacente = false;
        for (Vertice adjacencia : adjacencias) {
            if (adjacencia.equals(vertice)) {
                isAdjacente = true;
                break;
            }
        }
        return isAdjacente;
    }
    
    /**
     * Informa se este vértice é isolado.
     * Para isto verifica se possui alguma adjacência.
     * @return 
     */
    public boolean isIsolado() {
        return this.adjacencias.length == 0;
    }
    
    /**
     * Informa se este vértice é pendente.
     * Para isto verifica se seu grau é igual a 1.
     * @return 
     */
    public boolean isPendente() {
        return this.grau == 1;
    }
    
    /**
     * Devolve todos os vértices com que este não faz adjacência.
     * @param vertices
     * @return 
     */
    public Vertice[] getComplementar(Vertice[] vertices) {
        ArrayList<Vertice> adjacencias = new ArrayList<>(Arrays.asList(this.adjacencias));
        ArrayList<Vertice> complementar = new ArrayList<>();
        
        for (Vertice vertice : vertices) {
            if (!adjacencias.contains(vertice) && !vertice.equals(this)) {
                Vertice clone = vertice.clone();
                complementar.add(clone);
            }
        }
        
        return complementar.toArray(new Vertice[complementar.size()]);
    }
    
    /**
     * Verifica se este vértice é igual ao recebido por parâmetro.
     * Para isto, verifica se o nome dos dois é igual.
     * @param vertice
     * @return 
     */
    public boolean equals(Vertice vertice) {
        return this.nome.equals(vertice.nome);
    }
    
    /**
     * Sobrescrevendo toString para facilitar na depuração.
     * @return 
     */
    @Override
    public String toString() {
        return this.nome;
    }
    
    /**
     * Devolve um vértice com o mesmo nome.
     * No momento, este vértice é criado sem nenhuma adjacência.
     * @return 
     */
    public Vertice clone() {
        Vertice clone = new Vertice(this.nome);
        clone.setAdjacencias(new Vertice[] { });
        return clone;
    }
    
}
