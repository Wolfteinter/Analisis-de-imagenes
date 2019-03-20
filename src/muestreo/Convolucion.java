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
public class Convolucion {
    
    public static Image convolucionar(Image imagenOriginal, double [][] kernel, double fD){
    
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        BufferedImage nueva = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        // recorrer la imagen para general la nueva 
        for (int x=0;x<bi.getWidth();x++){
            for(int y=0;y<bi.getHeight();y++){
            // valorar si aplica la convolucion 
            // recorremos el kernel
            double cE =0;
            double aR = 0,aG = 0,aB = 0;
            int xx=0,yy=0;
            Color color;
            for(int i=x-(kernel.length-1)/2;i<=x+(kernel.length-1)/2;i++,xx++){
                yy = 0;
                for(int j=y-(kernel.length-1)/2;j<=y+(kernel.length-1)/2;j++,yy++){
                // con los valore de i y j consultamos al buffered
                try{
                color = new Color(bi.getRGB(i, j));
                aR+=kernel[xx][yy]*color.getRed();
                aG+=kernel[xx][yy]*color.getGreen();
                aB+=kernel[xx][yy]*color.getBlue();
                }catch(Exception e){
                // seteamos el color con la imagen original
                cE++;
                //nueva.setRGB(x, y, bi.getRGB(x, y));
                }
                }
                xx=0;
            }
            if(x==16 && y==16){
            System.out.println();
            }
            // aplicar el fD
            aR/=(fD-cE);
            aG/=(fD-cE);
            aB/=(fD-cE);
            color = new Color((int)Expansion.validarRango(aR),(int)Expansion.validarRango(aG),(int)Expansion.validarRango(aB));
            // seteamos en el buffer nuevo
            nueva.setRGB(x, y,color.getRGB());
            }
        
        }
    Color color = new Color(nueva.getRGB(15, 15));
    
    return ImageManager.toImage(nueva);
    }
    
}
