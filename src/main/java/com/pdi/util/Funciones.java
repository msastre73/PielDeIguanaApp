/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.util;

import com.pdi.UI.VentanaMaestra;
import com.pdi.negocio.entidades.finales.CantidadesBase;
import com.pdi.negocio.entidades.finales.PreciosBase;
import com.pdi.negocio.enums.TipoDeBebida;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public abstract class Funciones {
    
    public static float cotizar(String lugar, Date fecha, float cantidad,
            String tipo, float desc){
      
        try {
        //Establece la proporcion para calcular las bebidas
        float proporcion = cantidad/100;
        
        //Establece el factor a utilizar dependiendo si es una promocion o no
        float factor;
        if(tipo.equals("PROMOCION")){
          factor = VentanaMaestra.VARS_COTIZ.getFactorPromo();
        }else{
            factor = 1;
        }
        
        //Calcula el costo de los insumos
        
        float costoInsumos = 0;
        Field[] cantidadesBase = CantidadesBase.class.getDeclaredFields();
        Field[] preciosBase = PreciosBase.class.getDeclaredFields();
        
        for(int i = 3; i < cantidadesBase.length; i++){

                float rdo = cantidadesBase[i].getFloat(VentanaMaestra.CANT_BASE)
                        * preciosBase[i].getFloat(VentanaMaestra.PRECIOS_BASE)
                        * factor * proporcion;
                costoInsumos += rdo;

        }
        
         
        System.out.println("Costo de los Insumos:" + costoInsumos);
        
        //Calcula la ganancia (fijo + variable)
        float ganancia = VentanaMaestra.VARS_COTIZ.getGananciaFijo()
                + VentanaMaestra.VARS_COTIZ.getGananciaVariable() * costoInsumos;
        
        System.out.println("Ganancia: " + ganancia);
        
        //Calcula el costo del Flete
        float flete = 0;
        if(lugar.equals("Venado Tuerto")){
            flete = VentanaMaestra.VARS_COTIZ.getFleteLocal();
        }else{
            flete = VentanaMaestra.VARS_COTIZ.getFleteAfuera();
        }
        System.out.println("Flete: " + flete);
        
        //Calcula el recargo por fecha
        float recargoFecha = 0;
        float difMeses = General.diferenciaFechasEnMes(fecha, new Date());
        recargoFecha = (costoInsumos + ganancia + flete)
                * VentanaMaestra.VARS_COTIZ.getTasaRecargo() * difMeses;
        System.out.println("Recargo por Fecha: " + recargoFecha);
        
        float costoExacto = costoInsumos + ganancia + flete + recargoFecha; 
        float costoPersona = Math.round(costoExacto / cantidad);
        return costoPersona * cantidad;
        
        
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            return 0;
            } catch (IllegalAccessException ex) {
             System.out.println(ex.toString());
                return 0;  
           }
        
    }
    
    public static HashMap<String, Object> insumosNec(float cantidad, String tipo){
        HashMap<String, Object> insumosNec = new HashMap<String, Object>();
        insumosNec.put("___class", "InsumosNecesarios" );
        float proporcion = cantidad/100;
        
        //Establece el factor a utilizar dependiendo si es una promocion o no
        float factor;
        if(tipo.equals("PROMOCION")){
          factor = VentanaMaestra.VARS_COTIZ.getFactorPromo();
        }else{
            factor = 1;
        }
        
        Field[] cantidadesBase = CantidadesBase.class.getDeclaredFields();
        for(int i = 3; i < (cantidadesBase.length); i++){
            try {
                String insumo = "";
                float cantNec = cantidadesBase[i].getFloat(VentanaMaestra.CANT_BASE)
                        *factor * proporcion;
                if(i <= 24 ){
                TipoDeBebida tipobebida = TipoDeBebida.getFromInt(i - 2);
                insumo = tipobebida.toString().toLowerCase();
                    System.out.println("Iteracion: " + (i-2));
                }else{
                    switch(i){
                        case 25:
                            insumo = "vasos";
                            break;
                        case 26:
                            insumo = "revolvedores";
                            break;
                        case 27:
                            insumo = "sorbetes";
                            break;
                        case 28:
                            insumo = "hielo";
                            break;
                        case 29:
                            insumo = "bartenders";
                            break;
                    }
                }
                insumosNec.put(insumo, cantNec);
                
                
                
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            }
   
        }
        
        for(String key: insumosNec.keySet()){
            System.out.println(key + ": " + insumosNec.get(key));
            
        }
        return insumosNec;
        
         
    }
    
}
