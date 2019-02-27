/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.de.imagenes;

import GUI.JFrameImagen;
import io.ImageManager;
import java.awt.Image;
import muestreo.EscalaGrises;
import muestreo.Expansion;
import muestreo.HistogramaFrecuencias;
import muestreo.Umbralizacion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image imagen = ImageManager.openImage();
        JFrameImagen frame1 = new JFrameImagen(imagen);
        Image grises = EscalaGrises.generarImagenEnGrises(imagen);
        JFrameImagen frame2 = new JFrameImagen(grises);
        HistogramaFrecuencias histo = new HistogramaFrecuencias(grises);
        histo.graficarHistogramasRGB();
        int min = Expansion.calcularMinimo(histo.getHistogramaR());
        System.out.println(min);
        int max = Expansion.calcularMaximo(histo.getHistogramaR());
         System.out.println(max);
        Image contraste = Expansion.expansionLineal(min, max,grises);
        JFrameImagen frame3 = new JFrameImagen(contraste);
        HistogramaFrecuencias histo2 = new HistogramaFrecuencias(contraste);
        histo2.graficarHistogramasRGB();
        min = Expansion.calcularMinimo(histo2.getHistogramaR());
        System.out.println(min);
        max = Expansion.calcularMaximo(histo2.getHistogramaR());
         System.out.println(max);
        System.out.println();
            
    }
    
}
