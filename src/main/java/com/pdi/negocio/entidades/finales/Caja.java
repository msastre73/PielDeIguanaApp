/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.pdi.util.General;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Sastre
 */
public class Caja {

    //Atributos
    private String objectId;
    private Date created;
    private Date updated;
    private float saldo;
    private float minimo;
    private boolean minOK;

    //Constructores
    public Caja() {
    }

    public Caja(String objectId, Date created, Date updated, float saldo, float minimo, boolean minOK) {
        this.objectId = objectId;
        this.created = created;
        this.updated = updated;
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
            actualizarBackendless(c);
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

        actualizarBackendless(c);
        return true;

    }

    private void actualizarBackendless(final Component c) {
        Backendless.Persistence.of(Caja.class).findById(General.ID_CAJA,
                new AsyncCallback<Caja>() {

                    public void handleResponse(Caja cajaBackendless) {
                        cajaBackendless.setSaldo(saldo);
                        cajaBackendless.setMinimo(minimo);
                        cajaBackendless.setMinOK(minOK);

                        Backendless.Persistence.save(cajaBackendless, new AsyncCallback<Caja>() {

                            public void handleResponse(Caja t) {
                                System.out.println("Caja guardada correctamente");
                            }

                            public void handleFault(BackendlessFault bf) {
                                JOptionPane.showMessageDialog(c, //Componente
                                        bf.getMessage(), //Mensaje
                                        "Error al actuaizar la caja", //Titulo
                                        JOptionPane.WARNING_MESSAGE); //Imagen 
                            }

                        });

                    }

                    public void handleFault(BackendlessFault bf) {
                        JOptionPane.showMessageDialog(c, //Componente
                                bf.getMessage(), //Mensaje
                                "Error al actuaizar la caja", //Titulo
                                JOptionPane.WARNING_MESSAGE); //Imagen 

                    }
                });

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
