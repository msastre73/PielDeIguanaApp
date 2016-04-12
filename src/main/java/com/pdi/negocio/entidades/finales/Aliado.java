/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.entidades.base.Persona;
import java.util.ArrayList;


/**
 *
 * @author Marcos Sastre
 */
public class Aliado extends Persona{
    //Atributos
    private float comisionMonto;
    private float comisionPorcentaje;
    
    //Constructores

    public Aliado() {
    }

    public Aliado(float comisionMonto, float comisionPorcentaje,
            String id, String nombre, String apellido, String mail) {
        super(id, nombre, apellido, mail);
        
        this.comisionMonto = comisionMonto;
        this.comisionPorcentaje = comisionPorcentaje;
    }
    
    //Metodos
    

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + ", Comision: " + getComisionPorcentaje()
                + ", Comision Acumulada: " + getComisionMonto();
    }
    
    
    
    //Getters y Setters


    public float getComisionMonto() {
        return comisionMonto;
    }

    public void setComisionMonto(float comisionMonto) {
        this.comisionMonto = comisionMonto;
    }

    public float getComisionPorcentaje() {
        return comisionPorcentaje;
    }

    public void setComisionPorcentaje(float comisionPorcentaje) {
        this.comisionPorcentaje = comisionPorcentaje;
    }
    
    
    
    
    
}
