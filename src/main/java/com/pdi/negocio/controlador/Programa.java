/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.controlador;


import com.backendless.Backendless;
import com.pdi.UI.VentanaMaestra;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


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
        
        //Inicializa Backendeless
        Backendless.initApp(
                "6A7ADC93-D77A-7657-FFB3-0C6CEAA4BC00", //application-id 
                "EA6346BD-5299-D2C3-FF57-F77ED11B3400", //secret-key
                "v1" //version
        );

        //Abre la ventana maestra
        VentanaMaestra v = new VentanaMaestra();
        v.setSize(1024, 650);
        v.setVisible(true);
        
    }
    
}
