/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import frecuencias.HerramientasColor.CanalColor;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import muestreo.Convolucion;
import muestreo.Expansion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Gestor {
    // imagen original
    private BufferedImage imagenOriginal;
    public Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionEspacial;
    Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionFrecuencias;

    public Gestor(BufferedImage imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.representacionEspacial = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
        this.representacionFrecuencias = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
        // obtener la informacion de los pixeles y crear los mapeos correspondientes
        for(HerramientasColor.CanalColor color: HerramientasColor.CanalColor.values()){
        
            this.representacionEspacial.put(color,obtenerDatosPorCanal(color,this.imagenOriginal));
        
        }
    }

    private NumeroComplejo[][] obtenerDatosPorCanal(HerramientasColor.CanalColor color, BufferedImage imagenOriginal) {
       NumeroComplejo[][] aux = new NumeroComplejo[this.imagenOriginal.getWidth()][this.imagenOriginal.getHeight()];
       //  recorremos en un ciclo el buffered para crear los diferentes numeros complejos
       for(int x=0;x<this.imagenOriginal.getWidth();x++){
           for(int y=0;y<this.imagenOriginal.getHeight();y++){
               aux[x][y] = new NumeroComplejo(HerramientasColor.obtenerValorPorCanal(imagenOriginal.getRGB(x, y), color),0);
           }
       }
       return aux;
    }
    
    public BufferedImage obtenerImagenFrecuencias(boolean reAjustarCuadrante) {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        for (CanalColor canal : HerramientasColor.CanalColor.values()) {
            NumeroComplejo[][] datos = this.representacionEspacial.get(canal);
            NumeroComplejo[][] transformada = fft.calculateFT(datos, false);
            representacionFrecuencias.put(canal, transformada);
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {
                    // modificamos la posicion de los cuadrantes 
                    int ejeX = reAjustarCuadrante ? (x + (anchoImagen / 2)) % anchoImagen : x;
                    int ejeY = reAjustarCuadrante ? (y + (altoImagen / 2)) % altoImagen : y;
                    // setear la info a la imagen 
                    // el que se ecuentre en la imagen 
                    int color1 = aux.getRGB(x, y);
                    int color2 = obtenerColorRealDeFrecuencia(ejeX, ejeY, transformada, canal);
                    int rgb = HerramientasColor.acumularColor(color1, color2);
                    aux.setRGB(x, y, rgb);

                }
            }
        }
        return aux;
    }

  private int obtenerColorRealDeFrecuencia(int ejeX, int ejeY, NumeroComplejo[][] transformada, CanalColor canal) {
        int color = (int) Math.abs(transformada[ejeX][ejeY].getParteReal());
        color = (int) Expansion.validarRango(color);
        color = HerramientasColor.obtenerRGBporCanal(color, canal);
        return color;
    }

    
}
