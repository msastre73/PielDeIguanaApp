/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.entidades.base.Insumo;
import com.pdi.negocio.interfaces.Valuable;
import java.util.Date;

/**
 *
 * @author Marcos Sastre
 */
public class Bebida extends Insumo{
    //Atributos
    private String tipo;
    private String marca;
    private float contenido;
       
    
    //Constructores
    public Bebida() {
    }

    public Bebida(String tipo, String marca, float contenido, float existencia, float valor, float minimo) {
        super(existencia, valor, minimo);
        this.tipo = tipo;
        this.marca = marca;
        this.contenido = contenido;
    }



   //Metodos
    
        
    public String chequearEstado(){
        if(super.getExistencia() >= super.getMinimo()){
            return "OK";
        }else{
            float dif = super.getMinimo() - super.getExistencia();
            return "Faltan " + dif + " unidades de " + tipo + " " + marca + "\n";
        }
    }
    
    @Override
    public String toString() {
    return tipo;  
    }
    

    
    
    
    
    //Getters y Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getContenido() {
        return contenido;
    }

    public void setContenido(float contenido) {
        this.contenido = contenido;
    }

  
    
}
