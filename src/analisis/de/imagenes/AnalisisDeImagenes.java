/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.de.imagenes;

import GUI.JFrameImagen;
import io.ImageManager;
import java.awt.Image;
import muestreo.Convolucion;
import muestreo.Convolucion2;
import muestreo.EscalaGrises;
import muestreo.Expansion;
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
        //double kernel [][] = new double[][]{{-2,-1,0},{-1,1,1},{0,1,2}};
        double kernel [][] = new double[][]{{0,1,0},{1,-4,1},{0,1,0}};
        //double kernel2 [][] = new double[][]{{1,1,1,1,1},{1,4,4,4,1},{1,4,12,4,1},{1,4,4,4,1},{1,1,1,1,1}};
        Convolucion2 convo = new Convolucion2(imagen);
        Image nueva = convo.aplicar(kernel, 1);
        
        
        JFrameImagen frame2 = new JFrameImagen(nueva);
        
       
        System.out.println();
            
    }
    
}
