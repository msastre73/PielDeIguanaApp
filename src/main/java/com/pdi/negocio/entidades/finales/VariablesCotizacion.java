/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;


import java.util.Date;


/**
 *
 * @author Marcos Sastre
 */
public class VariablesCotizacion {

    //Atributos
    private String objectId;
    private Date created;
    private Date updated;
    private float gananciaFijo;
    private float gananciaVariable;
    private float tasaRecargo;
    private float factorPromo;
    private float fleteLocal;
    private float fleteAfuera;

    //Constructores
    public VariablesCotizacion() {
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

    public float getGananciaFijo() {
        return gananciaFijo;
    }

    public void setGananciaFijo(float gananciaFijo) {
        this.gananciaFijo = gananciaFijo;
    }

    public float getGananciaVariable() {
        return gananciaVariable;
    }

    public void setGananciaVariable(float gananciaVariable) {
        this.gananciaVariable = gananciaVariable;
    }

    public float getTasaRecargo() {
        return tasaRecargo;
    }

    public void setTasaRecargo(float tasaRecargo) {
        this.tasaRecargo = tasaRecargo;
    }

    public float getFactorPromo() {
        return factorPromo;
    }

    public void setFactorPromo(float factorPromo) {
        this.factorPromo = factorPromo;
    }

    public float getFleteLocal() {
        return fleteLocal;
    }

    public void setFleteLocal(float fleteLocal) {
        this.fleteLocal = fleteLocal;
    }

    public float getFleteAfuera() {
        return fleteAfuera;
    }

    public void setFleteAfuera(float fleteAfuera) {
        this.fleteAfuera = fleteAfuera;
    }
    

}
