/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

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
    
    
    
}
