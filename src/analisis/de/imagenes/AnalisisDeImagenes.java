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
       
        Image contraste = Expansion.expansionLogaritmica(2,grises);
        JFrameImagen frame3 = new JFrameImagen(contraste);
        HistogramaFrecuencias histo2 = new HistogramaFrecuencias(contraste);
        histo2.graficarHistogramasRGB();
        
        System.out.println();
            
    }
    
}
