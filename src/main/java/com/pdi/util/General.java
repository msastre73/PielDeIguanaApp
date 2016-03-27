/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.util;

import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import java.awt.Font;
import java.text.SimpleDateFormat;


/**
 *
 * @author Marcos Sastre
 */



public class General {
    
     public static String COD_SIN_CLASE = "1009";
    
    public static SimpleDateFormat formatoFecha = 
            new SimpleDateFormat("dd/MM/yyyy");
    
    public final static String formatoMail = 
            "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    
    public static BackendlessDataQuery getQueryDepth2(){
        
        BackendlessDataQuery query = new BackendlessDataQuery();
        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setRelationsDepth(2);
        query.setQueryOptions(queryOptions);
        return query;
    }
   
    
}
