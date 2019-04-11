/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import java.awt.Color;

/**
 *
 * @author Roberto Cruz Leija
 */
public class FiltroIdealPasaBajas extends FiltroFrecuencia{

    private double radio;
    
    public FiltroIdealPasaBajas(int ancho, int alto, double radio) {
        super(ancho, alto);
        this.radio = radio;
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
               Color color;
               // verficamos si p es menor al radio 
               if (p<=this.radio){
               // pintamos en blanco
               color = new Color(255, 255, 255);
               aux[x][y] = new NumeroComplejo(color.getRGB(),0);
               }else{
               // pintamos en negro
               color = new Color(0,0,0);
               aux[x][y] = new NumeroComplejo(color.getRGB(),0);
               }
           }
       }
    }
    
}
