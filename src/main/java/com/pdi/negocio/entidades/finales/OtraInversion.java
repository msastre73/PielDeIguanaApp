/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.entidades.base.Inversion;

/**
 *
 * @author Marcos Sastre
 */
public class OtraInversion extends Inversion{
    
    //Atributos
    private int id;
    private float presupuestoAsignado;
    private String comentarios;
    
    //Constructores

    public OtraInversion() {
    }

    public OtraInversion(int id, float presupuestoAsignado, String comentarios, String nombre, String objetivo) {
        super(nombre, objetivo);
        this.id = id;
        this.presupuestoAsignado = presupuestoAsignado;
        this.comentarios = comentarios;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPresupuestoAsignado() {
        return presupuestoAsignado;
    }

    public void setPresupuestoAsignado(float presupuestoAsignado) {
        this.presupuestoAsignado = presupuestoAsignado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
