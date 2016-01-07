/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.interfaces.Valuable;
import java.util.List;

/**
 *
 * @author Marcos Sastre
 */
public class Inventario implements Valuable{
    //Atributos
    private List<InsumoBebida> bebidas;
    private List<Vaso> vasos;
    private List<Sorbete> sorbete;
    private List<InsumoBebida> insumoBebidasMin;
    private List<Vaso> vasosMin;
    private List<Sorbete> sorbetesMin;
    private boolean minOK;
    
    //Constructores

    public Inventario() {
    }

    public Inventario(List<InsumoBebida> bebidas, List<Vaso> vasos, 
            List<Sorbete> sorbete, List<InsumoBebida> insumoBebidasMin,
            List<Vaso> vasosMin, List<Sorbete> sorbetesMin, boolean minOK) {
        this.bebidas = bebidas;
        this.vasos = vasos;
        this.sorbete = sorbete;
        this.insumoBebidasMin = insumoBebidasMin;
        this.vasosMin = vasosMin;
        this.sorbetesMin = sorbetesMin;
        this.minOK = minOK;
    }
    
    //Metodos

    @Override
    public float valuar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void chequearMin(){
        //TODO - Comparar cantidades en stock con las cantidades minimas
    }
    
    //Getters y Setters

    public List<InsumoBebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<InsumoBebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Vaso> getVasos() {
        return vasos;
    }

    public void setVasos(List<Vaso> vasos) {
        this.vasos = vasos;
    }

    public List<Sorbete> getSorbete() {
        return sorbete;
    }

    public void setSorbete(List<Sorbete> sorbete) {
        this.sorbete = sorbete;
    }

    public List<InsumoBebida> getInsumoBebidasMin() {
        return insumoBebidasMin;
    }

    public void setInsumoBebidasMin(List<InsumoBebida> insumoBebidasMin) {
        this.insumoBebidasMin = insumoBebidasMin;
    }

    public List<Vaso> getVasosMin() {
        return vasosMin;
    }

    public void setVasosMin(List<Vaso> vasosMin) {
        this.vasosMin = vasosMin;
    }

    public List<Sorbete> getSorbetesMin() {
        return sorbetesMin;
    }

    public void setSorbetesMin(List<Sorbete> sorbetesMin) {
        this.sorbetesMin = sorbetesMin;
    }

    public boolean isMinOK() {
        return minOK;
    }

    public void setMinOK(boolean minOK) {
        this.minOK = minOK;
    }
    
}
