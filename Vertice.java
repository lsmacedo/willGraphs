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
public class Vertice {
    private String    nome;
    private int       grau = 0;
    private Vertice[] adjacencias;
    
    public Vertice(String nome) throws Exception {
        if (nome == null) 
            throw new Exception("O nome do vértice não deve ser nulo");
        
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
    
}
