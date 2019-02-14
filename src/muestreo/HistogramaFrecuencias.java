/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class HistogramaFrecuencias {
    
    private Image imagenOriginal;
    private int histogramaR[];
    private int histogramaG[];
    private int histogramaB[];

    public HistogramaFrecuencias(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.histogramaR = new int[256];
        this.histogramaG = new int[256];
        this.histogramaB = new int[256];
         // calcular los histogramas por cada uno de los colores
        calcularHistogramas();
    }
    public void graficarHistogramasRGB(){
    // graficar los Histogramas
    Grafica grafica = new Grafica("Histogramas RGB","Color","Frecuencias");
    grafica.agregarSerie("Rojo", this.getHistogramaR());
    grafica.agregarSerie("Azul", this.getHistogramaB());
    grafica.agregarSerie("Verde", this.getHistogramaG());
    grafica.crearGrafica();
    
    }

    private void calcularHistogramas() {
        // recorrido de la imagen y contamos las frecuencias de color
        BufferedImage bi = ImageManager.toBufferedImage(this.imagenOriginal);
        // recorrer el BufferedImage 
        for (int x=0; x < bi.getWidth();x++)
            for(int y=0; y < bi.getHeight();y++){
                Color pixel = new Color(bi.getRGB(x, y));
                this.getHistogramaR()[pixel.getRed()]++;
                this.getHistogramaG()[pixel.getGreen()]++;
                this.getHistogramaB()[pixel.getBlue()]++;
            }
    }

    /**
     * @return the histogramaR
     */
    public int[] getHistogramaR() {
        return histogramaR;
    }

    /**
     * @return the histogramaG
     */
    public int[] getHistogramaG() {
        return histogramaG;
    }

    /**
     * @return the histogramaB
     */
    public int[] getHistogramaB() {
        return histogramaB;
    }
    
}
