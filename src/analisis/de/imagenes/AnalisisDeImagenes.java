/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.de.imagenes;

import GUI.JFrameImagen;
import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import muestreo.EscalaGrises;
import muestreo.HistogramaFrecuencias;

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
        
        
        System.out.println();
            
    }
    
}
