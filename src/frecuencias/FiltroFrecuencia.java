/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public abstract class FiltroFrecuencia {
    private NumeroComplejo[][] matriz;

    public FiltroFrecuencia(int ancho, int alto) {
        this.matriz = new NumeroComplejo[ancho][alto];
    }
    
    public abstract void generar();
    
    public Image toImage(){
    // declaramos el buffer
     BufferedImage bi = 
                new BufferedImage(this.matriz.length,this.matriz.length, BufferedImage.TYPE_INT_RGB);
    // recorrer el buffered
    for (int x=0; x<bi.getWidth();x++)
        for(int y=0; y<bi.getHeight();y++){
        int rgb = (int)this.matriz[x][y].getReal();
        bi.setRGB(x, y, rgb);
                
    }
    
    return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    /**
     * @return the matriz
     */
    public NumeroComplejo[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(NumeroComplejo[][] matriz) {
        this.matriz = matriz;
    }
    
    
}
