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
public class MatrizAdjacencias {
    
    private Integer[][] matriz;
    
    public MatrizAdjacencias(Integer[][] matriz) {
        this.matriz = matriz;
    }
    
    public Integer[][] getMatriz() {
        return this.matriz;
    }
    
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < this.matriz.length; i++) {
            if (i != 0) string += "\n";
            string += Arrays.toString(this.matriz[i]);
        }
        return string;
    }
    
}
