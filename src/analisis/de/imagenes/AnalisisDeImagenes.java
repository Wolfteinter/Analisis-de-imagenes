/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.de.imagenes;

import GUI.JFrameImagen;
import frecuencias.FiltroButterworthPasaBajas;
import frecuencias.FiltroExponencialPasaBajas;
import frecuencias.FiltroIdealPasaAltas;
import frecuencias.FiltroIdealPasaBajas;
import frecuencias.Gestor;
import frecuencias.HerramientasColor;
import frecuencias.NumeroComplejo;
import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import muestreo.Convolucion2;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         BufferedImage bi = ImageManager.toBufferedImage(ImageManager.openImage());
         Color color = new Color(bi.getRGB(120, 34));
         int r =  color.getRed();
         int g =  color.getGreen();
         int b =  color.getBlue();
         Gestor gestor = new Gestor(bi);
         NumeroComplejo [][] aux = gestor.representacionEspacial.get(HerramientasColor.CanalColor.AZUL);
         System.out.println();
//        FiltroExponencialPasaBajas filtro = new FiltroExponencialPasaBajas(512, 512, 150,2);
//        filtro.generar();
//        Image imagen = filtro.toImage();
//        JFrameImagen frame1 = new JFrameImagen(imagen);
        //double kernel [][] = new double[][]{{-2,-1,0},{-1,1,1},{0,1,2}};
        //double kernel [][] = new double[][]{{0,1,0},{1,-4,1},{0,1,0}};
        //double kernel2 [][] = new double[][]{{1,1,1,1,1},{1,4,4,4,1},{1,4,12,4,1},{1,4,4,4,1},{1,1,1,1,1}};
        ///Convolucion2 convo = new Convolucion2(imagen);
        //Image nueva = convo.aplicar(kernel, 1);
        
        
       // JFrameImagen frame2 = new JFrameImagen(nueva);        System.out.println();
            
    }
    
}
