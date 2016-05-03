/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.backendless.BackendlessCollection;
import com.pdi.negocio.interfaces.Valuable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Marcos Sastre
 */
public class Inventario implements Valuable{
    //Atributos
    private String objectId;
    private Date created;
    private Date updated;
    private List<Bebida> bebidas;
    private List<Vaso> vasos;
    private List<Sorbete> sorbete;
    private List<Bebida> insumoBebidasMin;
    private List<Vaso> vasosMin;
    private List<Sorbete> sorbetesMin;
    private boolean minOK;
    
    //Constructores

    public Inventario() {
    }

    public Inventario(String objectId, Date created, Date updated, List<Bebida> bebidas, List<Vaso> vasos, List<Sorbete> sorbete, List<Bebida> insumoBebidasMin, List<Vaso> vasosMin, List<Sorbete> sorbetesMin, boolean minOK) {
        this.objectId = objectId;
        this.created = created;
        this.updated = updated;
        this.bebidas = bebidas;
        this.vasos = vasos;
        this.sorbete = sorbete;
        this.insumoBebidasMin = insumoBebidasMin;
        this.vasosMin = vasosMin;
        this.sorbetesMin = sorbetesMin;
        this.minOK = minOK;
    }

    
    
    //Metodos

    public static HashMap<String, Float> obtenerExistencias(
    BackendlessCollection<Bebida> bebidasBK){
        HashMap<String, Float> existencias = new HashMap<String, Float>();
        
        List bebidasList = bebidasBK.getData();
        for(int i = 0; i < bebidasList.size(); i++){
            Bebida bebida = (Bebida) bebidasList.get(i);
            String tipo = bebida.getTipo().toLowerCase();
            Float exist = bebida.getExistencia();
            if(existencias.get(tipo) != null){
                
                exist += existencias.get(tipo);
            }
            existencias.put(tipo, exist);
        }
        System.out.println("EXISTENCIAS");
        for(String key: existencias.keySet()){
            System.out.println(key + ": " + existencias.get(key));
            
        }
        return existencias;
 
    }
    
    public static HashMap<String, Float> obtenerMinimos(
    BackendlessCollection<Bebida> bebidasBK){
        HashMap<String, Float> minimos = new HashMap<String, Float>();
         List bebidasList = bebidasBK.getData();
        for(int i = 0; i < bebidasList.size(); i++){
            Bebida bebida = (Bebida) bebidasList.get(i);
            String tipo = bebida.getTipo().toLowerCase();
            Float min = bebida.getMinimo();
            if(minimos.get(tipo) == null){
                
                minimos.put(tipo, min);
            }
            
        }
        System.out.println("MINIMOS");
        for(String key: minimos.keySet()){
            System.out.println(key + ": " + minimos.get(key));
            
        }
        return minimos;
        
    }
    
    
    @Override
    public float valuar() {
    return 0;
    }
    
    public void chequearMin(){
        //TODO - Comparar cantidades en stock con las cantidades minimas
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
    
    

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
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

    public List<Bebida> getInsumoBebidasMin() {
        return insumoBebidasMin;
    }

    public void setInsumoBebidasMin(List<Bebida> insumoBebidasMin) {
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
