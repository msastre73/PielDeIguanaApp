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
import com.pdi.negocio.entidades.finales.Bebida;
import com.pdi.negocio.entidades.finales.Varios;
import com.pdi.util.General;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Sastre
 */
public class InventarioVentana extends javax.swing.JInternalFrame {

    /**
     * Creates new form EventoVentana
     */
    //Atrib para manejar si hay una ventana abierta de este tipo
    public static boolean abierta = false;

   //Atributo que reune los faltantes en caso de que hubiera
    private String faltantes = "";
    
//Titulos para las columnas de las tablas 
    private final String[] colNameVarios = new String[]{
        "Concepto", "Existencia", "Valor", "Minimo"};

    private final String[] colNameBebidas = new String[]{
        "Bebida", "Marca", "ContUnit", "Existencia", "Valor", "Minimo"};

    //Valores de la tabla Varios que no deben cambiar (se agregar dinamicamente)
    private ArrayList<Varios> conceptosVarios = new ArrayList<Varios>();

    //Valores de la tabla Bebidas que no deben cambiar (se agregar dinamicamente)
    private ArrayList<Bebida> bebidasBebidas = new ArrayList<Bebida>();
    private ArrayList<String> marcasBebidas = new ArrayList<String>();

    //Modelos para controlar la info de las tablas
    private DefaultTableModel modeloTablaVarios = new DefaultTableModel(null, colNameVarios);
    private DefaultTableModel modeloTablaBebidas = new DefaultTableModel(null, colNameBebidas);

