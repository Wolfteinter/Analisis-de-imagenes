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
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Umbralizacion {
   
    public static int obtenerUmbralAutomatico(int histograma[]){
        // calculamos el umbral inicial
        Random ran = new Random();
        int uR = ran.nextInt(256);
        System.out.println(uR);
        int uA;
        // hacemos el proceso iterativo de reajuste dl umbral inicial
        do{
        uA = uR;    
        uR = reajustarUmbral(uA,histograma);
        System.out.println(uR);
        }while(uR!=uA);
    
        return uR;
    }
    
    public static Image umbralizacionSimple(int u, Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos el buffer
        for(int x=0; x<bi.getWidth();x++){
            for(int y=0;y<bi.getHeight();y++){
                Color color = new Color(bi.getRGB(x, y));
                int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
                if(prom<u){color = new Color(0, 0, 0);}
                else{
                color = new Color(255, 255, 255);
                }
                bi.setRGB(x, y,color.getRGB());
                
                
            
            }
        }
       return ImageManager.toImage(bi);
    }

    private static int reajustarUmbral(int u, int[] histograma) {
       int aFi=0,aPi=0;
       int aFd=0,aPd=0;
       aPi+=histograma[0];
       for(int x=1;x<u;x++){
            aPi+=histograma[x]*x;
            aFi+=histograma[x];
       }
       for(int y=u;y<histograma.length;y++){
            aPd+=histograma[y]*y;
            aFd+=histograma[y];
       }
       if(aFi==0||aFd==0)return 0;
       int uI = aPi/aFi;
       int uD = aPd/aFd;
       
       return (int)((uI+uD)/2);
    }
}
