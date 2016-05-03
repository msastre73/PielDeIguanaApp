/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.enums;

/**
 *
 * @author Marcos Sastre
 */
public enum TipoDeEvento {
    CUMPLE_15(1),
    CASAMIENTO(2),
    PROMOCION(3),
    CUMPLE(4), 
    EMPRESARIAL(5),
    OTRA(6);
    
    private final int cod;
    
    TipoDeEvento(int cod){
        this.cod = cod;
    }
    
    public static TipoDeEvento getFromInt(int i){
        
        switch(i){
            case 1: return TipoDeEvento.CUMPLE_15;
            case 2: return TipoDeEvento.CASAMIENTO;
            case 3: return TipoDeEvento.PROMOCION;
            case 4: return TipoDeEvento.CUMPLE; 
            case 5: return TipoDeEvento.EMPRESARIAL;
            case 6: return TipoDeEvento.OTRA;    
        }
        return null;
    }
    
    
    
    public int getCod(){
        return cod;
    }
    
}
