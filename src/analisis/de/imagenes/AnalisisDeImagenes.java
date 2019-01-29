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
        BufferedImage bf = ImageManager.toBufferedImage(imagen);
        Color verde = new Color(254, 245, 1);
        bf.setRGB(23, 100, verde.getRGB());
        bf.setRGB(24, 100, verde.getRGB());
        bf.setRGB(23, 101, verde.getRGB());
        bf.setRGB(24, 101, verde.getRGB());
        Image nueva = ImageManager.toImage(bf);
        JFrameImagen frame2 = new JFrameImagen(nueva);
        System.out.println();
            
    }
    
}
