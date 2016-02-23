/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import java.util.Date;

/**
 *
 * @author Marcos
 */
public class Imputacion {
    //Atributos
    private String objectId;
    private Date created;
    private Date updated;
    private Date fecha;
    private String concepto;
    private float monto;
    
    //Constructores

    public Imputacion() {
    }

    public Imputacion(String objectId, Date created, Date updated, Date fecha, String concepto, float monto) {
        this.objectId = objectId;
        this.created = created;
        this.updated = updated;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
}
