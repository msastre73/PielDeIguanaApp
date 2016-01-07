/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.interfaces.Valuable;

/**
 *
 * @author Marcos Sastre
 */
public class Vaso implements Valuable{
    //Atributos
    private int id;
    private float precio;
    private float stock;
    private static int MINIMO;
    
    //Constructores

    public Vaso() {
    }

    public Vaso(int id, float precio, float stock) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }

    //Metodos
    
    @Override
    public float valuar() {
        return stock * precio;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public int getMinimo() {
        return Vaso.MINIMO;
    }

    public void setMinimo(int minimo) {
        Vaso.MINIMO = minimo;
    }
    
    
    
}
