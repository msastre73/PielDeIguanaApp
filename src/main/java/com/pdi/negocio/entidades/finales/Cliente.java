/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.entidades.base.Persona;
import java.util.List;

/**
 *
 * @author Marcos Sastre
 */
public class Cliente extends Persona{
    //Atributos
    private List<Evento> eventos;
    private float descuento;
    
    //Constructores

    public Cliente() {
    }

    public Cliente(List<Evento> eventos, float descuento, int id, String nombre,
            String apellido, String mail) {
        super(id, nombre, apellido, mail);
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

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    
    
}
