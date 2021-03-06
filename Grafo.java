/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public Vertice getVertice(String nome) {
        Vertice vertice = null;
        for (Vertice v : this.vertices) {
            if (v.getNome().equals(nome)) {
                vertice = v;
                break;
            }
        }
        return vertice;
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
        Grafo gComplementar = new Grafo(this.nome + " Complementar");
        List<Vertice> vertices = new ArrayList<>();
        
        for (Vertice v : this.vertices) {
            Vertice vertice = new Vertice(v.getNome() + "C");
            List<Vertice> adjacencias = new ArrayList(Arrays.asList(v.getAdjacencias()));
            List<Vertice> adjacenciasComplementar = new ArrayList<>();
            for (Vertice v2 : this.vertices) {
                if (!v2.equals(v) && !adjacencias.contains(v2)) {
                    adjacenciasComplementar.add(new Vertice(v2.getNome() + "C"));
                }
            }
            Vertice[] arr = new Vertice[adjacenciasComplementar.size()];
            vertice.setAdjacencias(adjacenciasComplementar.toArray(arr));
            vertices.add(vertice);
        }
        
        Vertice[] arr = new Vertice[vertices.size()];
        gComplementar.setVertices(vertices.toArray(arr));
        
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
     * Informa se este grafo é formetente conexo.
     * Para isto verifica se cada vértice está ligado a qualquer outro.
     * @return 
     */
    public boolean isFConexo() {
        boolean isFConexo = true;
        for (Vertice vertice : this.vertices) {
            if (vertice.getAdjacencias().length < this.vertices.length - 1) {
                isFConexo = false;
                break;
            }
        }
        
        return isFConexo;
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
    
    public MatrizAdjacencias montarMatriz() {
        Integer[][] matriz = new Integer[this.vertices.length][this.vertices.length];
        
        for (int x = 0; x < this.vertices.length; x++) {
            ArrayList<Vertice> adjacencias = new ArrayList(Arrays.asList(this.vertices[x].getAdjacencias()));
            for (int y = 0; y < this.vertices.length; y++) {
                matriz[x][y] = adjacencias.contains(this.vertices[y]) ? 1 : 0;
            }
        }
        
        return new MatrizAdjacencias(matriz, this.nome);
    }
    
    public MatrizAdjacencias getTransposto() {
        Integer[][] matriz     = this.montarMatriz().getMatriz();
        Integer[][] transposto = new Integer[matriz.length][matriz[0].length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                transposto[j][i] = matriz[i][j];
            }
        }
        
        return new MatrizAdjacencias(transposto, this.nome + " - Transposto");
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
        Integer[][] matriz = this.montarMatriz().getMatriz();
        for (int x = 0; x < this.vertices.length; x++) {
            int consecutivos = 0;
            for (int y = 0; y < this.vertices.length; y++) {
                int virtualX = x + consecutivos;
                if (x+consecutivos >= this.vertices.length) virtualX = (x + consecutivos) - this.vertices.length;
                if (matriz[virtualX][y] == 1) {
                    consecutivos++;
                } 
                if (consecutivos >= 2 && matriz[x][y] == 1) {
                    return true;
                } 
                if (matriz[virtualX][y] != 1) consecutivos = 0;
            }
        }
        return false;
    }
    
    /**
     * Informa se este grafo possui especificamente algum ciclo impar.
     * Isto é útil para descobrir se o grafo é bipartido.
     * @return 
     */
    public boolean hasCicloImpar() {
        Integer[][] matriz = this.montarMatriz().getMatriz();
        for (int x = 0; x < this.vertices.length; x++) {
            int consecutivos = 0;
            for (int y = 0; y < this.vertices.length; y++) {
                int virtualX = x + consecutivos;
                if (x+consecutivos >= this.vertices.length) virtualX = (x + consecutivos) - this.vertices.length;
                if (matriz[virtualX][y] == 1) {
                    consecutivos++;
                } 
                if (consecutivos >= 2 && (consecutivos + 1) % 2 != 0 && matriz[x][y] == 1) {
                    return true;
                } 
                if (matriz[virtualX][y] != 1) consecutivos = 0;
            }
        }
        return false;
    }
    
    /**
     * Informa o grau de um vértice enviado por parâmetro.
     * @param vertice
     * @return 
     */
    public int getGrau(Vertice vertice) {
        return vertice.getGrau();
    }
    
    /**
     * Informa o grau de entrada de um vértice enviado por parâmetro.
     * Para isto percorre todos os vértices e verifica quandos se dirigem a este.
     * @param vertice
     * @return 
     */
    public int getGrauEntrada(Vertice vertice) {
        int grauEntrada = 0;
        for (Vertice v : this.vertices) {
            if (v.isAdjacente(vertice)) {
                grauEntrada++;
            }
        }
        return grauEntrada;
    }
    
    /**
     * Realiza a ordenação topológica do grafo.
     * Percorre os vértices em profundidade e ao chegar em algum que não possua
     * nenhuma adjacência não visitada, este será adicionado no início da lista.
     * @return 
     */
    public List<Vertice> ordenacaoTopologica() {
        List<Vertice> sortedGraph = new ArrayList<>();
        
        if (!this.hasCiclo()) {
            this.profundidadeTopologicalSort(this.vertices[0], sortedGraph);
        } else System.out.println("Obs: Tentativa de realizar ordenação em grafo cíclico");
        
        return sortedGraph;
    }
    
    public void profundidadeTopologicalSort(Vertice current, List<Vertice> sortedGraph) {
    	List<Vertice> visited = new ArrayList<>();
    	this.profundidadeTopologicalSort(current, sortedGraph, visited);
    }

    public void profundidadeTopologicalSort(Vertice current, List<Vertice> sortedGraph, List<Vertice> visited) {
    	if (visited.contains(current)) return ;
    	
    	visited.add(current);
    	for (Vertice adjacencia : current.getAdjacencias()) {
            this.profundidadeTopologicalSort(adjacencia, sortedGraph, visited);
        }
        
        sortedGraph.add(0, current);
    }
    
    public void setInDegrees() {
        for (Vertice v : this.vertices) {
            v.inDegree = this.getGrauEntrada(v);
        }
    }
    
    @Override
    public String toString() {
        String string = "Lista de adjacências do grafo " + this.nome + ": \n";
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
