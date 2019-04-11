/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

/**
 *
 * @author Roberto Cruz Leija
 */
public class NumeroComplejo {
    private double real;
    private double imaginaria;

    public NumeroComplejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }
    
    public NumeroComplejo(NumeroComplejo aux){
        this(aux.getReal(),aux.getImaginaria());
    }
    // TODO: VERIFICAR SI ME RETORNA UNO NUEVO Y DEFINIR LA MULTI
//    public void sumar (NumeroComplejo aux){
//        this.real+=aux.getReal();
//        this.imaginaria+=aux.getImaginaria();
//    }
//    
//     public void multiplicar(NumeroComplejo aux){
//        this.real*=aux.getReal();
//        this.imaginaria*=aux.getImaginaria();
//    }

    /**
     * @return the real
     */
    public double getReal() {
        return real;
    }

    /**
     * @return the imaginaria
     */
    public double getImaginaria() {
        return imaginaria;
    }
    
    
}
