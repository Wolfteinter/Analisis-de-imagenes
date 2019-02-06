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
public class EscalaGrises {
    
    public static Image generarImagenEnGrises(Image original){
        BufferedImage bi = ImageManager.toBufferedImage(original);
     // recorrido por pixel para hacer el tono gris
     for(int x=0; x<bi.getWidth();x++){
         for(int y=0;y<bi.getHeight();y++){
         Color color = new Color(bi.getRGB(x, y));
         int gris = (color.getRed()+color.getGreen()+color.getBlue())/3;
         color = new Color(gris,gris,gris);
         bi.setRGB(x, y, color.getRGB());
         }
     }
     return ImageManager.toImage(bi);
    }
    
}
