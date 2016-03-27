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
    private ArrayList<Evento> eventos;
    private float descuento;
    
    //Constructores

    public Cliente() {
    }

    public Cliente(ArrayList<Evento> eventos, float descuento, String objectId, String nombre,
            String apellido, String mail) {
        super(objectId, nombre, apellido, mail);
        this.eventos = eventos;
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
    
    public int getCantidadDeEventos(){
        return eventos.size();
    }
    
    //Getters y Setters

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

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
