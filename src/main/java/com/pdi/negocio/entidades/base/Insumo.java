/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.base;

import com.pdi.negocio.interfaces.Valuable;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public abstract class Insumo implements Valuable {

    //Atributos

    private String objectId;
    private Date created;
    private Date updated;
    private float existencia;
    private float valor;
    private float minimo;

    //Constructores
    public Insumo() {
    }

    public Insumo(float existencia, float valor, float minimo) {

        this.existencia = existencia;
        this.valor = valor;
        this.minimo = minimo;
    }

    //Metodos
    public float valuar() {
        return existencia * valor;
    }


    //Getters y Setters 
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

}
