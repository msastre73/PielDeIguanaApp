/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.base;

/**
 *
 * @author Marcos Sastre
 */
public abstract class Inversion {
    //Atributos
    private String nombre;
    private String objetivo;
    
    //Constructores

    public Inversion() {
    }

    public Inversion(String nombre, String objetivo) {
        this.nombre = nombre;
        this.objetivo = objetivo;
    }
    
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    
    
}
