/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.DAO;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.pdi.negocio.entidades.finales.Cliente;
import com.pdi.negocio.entidades.finales.Evento;
import com.pdi.util.General;
import java.awt.Component;
import java.util.ArrayList;
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
public abstract class ClientesDAO {

    public static void agregar(final Cliente c,
            final Component comp,
            final JLabel cargandoTxt,
            final DefaultListModel modeloLista,
            final JList clientesList) {
        cargandoTxt.setText("Guardando cliente...");
        Backendless.Persistence.save(c, new AsyncCallback<Cliente>() {

            public void handleResponse(Cliente clienteGuardado) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Cliente Guardado Correctamente", //Mensaje
                        "Cliente Guardado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                c.setObjectId(clienteGuardado.getObjectId());
                c.setUpdated(clienteGuardado.getUpdated());
                c.setCreated(clienteGuardado.getCreated());
                modeloLista.addElement(c);
                clientesList.setSelectedValue(c, true);
                System.out.println("Objeto guardado con ID: " + c.getObjectId());
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al guardar el cliente", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        }
        );

    }

    public static void agregar(final Cliente c,
            final Component comp,
            final JLabel cargandoTxt,
            final DefaultComboBoxModel modeloCombo,
            final JComboBox clientesCombo) {
        cargandoTxt.setText("Guardando cliente...");
        Backendless.Persistence.save(c, new AsyncCallback<Cliente>() {

            public void handleResponse(Cliente clienteGuardado) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Cliente Guardado Correctamente", //Mensaje
                        "Cliente Guardado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                c.setObjectId(clienteGuardado.getObjectId());
                c.setUpdated(clienteGuardado.getUpdated());
                c.setCreated(clienteGuardado.getCreated());
                modeloCombo.addElement(c);
                clientesCombo.setSelectedItem(c);
                System.out.println("Objeto guardado con ID: " + c.getObjectId());
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al guardar el cliente", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        }
        );

    }

    public static void editar(final Cliente c,
            final Component comp,
            final JLabel cargandoTxt,
            final JList clientesList) {
        cargandoTxt.setText("Editando cliente...");

        Backendless.Persistence.save(c, new AsyncCallback<Cliente>() {

            public void handleResponse(Cliente clienteGuardado) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Cliente Editado Correctamente", //Mensaje
                        "Cliente Guardado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                System.out.println("Objeto ID: " + c.getObjectId() + "editado");
                clientesList.setSelectedValue(c, true);
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al editar el cliente", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        }
        );

    }

    public static void eliminar(final Cliente c, final Component comp, final JLabel cargandoTxt,
            final DefaultListModel modeloLista) {
        cargandoTxt.setText("Eliminando cliente...");

        Backendless.Persistence.of(Cliente.class).remove(c, new AsyncCallback<Long>() {

            public void handleResponse(Long t) {
                cargandoTxt.setText("");
                System.out.println("Cliente con ID: " + c.getObjectId() + " eliminado");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Cliente Eliminado Correctamente", //Mensaje
                        "Cliente Eliminado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen
                modeloLista.removeElement(c);
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(comp, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al eliminar el Cliente", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }
        });
    }

    public static boolean validarForm(Component c,
            final JTextField nombreTxt,
            final JTextField apellidoTxt,
            final JTextField mailTxt,
            final JTextField descuentoTxt) {
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

        //Validar que si hay descuento, tenga formato decimal
        if (!descuentoTxt.getText().equals("")) {
            try {
                Float.parseFloat(descuentoTxt.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(c,
                        "El descuento debe ser un numero decimal",
                        "Corregir Comision", JOptionPane.WARNING_MESSAGE);
                descuentoTxt.requestFocus();
                return false;
            }
        }

        return true;

    }

}
