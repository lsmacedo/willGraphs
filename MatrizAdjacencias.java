/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class MatrizAdjacencias {
    
    private Integer[][] matriz;
    private String      nomeGrafo;
    
    public MatrizAdjacencias(Integer[][] matriz, String nomeGrafo) {
        this.matriz    = matriz;
        this.nomeGrafo = nomeGrafo;
    }
    
    public Integer[][] getMatriz() {
        return this.matriz;
    }
    
    @Override
    public String toString() {
        String string = "Matriz de adjacências do grafo " + this.nomeGrafo + ":\n";
        for (int i = 0; i < this.matriz.length; i++) {
            if (i != 0) string += "\n";
            string += Arrays.toString(this.matriz[i]);
        }
        return string;
    }
    
}
