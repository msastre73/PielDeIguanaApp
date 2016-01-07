/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

/**
 *
 * @author Marcos Sastre
 */
public class Caja {
    //Atributos
    private float saldo;
    private float minimo;
    private boolean minOK;
    
    //Constructores

    public Caja() {
    }

    public Caja(float saldo, float minimo, boolean minOK) {
        this.saldo = saldo;
        this.minimo = minimo;
        this.minOK = minOK;
    }
    
    //Metodos
    public void cobrar(float monto){
        //TODO - Chequear que no sea negativo y sumarle al saldo
    }
    
    public void pagar(float monto){
        //TODO - chequear que no sea negativo y que no sobrepase el minimo, en
        //caso de que ambas validaciones sean postivas, afectar el saldo
    }
    
    
    //Getters y Setters

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public boolean isMinOK() {
        return minOK;
    }

    public void setMinOK(boolean minOK) {
        this.minOK = minOK;
    }
    
          
    
}
