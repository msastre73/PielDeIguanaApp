/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.entidades.base.Insumo;
import com.pdi.negocio.interfaces.Valuable;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class Varios extends Insumo {
    //Atributos
    String concepto;
    
    //Constructores

    public Varios() {
    }

    public Varios(String concepto, float existencia, float valor, float minimo) {
        super(existencia, valor, minimo);
        this.concepto = concepto;
    }

    
    
    //Metodos
    public String chequearEstado(){
        if(super.getExistencia() >= super.getMinimo()){
            return "OK";
        }else{
            float dif = super.getMinimo() - super.getExistencia();
            return "Faltan " + dif + " unidades de " + concepto + "\n";
        }
    }
    @Override
    public String toString() {
    return concepto;  
    }
     
     
     
     
     //Getters y Setters

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
     
    
    
    
}
