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
public enum EstadoDeEvento {
    PENDIENTE(1),
    ACEPTADO(2),
    RECHAZADO(3),
    TODO_LISTO(4),
    CERRADO(5);
    
    private final int cod;
    
    EstadoDeEvento(int cod){
        this.cod = cod;
    }
    
     public static EstadoDeEvento getFromInt(int i){
        
        switch(i){
            case 1: return EstadoDeEvento.PENDIENTE;
            case 2: return EstadoDeEvento.ACEPTADO;
            case 3: return EstadoDeEvento.RECHAZADO;
            case 4: return EstadoDeEvento.TODO_LISTO; 
            case 5: return EstadoDeEvento.CERRADO;
        }
        return null;
    }   
    
    public int getCod(){
        return cod;
    }
}
