/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import java.awt.Component;
import javax.swing.JOptionPane;


/**
 *
 * @author Marcos Sastre
 */
public class Caja {

    //Atributos

    private float saldo;
    private float minimo;
    private boolean minOK;

    //Constructores
    public Caja() {
    }

    public Caja(float saldo, float minimo, boolean minOK) {
        this.saldo = saldo;
        this.minimo = minimo;
        this.minOK = minOK;
    }

    //Metodos
    public boolean imputarIngreso(float monto, Component c) {
        if (monto < 0) {
            JOptionPane.showMessageDialog(c, //Componente
                    "El ingreso a imputar debe ser positivo", //Mensaje
                    "Error al computar ingreso", //Titulo
                    JOptionPane.WARNING_MESSAGE); //Imagen
            return false;
        } else {
            
            if ((saldo + monto) >= minimo) {
            minOK = true;
            }
            
            saldo += monto;
            actualizarParse(c);
            return true;
        } 
            
            
        
    }

    public boolean imputarEgreso(float monto, Component c) {

        if (monto < 0) {
            JOptionPane.showMessageDialog(c, //Componente
                    "El egreso a imputar debe ser positivo.", //Mensaje
                    "Error al computar egreso", //Titulo
                    JOptionPane.WARNING_MESSAGE); //Imagen
            return false;
        }

        if (monto > saldo) {
            JOptionPane.showMessageDialog(c, //Componente
                    "No se puede imputar un egreso mayor que el saldo.", //Mensaje
                    "Error al computar egreso", //Titulo
                    JOptionPane.WARNING_MESSAGE); //Imagen
            return false;
        }

        if ((saldo - monto) < minimo) {
            minOK = false;
        } 
        saldo -= monto;

        actualizarParse(c);
        return true;

    }

    private void actualizarParse(final Component c) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Caja");
        query.getInBackground("YLhTsAUPpm", new GetCallback<ParseObject>() {

            @Override
            public void done(ParseObject cajaParse, ParseException parseException) {
                if (parseException == null) {
                    cajaParse.put("saldo", saldo);
                    cajaParse.put("minimo", minimo);
                    cajaParse.put("minOk", minOK);

                    cajaParse.saveInBackground(new SaveCallback() {

                        @Override
                        public void done(ParseException parseException) {
                            if (parseException != null) {
                                JOptionPane.showMessageDialog(c, //Componente
                                        "Error al actuaizar la caja", //Mensaje
                                        parseException.toString(), //Titulo
                                        JOptionPane.WARNING_MESSAGE); //Imagen
                            }
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(c, //Componente
                            "Error al actuaizar la caja", //Mensaje
                            parseException.toString(), //Titulo
                            JOptionPane.WARNING_MESSAGE); //Imagen
                }
            }
        });

    }

    //Getters y Setters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public boolean isMinOK() {
        return minOK;
    }

    public void setMinOK(boolean minOK) {
        this.minOK = minOK;
    }

}
