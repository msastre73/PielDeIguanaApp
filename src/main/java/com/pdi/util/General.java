/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.util;

import java.awt.Font;
import java.text.SimpleDateFormat;


/**
 *
 * @author Marcos Sastre
 */



public class General {
    
    
    public static SimpleDateFormat formatoFecha = 
            new SimpleDateFormat("dd/MM/yyyy");
    
    public final static String formatoMail = 
            "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
   
    
}
