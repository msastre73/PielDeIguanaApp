/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.base;

import java.util.Date;

/**
 *
 * @author Marcos Sastre
 */
public abstract class Persona {
    //Atributos
    private String objectId;
    private Date created;
    private Date updated; 
    private String nombre;
    private String apellido;
    private String mail;
    
    
    //Constructores

    public Persona() {
    }

    public Persona(String objectId, String nombre, String apellido, String mail) {
        this.objectId = objectId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    //Gettesr y Setters

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
