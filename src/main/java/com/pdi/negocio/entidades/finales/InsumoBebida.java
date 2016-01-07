/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.enums.TipoDeInsumo;
import com.pdi.negocio.interfaces.Valuable;

/**
 *
 * @author Marcos Sastre
 */
public class InsumoBebida implements Valuable{
    //Atributos
    private int id;
    private TipoDeInsumo tipo;
    private String marca;
    private float precio;
    private float contenido;
    private float stock;
    private static float MINIMO;
    
    //Constructores

    public InsumoBebida() {
    }

    public InsumoBebida(int id, TipoDeInsumo tipo, String marca,  float precio,
            float contenido, float stock) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.contenido = contenido;
        this.stock = stock;
    }

    
    //Metodos
    @Override
    public float valuar(){
        return stock * precio;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDeInsumo getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeInsumo tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getMinimo() {
        return InsumoBebida.MINIMO;
    }

    public void setMinimo(float minimo) {
        InsumoBebida.MINIMO = minimo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getContenido() {
        return contenido;
    }

    public void setContenido(float contenido) {
        this.contenido = contenido;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }
   

    
}
