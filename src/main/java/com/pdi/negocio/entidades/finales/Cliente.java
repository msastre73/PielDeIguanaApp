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
public class Cliente extends Persona{
    //Atributos
    
    private float descuento;
    
    //Constructores

    public Cliente() {
    }

    public Cliente(float descuento, String objectId, String nombre,
            String apellido, String mail) {
        super(objectId, nombre, apellido, mail);
        
        this.descuento = descuento;
    }
    
    //Metodos
    
    public void aceptarEvento(Evento e){
        //TODO - Desarrollar codigo
    }
    
    public void rechazarEvento(Evento e){
        //TODO - Desarrollar codigo
    }
    
    public void pagarEvento(){
        //TODO - Desarrollar codigo
    }
    
    
    
    //Getters y Setters


    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }
    
    
    
    
}