    public InventarioVentana() {
        //Pone en verdadero el atrib que controla si la ventana esta abierta
        this.abierta = true;
        
        initComponents();

        //Relaciona el modelo con la tabla
        variosTbl.setModel(modeloTablaVarios);
        bebidasTbl.setModel(modeloTablaBebidas);

        cargarVariosYBebidas();

        //Listener para que este pendiente de los cambios en las tablas
        modeloTablaVarios.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {

                //Chequea que se haya modificado una celda y no agregado una columna
                if (e.getColumn() != -1) {

                    //Si la celda es la primera de la columna no permite editarla
                    //Sino guarda los cambios
                    if (e.getColumn() == 0) {
                        int i = e.getFirstRow();
                        //Se saca el Listener y desp se pone
                        //porque sino al setear el concepto se entra
                        //en un loop infinito (ya que el mismo listener dispara el 
                        //evento que escucha)
                        modeloTablaVarios.removeTableModelListener(this);
                        modeloTablaVarios.setValueAt(conceptosVarios.get(i), i, 0);
                        modeloTablaVarios.addTableModelListener(this);

                    } else {
                        int fila = e.getFirstRow();
                        int columna = e.getColumn();
                        Varios varios = (Varios) modeloTablaVarios.getValueAt(fila, 0);
                        String valorCambiadoStr = (String) modeloTablaVarios.getValueAt(fila, columna);
                        float valorCambiado = Float.parseFloat(valorCambiadoStr);

                        //Modifica el atributo dependiendo de la columna modificada
                        switch (columna) {
                            case 1:
                                varios.setExistencia(valorCambiado);
                                break;
                            case 2:
                                varios.setValor(valorCambiado);
                                break;
                            case 3:
                                varios.setMinimo(valorCambiado);
                                break;
                        }

                        editarVarios(varios, fila, columna, valorCambiado);

                    }

                }

            }
        });

        modeloTablaBebidas.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {

                //Chequea que se haya modificado una celda y no agregado una columna
                if (e.getColumn() != -1) {
                    //Si la celda es la primera o segunda de la columna no permite editarla
                    //Sino guarda los cambios

                    if (e.getColumn() == 0 || e.getColumn() == 1) {
                        int i = e.getFirstRow();
                        //Se saca el Listener y desp se pone
                        //porque sino al setear el valor se entra
                        //en un loop infinito (ya que el mismo listener dispara el 
                        //evento que escucha)
                        modeloTablaBebidas.removeTableModelListener(this);
                        modeloTablaBebidas.setValueAt(bebidasBebidas.get(i), i, 0);
                        modeloTablaBebidas.setValueAt(marcasBebidas.get(i), i, 1);
                        modeloTablaBebidas.addTableModelListener(this);

                    } else {

                        int fila = e.getFirstRow();
                        int columna = e.getColumn();
                        Bebida bebida = (Bebida) modeloTablaBebidas.getValueAt(fila, 0);
                        String valorCambiadoStr = (String) modeloTablaBebidas.getValueAt(fila, columna);
                        float valorCambiado = Float.parseFloat(valorCambiadoStr);

                        //Modifica el atributo dependiendo de la columna modificada
                        switch (columna) {
                            case 2:
                                bebida.setContenido(valorCambiado);
                                break;
                            case 3:
                                bebida.setExistencia(valorCambiado);
                                break;
                            case 4:
                                bebida.setValor(valorCambiado);
                                break;
                            case 5:
                                bebida.setMinimo(valorCambiado);
                                break;
                        }

                        editarBebida(bebida, fila, columna, valorCambiado);
                    }

                }

            }
        });
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
        jScrollPane3 = new javax.swing.JScrollPane();
        variosTbl = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        conceptoTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        existVariosTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        valorVariosTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        minimoVariosTxt = new javax.swing.JTextField();
        eliminarVarios = new javax.swing.JButton();
        agregarVarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        estadoLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bebidasTbl = new javax.swing.JTable();
        minimoBebidasTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        valorBebidasTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        eliminarBebida = new javax.swing.JButton();
        contUnitTxt = new javax.swing.JTextField();
        marcaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        existBebidasTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        agregarBebida = new javax.swing.JButton();
        bebidaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valorInventarioLbl = new javax.swing.JLabel();
        cargandoTxt = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Inventario");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Varios"));

        variosTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Vasos", null, null, null},
                {"Sorbetes", null, null, null}
            },
            new String [] {
                "Concepto", "Existencia", "Valor", "Minimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(variosTbl);

        jLabel11.setText("Concepto:");

        jLabel12.setText("Exist:");

        jLabel13.setText("Valor:");

        jLabel14.setText("Minimo:");

        eliminarVarios.setText("Eliminar Varios");
        eliminarVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarVariosActionPerformed(evt);
            }
        });

        agregarVarios.setText("Agregar Varios");
        agregarVarios.setActionCommand("Agregar Varios");
        agregarVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarVariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarVarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(conceptoTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(existVariosTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorVariosTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimoVariosTxt))
                    .addComponent(eliminarVarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(conceptoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(existVariosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(valorVariosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(minimoVariosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(agregarVarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarVarios))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("ESTADO:");

        estadoLbl.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        estadoLbl.setText("OK");
        estadoLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estadoLblMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bebidas"));

        bebidasTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, null},
                {null, "", null, null, null, null}
            },
            new String [] {
                "Bebida", "Marca", "Cont Unit", "Existencia", "Valor", "Minimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(bebidasTbl);

        jLabel9.setText("Valor:");

        jLabel10.setText("Minimo:");

        eliminarBebida.setText("Eliminar Bebida");
        eliminarBebida.setActionCommand("Eliminar Bebida");
        eliminarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBebidaActionPerformed(evt);
            }
        });

        jLabel5.setText("Cont Unit:");

        jLabel8.setText("Exist:");

        jLabel4.setText("Marca:");

        agregarBebida.setText("Agregar Bebida");
        agregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBebidaActionPerformed(evt);
            }
        });

        jLabel3.setText("Bebida:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bebidaTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marcaTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contUnitTxt))
                    .addComponent(agregarBebida, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(existBebidasTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorBebidasTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimoBebidasTxt))
                    .addComponent(eliminarBebida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bebidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(contUnitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(existBebidasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(valorBebidasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(minimoBebidasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agregarBebida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarBebida))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel6.setText("Valor: ");

        valorInventarioLbl.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        valorInventarioLbl.setText("$0");

        cargandoTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valorInventarioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(cargandoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(estadoLbl))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(valorInventarioLbl))
                    .addComponent(cargandoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBebidaActionPerformed

        boolean validacionOK = validarFormBebidas();

        if (validacionOK) {
            cargandoTxt.setText("Guardando bebida...");
            final String bebida = bebidaTxt.getText();
            final String marca = marcaTxt.getText();
            final float contUnit = Float.parseFloat(contUnitTxt.getText());
            final float existencia = Float.parseFloat(existBebidasTxt.getText());
            final float valor = Float.parseFloat(valorBebidasTxt.getText());
            final float minimo = Float.parseFloat(minimoBebidasTxt.getText());

            final Bebida bebidaObj = new Bebida(bebida, marca, contUnit, existencia, valor, minimo);

            Backendless.Persistence.save(bebidaObj, new AsyncCallback<Bebida>() {

                public void handleResponse(Bebida bebidaBackendless) {
                    bebidaObj.setObjectId(bebidaBackendless.getObjectId());
                    bebidaObj.setCreated(bebidaBackendless.getCreated());
                    bebidaObj.setUpdated(bebidaBackendless.getUpdated());
                    Object[] fila = {bebidaObj, marca, contUnit, existencia, valor, minimo};
                    modeloTablaBebidas.addRow(fila);

                    //Se agrega el obj y la marca a los Array para evitar que se modifiquen
                    bebidasBebidas.add(bebidaObj);
                    marcasBebidas.add(marca);
                    
                    calcularValorInventario();
                    chequearFaltantes();

                    limpiarFormBebidas();
                    cargandoTxt.setText("");
                    JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            "Bebida agregada correctamente.", //Mensaje
                            "Bebida Agregadaa", //Titulo
                            JOptionPane.INFORMATION_MESSAGE);
                }

                public void handleFault(BackendlessFault bf) {
                    cargandoTxt.setText("");
                    JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            "Error: " + bf.getMessage(), //Mensaje
                            "Error al guardar Bebida", //Titulo
                            JOptionPane.WARNING_MESSAGE); //Imagen
                }

            });

        }


    }//GEN-LAST:event_agregarBebidaActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        abierta = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void eliminarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBebidaActionPerformed

        int fila = bebidasTbl.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                    "Seleccione la bebida que desea eliminar", //Mensaje
                    "No hay bebida seleccionada", //Titulo
                    JOptionPane.WARNING_MESSAGE); //Imagen
        } else {
            Bebida bebidaEliminar = (Bebida) modeloTablaBebidas.getValueAt(fila, 0);

            int rta = JOptionPane.showConfirmDialog(this,
                    "Confirma que quiere eliminar esta bebida?:\n"
                    + bebidaEliminar + " " + bebidaEliminar.getMarca(),
                    "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

            if (rta == JOptionPane.NO_OPTION) {
                return;
            } else {
                eliminar(bebidaEliminar, fila);

            }

        }


    }//GEN-LAST:event_eliminarBebidaActionPerformed

    private void eliminarVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarVariosActionPerformed
        int fila = variosTbl.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                    "Seleccione el insumo de la tabla Varios que desea eliminar", //Mensaje
                    "No hay Insumo seleccionado", //Titulo
                    JOptionPane.WARNING_MESSAGE); //Imagen
        } else {
            Varios variosEliminar = (Varios) modeloTablaVarios.getValueAt(fila, 0);

            int rta = JOptionPane.showConfirmDialog(this,
                    "Confirma que quiere eliminar este insumo?:\n"
                    + variosEliminar,
                    "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

            if (rta == JOptionPane.NO_OPTION) {
                return;
            } else {
                eliminar(variosEliminar, fila);

            }

        }
    }//GEN-LAST:event_eliminarVariosActionPerformed

    private void agregarVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarVariosActionPerformed
        boolean validacionOK = validarFormVarios();

        if (validacionOK) {
            cargandoTxt.setText("Guardando varios...");
            final String concepto = conceptoTxt.getText();
            final float existencia = Float.parseFloat(existVariosTxt.getText());
            final float valor = Float.parseFloat(valorVariosTxt.getText());
            final float minimo = Float.parseFloat(minimoVariosTxt.getText());

            final Varios variosObj = new Varios(concepto, existencia, valor, minimo);

            Backendless.Persistence.save(variosObj, new AsyncCallback<Varios>() {

                public void handleResponse(Varios variosBackendless) {
                    variosObj.setObjectId(variosBackendless.getObjectId());
                    variosObj.setCreated(variosBackendless.getCreated());
                    variosObj.setUpdated(variosBackendless.getUpdated());
                    Object[] fila = {variosObj, existencia, valor, minimo};
                    modeloTablaVarios.addRow(fila);

                    //Se agrega el obj y la marca a los Array para evitar que se modifiquen
                    conceptosVarios.add(variosObj);
                    
                    calcularValorInventario();
                    chequearFaltantes();

                    limpiarFormVarios();
                    cargandoTxt.setText("");
                    JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            "Varios agregado correctamente.", //Mensaje
                            "Varios Agregado", //Titulo
                            JOptionPane.INFORMATION_MESSAGE);
                }

                public void handleFault(BackendlessFault bf) {
                    cargandoTxt.setText("");
                    JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            "Error: " + bf.getMessage(), //Mensaje
                            "Error al guardar Varios", //Titulo
                            JOptionPane.WARNING_MESSAGE); //Imagen
                }

            });
        }
    }//GEN-LAST:event_agregarVariosActionPerformed

    private void estadoLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoLblMouseClicked
        if(!estadoLbl.getText().equals("OK")){
            JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            faltantes, //Mensaje
                            "Detalle de Faltantes", //Titulo
                            JOptionPane.WARNING_MESSAGE); //Imagen
        }
    }//GEN-LAST:event_estadoLblMouseClicked

    private void editarBebida(Bebida bebidaObj, final int fila,
            final int columna, final float valorCambiado) {

        Backendless.Persistence.save(bebidaObj, new AsyncCallback<Bebida>() {

            public void handleResponse(Bebida bebidaBackendless) {

                //Instancia de Listener que detecta el cambio y previene que se modifiquen
                //La primer y segunda columnas
                TableModelListener[] tmlArray = modeloTablaBebidas.getTableModelListeners();
                TableModelListener tml = tmlArray[0];

                //Se saca el listener y se vuelve a poner para poder modif la primer columna
                //y el valor cambiado (para que no quede String en la tabla)
                modeloTablaBebidas.removeTableModelListener(tml);
                modeloTablaBebidas.setValueAt(bebidaBackendless, fila, 0);
                modeloTablaBebidas.setValueAt(valorCambiado, fila, columna);
                modeloTablaBebidas.addTableModelListener(tml);

                //Se modifica el objeto Bebida en el Arrey para que tenga los datos actualizados
                bebidasBebidas.set(fila, bebidaBackendless);
                
                calcularValorInventario();
                chequearFaltantes();
                System.out.println("Se edito correctamente la celda");

            }

            public void handleFault(BackendlessFault bf) {

                JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al editar celda", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        });

    }

    private void editarVarios(Varios variosObj, final int fila,
            final int columna, final float valorCambiado) {

        Backendless.Persistence.save(variosObj, new AsyncCallback<Varios>() {

            public void handleResponse(Varios variosBackendless) {

                //Instancia de Listener que detecta el cambio y previene que se modifique
                //La primer columna
                TableModelListener[] tmlArray = modeloTablaVarios.getTableModelListeners();
                TableModelListener tml = tmlArray[0];

                //Se saca el listener y se vuelve a poner para poder modif la primer columna
                //y el valor cambiado (para que no quede String en la tabla)
                modeloTablaVarios.removeTableModelListener(tml);
                modeloTablaVarios.setValueAt(variosBackendless, fila, 0);
                modeloTablaVarios.setValueAt(valorCambiado, fila, columna);
                modeloTablaVarios.addTableModelListener(tml);

                //Se modifica el objeto Varios en el Arrey para que tenga los datos actualizados
                conceptosVarios.set(fila, variosBackendless);
                
                calcularValorInventario();
                chequearFaltantes();
                
                System.out.println("Se edito correctamente la celda");

            }

            public void handleFault(BackendlessFault bf) {

                JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al editar celda", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        });

    }

    private <T> void eliminar(final T object, final int fila) {
        cargandoTxt.setText("Eliminando insumo...");

        Backendless.Persistence.of(Object.class).remove(object, new AsyncCallback<Long>() {

            public void handleResponse(Long t) {
                cargandoTxt.setText("");

                //Elimina la fila de la tabla y los elementos de los Arrays dependiendo
                //la clase del objeto pasado para eliminar
                if (object instanceof Varios) {
                    modeloTablaVarios.removeRow(fila);
                    Varios v = (Varios) object;
                    conceptosVarios.remove(fila);
                } else {
                    modeloTablaBebidas.removeRow(fila);
                    Bebida b = (Bebida) object;
                    marcasBebidas.remove(fila);
                    bebidasBebidas.remove(fila);
                }
                
                calcularValorInventario();
                chequearFaltantes();
                
                JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                        "Insumo Eliminado Correctamente", //Mensaje
                        "Insumo Eliminado", //Titulo
                        JOptionPane.INFORMATION_MESSAGE); //Imagen

            }

            public void handleFault(BackendlessFault bf) {
                cargandoTxt.setText("");
                JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                        "Error: " + bf.getMessage(), //Mensaje
                        "Error al eliminar el Insumo", //Titulo
                        JOptionPane.WARNING_MESSAGE); //Imagen
            }

        });

    }

    private boolean validarFormBebidas() {
        //Validar que la bebida no este vacia
        if (bebidaTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "La bebida no puede estar vacia",
                    "Completar Bebida", JOptionPane.WARNING_MESSAGE);
            bebidaTxt.requestFocus();
            return false;
        }

        //Validar que la marca no este vacia
        if (marcaTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "La marca no puede estar vacia",
                    "Completar Marca", JOptionPane.WARNING_MESSAGE);
            marcaTxt.requestFocus();
            return false;
        }

        //Validar que el cont uni no este vacio
        if (contUnitTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Contenido Unitario no puede estar vacio",
                    "Completar Contenido Unitario", JOptionPane.WARNING_MESSAGE);
            contUnitTxt.requestFocus();
            return false;
        }

        //Validar que el cont unit sea un numero decimal
        try {
            Float.parseFloat(contUnitTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Contenido Unitario debe ser un numero decimal",
                    "Corregir Contenido Unitario", JOptionPane.WARNING_MESSAGE);
            contUnitTxt.requestFocus();
            return false;
        }

        //Validar que las existencia no este vacia
        if (existBebidasTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "La Existencia no puede estar vacia",
                    "Completar Existencia", JOptionPane.WARNING_MESSAGE);
            existBebidasTxt.requestFocus();
            return false;
        }

        //Validar que la exist sea un numero decimal
        try {
            Float.parseFloat(existBebidasTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La Existencia debe ser un numero decimal",
                    "Corregir Existencia", JOptionPane.WARNING_MESSAGE);
            existBebidasTxt.requestFocus();
            return false;
        }

        //Validar que el valor no este vacio
        if (valorBebidasTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Valor no puede estar vacio",
                    "Completar Valor", JOptionPane.WARNING_MESSAGE);
            valorBebidasTxt.requestFocus();
            return false;
        }

        //Validar que el valor sea un numero decimal
        try {
            Float.parseFloat(valorBebidasTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Valor debe ser un numero decimal",
                    "Corregir Valor", JOptionPane.WARNING_MESSAGE);
            valorBebidasTxt.requestFocus();
            return false;
        }

        //Validar que el minimo no este vacio
        if (minimoBebidasTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Minimo no puede estar vacio",
                    "Completar Minimo", JOptionPane.WARNING_MESSAGE);
            minimoBebidasTxt.requestFocus();
            return false;
        }

        //Validar que el minimo sea un numero decimal
        try {
            Float.parseFloat(minimoBebidasTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Minimo debe ser un numero decimal",
                    "Corregir Minimo", JOptionPane.WARNING_MESSAGE);
            minimoBebidasTxt.requestFocus();
            return false;
        }

        return true;
    }

    private boolean validarFormVarios() {
        //Validar que el concepto no este vacio
        if (conceptoTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El concepto no puede estar vacio",
                    "Completar Concepto", JOptionPane.WARNING_MESSAGE);
            bebidaTxt.requestFocus();
            return false;
        }

        //Validar que las existencia no este vacia
        if (existVariosTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "La Existencia no puede estar vacia",
                    "Completar Existencia", JOptionPane.WARNING_MESSAGE);
            existVariosTxt.requestFocus();
            return false;
        }

        //Validar que la exist sea un numero decimal
        try {
            Float.parseFloat(existVariosTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La Existencia debe ser un numero decimal",
                    "Corregir Existencia", JOptionPane.WARNING_MESSAGE);
            existVariosTxt.requestFocus();
            return false;
        }

        //Validar que el valor no este vacio
        if (valorVariosTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Valor no puede estar vacio",
                    "Completar Valor", JOptionPane.WARNING_MESSAGE);
            valorVariosTxt.requestFocus();
            return false;
        }

        //Validar que el valor sea un numero decimal
        try {
            Float.parseFloat(valorVariosTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Valor debe ser un numero decimal",
                    "Corregir Valor", JOptionPane.WARNING_MESSAGE);
            valorVariosTxt.requestFocus();
            return false;
        }

        //Validar que el minimo no este vacio
        if (minimoVariosTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Minimo no puede estar vacio",
                    "Completar Minimo", JOptionPane.WARNING_MESSAGE);
            minimoVariosTxt.requestFocus();
            return false;
        }

        //Validar que el minimo sea un numero decimal
        try {
            Float.parseFloat(minimoVariosTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Minimo debe ser un numero decimal",
                    "Corregir Minimo", JOptionPane.WARNING_MESSAGE);
            minimoVariosTxt.requestFocus();
            return false;
        }

        return true;

    }

    private void limpiarFormBebidas() {
        bebidaTxt.setText("");
        marcaTxt.setText("");
        contUnitTxt.setText("");
        existBebidasTxt.setText("");
        valorBebidasTxt.setText("");
        minimoBebidasTxt.setText("");
        bebidasTbl.clearSelection();

    }

    private void limpiarFormVarios() {
        conceptoTxt.setText("");
        valorVariosTxt.setText("");
        existVariosTxt.setText("");
        minimoVariosTxt.setText("");
        variosTbl.clearSelection();
    }

    private void cargarVariosYBebidas() {
        cargandoTxt.setText("Cargando tablas Varios...");

        Backendless.Persistence.of(Varios.class).find(
                new AsyncCallback<BackendlessCollection<Varios>>() {

                    public void handleResponse(BackendlessCollection<Varios> variosBackendless) {
                        cargandoTxt.setText("");
                        if (variosBackendless != null) {
                            List<Varios> variosList = variosBackendless.getData();
                            for (int i = 0; i < variosList.size(); i++) {
                                Varios v = variosList.get(i);

                                float existencia = v.getExistencia();
                                float valor = v.getValor();
                                float minimo = v.getMinimo();

                                Object[] fila = new Object[]{v, existencia, valor, minimo};

                                modeloTablaVarios.addRow(fila);

                                //Se agrega el objeto al ArrayList que evita que se modifique
                                //la primer columna
                                conceptosVarios.add(v);

                            }
                            
                            calcularValorInventario();
                            chequearFaltantes();
                            //Se prosigue a cargar las bebidas
                            cargarBebidas();
                        }

                    }

                    public void handleFault(BackendlessFault bf) {
                        cargandoTxt.setText("");
                        //Si aun no se cargaron objetos de esta clase, arroja un error
                        //conocido por esto. En caso de que se trate de este error el que
                        //ocasiono la BackendlessFault esta todo en orden, por lo tanto se
                        //saltea.
                        if (!bf.getCode().equals(General.COD_SIN_CLASE)) {
                            JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                    bf.getMessage(), //Mensaje
                                    "Error al cargar la tabla Varios", //Titulo
                                    JOptionPane.WARNING_MESSAGE); //Imagen
                        } else {
                            //Como el error que no hay Varios, se prosigue a cargar las bebidas
                            //Se prosigue a cargar las bebidas
                            cargarBebidas();
                        }
                    }
                });

    }

    private void cargarBebidas() {
        cargandoTxt.setText("Cargando tabla Bebidas...");
        Backendless.Persistence.of(Bebida.class).find(
                new AsyncCallback<BackendlessCollection<Bebida>>() {

                    public void handleResponse(BackendlessCollection<Bebida> bebidasBackendless) {

                        cargandoTxt.setText("");
                        if (bebidasBackendless != null) {
                            List<Bebida> bebidasList = bebidasBackendless.getData();
                            for (int i = 0; i < bebidasList.size(); i++) {
                                Bebida b = bebidasList.get(i);

                                String marca = b.getMarca();
                                float contUnit = b.getContenido();
                                float existencia = b.getExistencia();
                                float valor = b.getValor();
                                float minimo = b.getMinimo();

                                Object[] fila = new Object[]{b, marca, contUnit, existencia, valor, minimo};

                                modeloTablaBebidas.addRow(fila);

                                //Se agrega el objeto y la marca al ArrayList que evita que se modifiquen
                                //la primer y segunda columnas
                                bebidasBebidas.add(b);
                                marcasBebidas.add(marca);

                            }
                            calcularValorInventario();
                            chequearFaltantes();

                        }
                    }

                    public void handleFault(BackendlessFault bf) {
                        cargandoTxt.setText("");
                        //Si aun no se cargaron objetos de esta clase, arroja un error
                        //conocido por esto. En caso de que se trate de este error el que
                        //ocasiono la BackendlessFault esta todo en orden, por lo tanto se
                        //saltea.
                        if (!bf.getCode().equals(General.COD_SIN_CLASE)) {
                            JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                    bf.getMessage(), //Mensaje
                                    "Error al cargar la tabla Bebidas", //Titulo
                                    JOptionPane.WARNING_MESSAGE); //Imagen
                        }
                    }
                });

    }

    private void calcularValorInventario() {
        float valorInventario = 0;

        //Acumula el valor de la tabla Varios
        for (int i = 0; i < variosTbl.getRowCount(); i++) {
            Varios v = (Varios) modeloTablaVarios.getValueAt(i, 0);
            valorInventario += v.valuar();
        }

        //Acumula el valor de la tabla Bebidas
        for (int i = 0; i < bebidasTbl.getRowCount(); i++) {
            Bebida b = (Bebida) modeloTablaBebidas.getValueAt(i, 0);
            valorInventario += b.valuar();
        }

        //Informa el valor total a traves de la etiqueta
        valorInventarioLbl.setText("$" + valorInventario);

    }
    
    private void chequearFaltantes(){
       
        faltantes = "";
        
        //Chequea faltantes en la tabla Varios
        for (int i = 0; i < variosTbl.getRowCount(); i++) {
            Varios v = (Varios) modeloTablaVarios.getValueAt(i, 0);
            if(!v.chequearEstado().equals("OK")){
                faltantes += v.chequearEstado();
            }
        }

        //Chequea faltantes en la tabla Bebidas
        for (int i = 0; i < bebidasTbl.getRowCount(); i++) {
            Bebida b = (Bebida) modeloTablaBebidas.getValueAt(i, 0);
            if(!b.chequearEstado().equals("OK")){
                faltantes += b.chequearEstado();
            }
        }

        //En caso de haber faltanes lo informa traves de la etiqueta
        if(faltantes.equals("")){
            estadoLbl.setText("OK");
            estadoLbl.setForeground(Color.BLACK);
        }else{
            estadoLbl.setText("HAY FALTANTES. Para ver el detalle haga click aqui");
            estadoLbl.setForeground(Color.RED);
        }
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBebida;
    private javax.swing.JButton agregarVarios;
    private javax.swing.JTextField bebidaTxt;
    private javax.swing.JTable bebidasTbl;
    private javax.swing.JLabel cargandoTxt;
    private javax.swing.JTextField conceptoTxt;
    private javax.swing.JTextField contUnitTxt;
    private javax.swing.JButton eliminarBebida;
    private javax.swing.JButton eliminarVarios;
    private javax.swing.JLabel estadoLbl;
    private javax.swing.JTextField existBebidasTxt;
    private javax.swing.JTextField existVariosTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField marcaTxt;
    private javax.swing.JTextField minimoBebidasTxt;
    private javax.swing.JTextField minimoVariosTxt;
    private javax.swing.JTextField valorBebidasTxt;
    private javax.swing.JLabel valorInventarioLbl;
    private javax.swing.JTextField valorVariosTxt;
    private javax.swing.JTable variosTbl;
    // End of variables declaration//GEN-END:variables
}
