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
public class Expansion {
    
    public static Image expansionLineal(double min, double max, Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen 
        for(int x=0; x<bi.getWidth();x++){
            for (int y=0;y<bi.getHeight();y++){
            // extraer los valores por canal
            Color color = new Color(bi.getRGB(x, y));
            int r = (int)validarRango((255/(max-min))*(color.getRed()-min));
            int g = (int)validarRango((255/(max-min))*(color.getGreen()-min));
            int b = (int)validarRango((255/(max-min))*(color.getBlue()-min));
            color = new Color(r, g, b);
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    public static int calcularMinimo(int histo[]){
    // recorremos el histograma de izq-der
        for(int x=0;x<histo.length;x++){
            if(histo[x]!=0){
            return x;
            }
        
        }
        return -1;
    }
    public static Image expansionLogaritmica(int j ,Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen 
        for(int x=0; x<bi.getWidth();x++){
            for (int y=0;y<bi.getHeight();y++){
            // extraer los valores por canal
            Color color = new Color(bi.getRGB(x, y));
            int r = (int)validarRango(255*Math.log(j+color.getRed())/Math.log(256));
            int g = (int)validarRango(255*Math.log(j+color.getGreen())/Math.log(256));
            int b = (int)validarRango(255*Math.log(j+color.getBlue())/Math.log(256));
            color = new Color(r, g, b);
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    public static int calcularMaximo(int histo[]){
    // recorremos el histograma de der-izq
        for(int x=histo.length-1;x>-1;x--){
            if(histo[x]!=0){
            return x;
            }
        
        }
        return -1;
    }
    public static double validarRango(double valor){
        if(valor>255)return 255;
        if(valor<0)return 0;
        return valor;
    
    }

}
