/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.DAO;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.pdi.negocio.entidades.finales.Aliado;
import com.pdi.negocio.entidades.finales.Evento;
import com.pdi.util.General;
import java.awt.Component;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public abstract class AliadosDAO {
    
    public static void agregar(final Aliado a,
            final Component c,
            final JLabel cargandoTxt,
            final DefaultListModel modeloLista,
            final JList aliadosList) {
        cargandoTxt.setText("Guardando aliado...");
        Backendless.Persistence.save(a, new AsyncCallback<Aliado>() {

            public void handleResponse(Aliado aliadoGuardado) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(c, //Componente
                        "Aliado Guardado Correctamente", //Mensaje
                        "Aliado Guardado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                a.setObjectId(aliadoGuardado.getObjectId());
                a.setUpdated(aliadoGuardado.getUpdated());
                a.setCreated(aliadoGuardado.getCreated());
                modeloLista.addElement(a);
                aliadosList.setSelectedValue(a, true);
                System.out.println("Objeto guardado con ID: " + a.getObjectId());
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");

                JOptionPane.showMessageDialog(c, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al guardar el aliado", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen  

            }

        });
    }
    
     public static void agregar(final Aliado a,
            final Component c,
            final JLabel cargandoTxt,
            final DefaultComboBoxModel modeloCombo,
            final JComboBox aliadosCombo) {
        cargandoTxt.setText("Guardando aliado...");
        Backendless.Persistence.save(a, new AsyncCallback<Aliado>() {

            public void handleResponse(Aliado aliadoGuardado) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(c, //Componente
                        "Aliado Guardado Correctamente", //Mensaje
                        "Aliado Guardado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                a.setObjectId(aliadoGuardado.getObjectId());
                a.setUpdated(aliadoGuardado.getUpdated());
                a.setCreated(aliadoGuardado.getCreated());
                modeloCombo.addElement(a);
                aliadosCombo.setSelectedItem(a);
                System.out.println("Objeto guardado con ID: " + a.getObjectId());
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");

                JOptionPane.showMessageDialog(c, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al guardar el aliado", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen  

            }

        });
    }
    
    public static void editar(final Aliado a,
            final Component c,
            final JLabel cargandoTxt,
            final JList aliadosList) {
        cargandoTxt.setText("Editando aliado...");
        Backendless.Persistence.save(a, new AsyncCallback<Aliado>() {

            public void handleResponse(Aliado aliadoGuardado) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(c, //Componente
                        "Aliado Editado Correctamente", //Mensaje
                        "Aliado Guardado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                System.out.println("Objeto ID: " + a.getObjectId() + " editado");
                aliadosList.setSelectedValue(a, true);

            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(c, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al editar el aliado", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        });

    }
    
    public static void eliminar(final Aliado a,
            final Component c,
            final JLabel cargandoTxt,
            final DefaultListModel modeloLista) {
        cargandoTxt.setText("Eliminando aliado...");
        Backendless.Persistence.of(Aliado.class).remove(a, new AsyncCallback<Long>() {

            public void handleResponse(Long t) {
                cargandoTxt.setText("");
                System.out.println("Aliado con ID: " + a.getObjectId() + " eliminado");
                JOptionPane.showMessageDialog(c, //Componente
                        "Aliado Eliminado Correctamente", //Mensaje
                        "Aliado Eliminado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                modeloLista.removeElement(a);
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(c, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al eliminar el Aliado", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen  
            }
        });
    }
    
 
       public static boolean validarForm(Component c,
            JTextField nombreTxt,
            JTextField apellidoTxt,
            JTextField mailTxt,
            JTextField comisionTxt,
            JTextField comisionAcumuladaTxt) {
        //Validar que el nombre no este vacio
        if (nombreTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(c,
                    "El nombre no puede estar vacio",
                    "Completar Nombre", JOptionPane.WARNING_MESSAGE);
            nombreTxt.requestFocus();
            return false;
        }

        //Vaidar que el apellido no este vacio
        if (apellidoTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(c,
                    "El apellido no puede estar vacio",
                    "Completar Apellido", JOptionPane.WARNING_MESSAGE);
            apellidoTxt.requestFocus();
            return false;
        }

        //Validar que el mail no este vacio
        if (mailTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(c,
                    "El mail no puede estar vacio",
                    "Completar Mail", JOptionPane.WARNING_MESSAGE);
            mailTxt.requestFocus();
            return false;
        }

        //Validar el formato del mail
        if (!mailTxt.getText().matches(General.formatoMail)) {
            JOptionPane.showMessageDialog(c,
                    "Ingrese un mail valido",
                    "Mail incorrecto", JOptionPane.WARNING_MESSAGE);
            mailTxt.requestFocus();
            return false;
        }

        //Validar que si hay comision, tenga formato decimal
        if (!comisionTxt.getText().equals("")) {
            try {
                Float.parseFloat(comisionTxt.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(c,
                        "La comision debe ser un numero decimal",
                        "Corregir Comision ", JOptionPane.WARNING_MESSAGE);
                comisionTxt.requestFocus();
                return false;
            }
        }

        //Validar qe si hay comision acumulada, tenga formato decimal
        if (!comisionAcumuladaTxt.getText().equals("")) {
            try {
                Float.parseFloat(comisionAcumuladaTxt.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(c,
                        "La comision acumulada debe ser un numero decimal",
                        "Corregir Comision ", JOptionPane.WARNING_MESSAGE);
                comisionAcumuladaTxt.requestFocus();
                return false;
            }
        }

        return true;

    }

    
    
}
