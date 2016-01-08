/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.controlador;

import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.callback.SaveCallback;
import com.pdi.UI.VentanaMaestra;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.pdi.util.General;
import java.util.Date;

/**
 *
 * @author Marcos Sastre
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Establece la vista de sistema como layout
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Inicializa Parse
        Parse.initialize("vlggVnYS02godcofnSC4limZG7XMOc5I4VMcSz0B", //App ID
                "uotLx4R6kPfs9PNLXnxDdzyAC7NiQmhaG4hL7BIL"); //REST API key

        //Abre la ventana maestra
        VentanaMaestra v = new VentanaMaestra();
        v.setSize(1024, 650);
        v.setVisible(true);
        
    }
    
}
