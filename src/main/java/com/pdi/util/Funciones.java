/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.util;

import com.pdi.UI.VentanaMaestra;
import com.pdi.negocio.entidades.finales.CantidadesBase;
import com.pdi.negocio.entidades.finales.PreciosBase;
import java.lang.reflect.Field;
import java.util.Date;
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
        
        return costoInsumos + ganancia + flete + recargoFecha;        
        
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            return 0;
            } catch (IllegalAccessException ex) {
             System.out.println(ex.toString());
                return 0;  
           }
        
    }
    
}
