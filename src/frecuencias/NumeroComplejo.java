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
    
    private  double real;
    private  double imaginaria;

    public NumeroComplejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }
    public NumeroComplejo(NumeroComplejo complejo){
      this(complejo.getParteReal(),complejo.getParteImaginaria());   
    }

    /**
     * @return the real
     */
    public double getParteReal() {
        return real;
    }

    /**
     * @return the imaginaria
     */
    public double getParteImaginaria() {
        return imaginaria;
    }
    
    public NumeroComplejo sumar(NumeroComplejo segundo) {
                //obtiene la referencia al objeto
		NumeroComplejo primero = this; 
		double real = primero.real + segundo.real;
		double imag = primero.imaginaria + segundo.imaginaria;
		return new NumeroComplejo(real, imag);
	}

	public NumeroComplejo producto(double multiplicador) {
		return new NumeroComplejo(real * multiplicador, imaginaria * multiplicador);
	}
    

}
