/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import java.awt.Color;
import muestreo.Expansion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class FiltroExponencialPasaBajas extends FiltroFrecuencia{

    private double radio;
    private double n;
    
    public FiltroExponencialPasaBajas(int ancho, int alto, double radio, double n) {
        super(ancho, alto);
        this.radio = radio;
        this.n = n ;
    }

    @Override
    public void generar() {
       NumeroComplejo[][] aux =getMatriz();
       // recorremos la matriz y verificamos si el punto trasladado es <= al radop
       for(int x=0; x<aux.length;x++){
           for(int y=0;y<aux.length;y++){
           
               int u = -1*(aux.length/2)+x;
               int v = (aux.length/2)-y;
               
               double p = Math.sqrt(Math.pow(u,2)+Math.pow(v,2));
               double res = Math.exp(-1*Math.pow(p/this.radio,this.n));
               //double res = Math.exp(p/this.radio);
               int res2 = (int)Expansion.validarRango(res*255);
               
               Color color = new Color(res2, res2, res2);
               // asignamos en el color que le corresponde
               
               // pintamos en blanco
               
               aux[x][y] = new NumeroComplejo(color.getRGB(),0);
           }
       }
    }
    
}
