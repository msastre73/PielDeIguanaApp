/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.UI;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.pdi.DAO.AliadosDAO;
import com.pdi.negocio.entidades.finales.Aliado;
import com.pdi.negocio.entidades.finales.Evento;
import com.pdi.util.General;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Sastre
 */
public class AliadosVentana extends javax.swing.JInternalFrame {

    /**
     * Creates new form EventoVentana
     */
    //Atrib para manejar si hay una ventana abierta de este tipo
    public static boolean abierta = false;

    DefaultListModel modeloLista = new DefaultListModel();
    DefaultListModel modeloListaEventos = new DefaultListModel();

    public AliadosVentana() {
        initComponents();
        //Relaciona el modelo con la lista
        aliadosList.setModel(modeloLista);
        eventosList.setModel(modeloListaEventos);

        cargarAliados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        aliadosList = new javax.swing.JList();
        nuevoBtn = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        guardarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        apellidoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mailTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comisionTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventosList = new javax.swing.JList();
        comisionAcumuladaTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cargandoTxt = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Aliados");
        setPreferredSize(new java.awt.Dimension(857, 588));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Aliados"));

        aliadosList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        aliadosList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aliadosListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(aliadosList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        editarBtn.setText("Editar");
        editarBtn.setEnabled(false);
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("Eliminar");
        eliminarBtn.setEnabled(false);
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del Aliado"));

        guardarBtn.setText("Guardar");
        guardarBtn.setEnabled(false);
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.setEnabled(false);
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        nombreTxt.setEnabled(false);
        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Apellido");

        apellidoTxt.setEnabled(false);

        jLabel4.setText("Mail:");

        mailTxt.setEnabled(false);

        jLabel7.setText("Comision (%):");

        comisionTxt.setEnabled(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Eventos"));

        eventosList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        eventosList.setEnabled(false);
        jScrollPane1.setViewportView(eventosList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        comisionAcumuladaTxt.setEnabled(false);

        jLabel8.setText("Comision Acumulada ($)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(guardarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comisionAcumuladaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comisionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apellidoTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mailTxt)))
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(apellidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comisionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comisionAcumuladaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cargandoTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(cargandoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(editarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarBtn)
                        .addGap(74, 74, 74)
                        .addComponent(cargandoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        limpiarForm();
        aliadosList.clearSelection();
        habilitarDetalles();
        nombreTxt.requestFocus();
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        boolean validacionOK = AliadosDAO.validarForm(this, nombreTxt, apellidoTxt,
                mailTxt, comisionTxt, comisionAcumuladaTxt);
        boolean esNuevo = true;

        if (validacionOK) {

            Aliado a = new Aliado();
            //Si hay algun aliado seleccionado lo utiliza para actualizarlo
            if (aliadosList.getSelectedIndex() != -1) {
                a = (Aliado) aliadosList.getSelectedValue();
                esNuevo = false;
            }
            a.setNombre(nombreTxt.getText());
            a.setApellido(apellidoTxt.getText());
            a.setMail(mailTxt.getText());

            if (!comisionTxt.getText().equals("")) {
                a.setComisionPorcentaje(Float.parseFloat(comisionTxt.getText()));
            }

            if (!comisionAcumuladaTxt.getText().equals("")) {
                a.setComisionMonto(Float.parseFloat(comisionAcumuladaTxt.getText()));
            }

            if (esNuevo) {
                AliadosDAO.agregar(a, this, cargandoTxt, modeloLista, aliadosList);
            } else {
                AliadosDAO.editar(a, this, cargandoTxt, aliadosList);
            }

            deshabilitarDetalles();

        }


    }//GEN-LAST:event_guardarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        limpiarForm();
        aliadosList.clearSelection();
        deshabilitarDetalles();
        //Dehabilita los otros botones
        editarBtn.setEnabled(false);
        eliminarBtn.setEnabled(false);
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        habilitarDetalles();
    }//GEN-LAST:event_editarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        Aliado a = (Aliado) aliadosList.getSelectedValue();

        //Mensaje de Confirmacion
        int rta = JOptionPane.showConfirmDialog(this,
                "Confirma que quiere eliminar este aliado?:\n" + a.toString(),
                "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

        if (rta == JOptionPane.NO_OPTION) {
            return;
        } else {
            AliadosDAO.eliminar(a, this, cargandoTxt, modeloLista );
            limpiarForm();
            aliadosList.clearSelection();
            editarBtn.setEnabled(false);
            eliminarBtn.setEnabled(false);

        }


    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void aliadosListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aliadosListMouseClicked
        limpiarForm();
        
        //Activa los botones correspondientes
        editarBtn.setEnabled(true);
        eliminarBtn.setEnabled(true);

        //Obtiene el item seleccionado y completa los campos
        Aliado a = (Aliado) aliadosList.getSelectedValue();

        nombreTxt.setText(a.getNombre());
        apellidoTxt.setText(a.getApellido());
        mailTxt.setText(a.getMail());

        if (a.getComisionPorcentaje() != 0) {
            comisionTxt.setText(Float.toString(a.getComisionPorcentaje()));
        }

        if (a.getComisionMonto() != 0) {
            comisionAcumuladaTxt.setText(Float.toString(a.getComisionMonto()));
        }
        
        String whereClause = "aliado.objectId='"
                + a.getObjectId() + "'";
        
        BackendlessDataQuery query = General.getQueryDepth2();
        query.setWhereClause(whereClause);
        List<Evento> eventosDelAliado = Backendless.Persistence.of(
                Evento.class).find(query).getData();
        
        
        if(eventosDelAliado != null){
             for(int i = 0; i < eventosDelAliado.size(); i++){
                Evento e = (Evento) eventosDelAliado.get(i);
                modeloListaEventos.addElement(e);
            }
        }
        
        /*if (a.getEventos() != null){
            ArrayList eventosDelAliado = a.getEventos();
            for(int i = 0; i < eventosDelAliado.size(); i++){
                Evento e = (Evento) eventosDelAliado.get(i);
                modeloListaEventos.addElement(e);
            }
        }*/

        
    }//GEN-LAST:event_aliadosListMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        abierta = false;
    }//GEN-LAST:event_formInternalFrameClosed

    

    

    
    private void cargarAliados() {
        cargandoTxt.setText("Cargando aliados...");
        
        
        //Se establece la query con depth 2 para que traiga los eventos y sus clientes
        BackendlessDataQuery query = General.getQueryDepth2();
        
        Backendless.Persistence.of(Aliado.class).find(query, new AsyncCallback<BackendlessCollection<Aliado>>() {

            public void handleResponse(BackendlessCollection<Aliado> aliadosBackendless) {
                cargandoTxt.setText("");
                if (aliadosBackendless != null) {
                    ArrayList<Aliado> aliadosList = (ArrayList) aliadosBackendless.getData();
                    for (int i = 0; i < aliadosList.size(); i++) {
                        Aliado e = aliadosList.get(i);
                        modeloLista.addElement(e);
                    }
                }
            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");

                //Si aun no se cargaron objetos de esta clase, arroja un error
                //conocido por esto. En caso de que se trate de este error el que
                //ocasiono la BackendlessFault esta todo en orden, por lo tanto se
                //saltea.
                if (!bf.getCode().equals(General.COD_SIN_CLASE)) {
                    JOptionPane.showMessageDialog(AliadosVentana.this, //Componente
                            bf.getMessage() + " codigo: " + bf.getCode(), //Mensaje
                            "Error al cargar los aliados", //Titulo
                            JOptionPane.WARNING_MESSAGE); //Imagen

                }
            }
        });
    }

 

    private void habilitarDetalles() {
        nombreTxt.setEnabled(true);
        apellidoTxt.setEnabled(true);
        mailTxt.setEnabled(true);
        comisionTxt.setEnabled(true);
        comisionAcumuladaTxt.setEnabled(true);
        eventosList.setEnabled(true);
        guardarBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);

    }

    private void deshabilitarDetalles() {
        nombreTxt.setEnabled(false);
        apellidoTxt.setEnabled(false);
        mailTxt.setEnabled(false);
        comisionTxt.setEnabled(false);
        comisionAcumuladaTxt.setEnabled(false);
        eventosList.setEnabled(false);
        guardarBtn.setEnabled(false);
        cancelarBtn.setEnabled(false);

    }

    private void limpiarForm() {
        nombreTxt.setText("");
        apellidoTxt.setText("");
        mailTxt.setText("");
        comisionTxt.setText("");
        comisionAcumuladaTxt.setText("");
        modeloListaEventos.removeAllElements();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList aliadosList;
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel cargandoTxt;
    private javax.swing.JTextField comisionAcumuladaTxt;
    private javax.swing.JTextField comisionTxt;
    private javax.swing.JButton editarBtn;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JList eventosList;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mailTxt;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JButton nuevoBtn;
    // End of variables declaration//GEN-END:variables

}
