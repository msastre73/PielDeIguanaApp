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
public class Aliado extends Persona{
    //Atributos
    private List<Evento> eventos;
    private float comisionMonto;
    private float comisionPorcentaje;
    
    //Constructores

    public Aliado() {
    }

    public Aliado(List<Evento> eventos, float comisionMonto, float comisionPorcentaje, int id, String nombre, String apellido, String mail) {
        super(id, nombre, apellido, mail);
        this.eventos = eventos;
        this.comisionMonto = comisionMonto;
        this.comisionPorcentaje = comisionPorcentaje;
    }
    
    //Metodos
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
