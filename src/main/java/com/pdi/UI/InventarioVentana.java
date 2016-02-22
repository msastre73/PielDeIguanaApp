/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.UI;

import com.sun.istack.internal.Nullable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;
import org.parse4j.callback.SaveCallback;

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

    //Titulos para las columnas de las tablas 
    private final String[] colNameVarios = new String[]{
        "Concepto", "Existencia", "Valor", "Minimo"};

    private final String[] colNameBebidas = new String[]{
        "Bebida", "Marca", "ContUnit", "Existencia", "Valor", "Minimo"};

    //Valores de la tabla Varios que no deben cambiar
    private String[] conceptosVarios = new String[]{"Varios", "Sorbetes", "Revolvedores"};

    //Valores de la tabla Bebidas  que no deben cambiar (se agregar dinamicamente)
    private ArrayList<String> bebidasBebidas = new ArrayList<String>();
    private ArrayList<String> marcasBebidas = new ArrayList<String>();

    //Modelos para controlar la info de las tablas
    private DefaultTableModel modeloTablaVarios = new DefaultTableModel(null, colNameVarios);
    private DefaultTableModel modeloTablaBebidas = new DefaultTableModel(null, colNameBebidas);

    public InventarioVentana() {

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
                        modeloTablaVarios.setValueAt(conceptosVarios[i], i, 0);
                        modeloTablaVarios.addTableModelListener(this);

                    } else {
                        int row = e.getFirstRow();
                        int column = e.getColumn();
                        String atribCambiado = modeloTablaVarios.getColumnName(column);
                        Object concepto = modeloTablaVarios.getValueAt(row, 0);
                        Object val = modeloTablaVarios.getValueAt(row, column);

                        editarCampo("Varios", "concepto", null, null,
                                concepto.toString(),
                                atribCambiado, Float.parseFloat(val.toString()));
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

                        int row = e.getFirstRow();
                        int column = e.getColumn();
                        String atribCambiado = modeloTablaBebidas.getColumnName(column);
                        Object bebida = modeloTablaBebidas.getValueAt(row, 0);
                        Object marca = modeloTablaBebidas.getValueAt(row, 1);
                        Object val = modeloTablaBebidas.getValueAt(row, column);
                        editarCampo("Bebidas", //Tabla
                                "Bebida", bebida.toString(), //keyRef, valorRef
                                "Marca", marca.toString(), //keyRef2, valorRef2
                                atribCambiado, Float.parseFloat(val.toString()));//keyChange, valorChange

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
        agregarBebida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bebidaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        contUnitTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bebidasTbl = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        minimoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        existTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        valorTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cargandoTxt = new javax.swing.JLabel();
        agregarBebida1 = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        agregarBebida.setText("Agregar Bebida");
        agregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBebidaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("ESTADO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("OK");

        jLabel3.setText("Bebida:");

        jLabel4.setText("Marca:");

        jLabel5.setText("Cont Unit:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel6.setText("Valor: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel7.setText("$0");

        jLabel8.setText("Exist:");

        jLabel9.setText("Valor:");

        jLabel10.setText("Minimo:");

        cargandoTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        agregarBebida1.setText("Eliminar");
        agregarBebida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBebida1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bebidaTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marcaTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contUnitTxt))
                    .addComponent(agregarBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(existTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimoTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cargandoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(agregarBebida1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(45, 45, 45))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bebidaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(contUnitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(existTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(valorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(minimoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(agregarBebida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarBebida1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cargandoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(131, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBebidaActionPerformed

        boolean validacionOK = validarForm();

        if (validacionOK) {
            cargandoTxt.setText("Guardando bebida...");
            String bebida = bebidaTxt.getText();
            String marca = marcaTxt.getText();
            String contUnit = contUnitTxt.getText();
            String existencia = existTxt.getText();
            String valor = valorTxt.getText();
            String minimo = minimoTxt.getText();

            final Object[] fila = {bebida, marca, contUnit, existencia, valor, minimo};

            //Agrega la bebida a Parse
            ParseObject bebidaParse = new ParseObject("Bebidas");
            bebidaParse.put("Bebida", bebida);
            bebidaParse.put("Marca", marca);
            bebidaParse.put("ContUnit", Float.parseFloat(contUnit));
            bebidaParse.put("Existencia", Float.parseFloat(existencia));
            bebidaParse.put("Valor", Float.parseFloat(valor));
            bebidaParse.put("Minimo", Float.parseFloat(minimo));

            bebidaParse.saveInBackground(new SaveCallback() {

                @Override
                public void done(ParseException parseException) {
                    cargandoTxt.setText("");
                    if (parseException == null) {
                        JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                "Bebida agregada correctamente.", //Mensaje
                                "Bebida Agregadaa", //Titulo
                                JOptionPane.INFORMATION_MESSAGE);
                        //Agrega la bebida a la tabla
                        modeloTablaBebidas.addRow(fila);
                        limpiarForm();
                    } else {
                        JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                "Error: " + parseException.toString(), //Mensaje
                                "Error al guardar la imputacion", //Titulo
                                JOptionPane.WARNING_MESSAGE); //Imagen
                    }
                }
            });
        }


    }//GEN-LAST:event_agregarBebidaActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        abierta = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void agregarBebida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBebida1ActionPerformed
        
        int fila = bebidasTbl.getSelectedRow();
        
        if(fila==-1){
            JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                "Seleccione la bebida que desea eliminar", //Mensaje
                                "No hay bebida seleccionada", //Titulo
                                JOptionPane.WARNING_MESSAGE); //Imagen
        }else{
            String bebida = bebidasTbl.getValueAt(fila, 0).toString();
            String marca = bebidasTbl.getValueAt(fila, 0).toString();
            
            int rta = JOptionPane.showConfirmDialog(this,
                "Confirma que quiere eliminar este cliente?:\n"
                + bebida + " marca " + marca,
                "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
            
            if (rta == JOptionPane.NO_OPTION) {
            return;
        } else {
            eliminar();
            limpiarForm();
            
            
        }
            
            
        }
        
        
    }//GEN-LAST:event_agregarBebida1ActionPerformed

    public void editarCampo(String tabla,
            String keyRef, String valorRef,
            @Nullable String keyRef2, @Nullable String valorRef2,//Solo se usa al editar Bebidas
            final String keyChange, final float valorChange) {
        cargandoTxt.setText("Guardando elemento...");
        ParseQuery<ParseObject> query = ParseQuery.getQuery(tabla);
        query.whereEqualTo(keyRef, valorRef);

        if (keyRef2 != null) {
            query.whereEqualTo(keyRef2, valorRef2);
        }
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> elementos, ParseException parseException) {

                if (parseException == null && !elementos.isEmpty()) {
                    ParseObject elemento = elementos.get(0);
                    elemento.put(keyChange, valorChange);

                    elemento.saveInBackground(new SaveCallback() {

                        @Override
                        public void done(ParseException parseException) {
                            cargandoTxt.setText("");
                            if (parseException != null) {
                                JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                        parseException.toString(), //Mensaje
                                        "Error al guardar elemento", //Titulo
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    });

                } else {
                    cargandoTxt.setText("");
                    JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            parseException.toString(), //Mensaje
                            "Error al guardar elemento", //Titulo
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    private void eliminar(int fila, String bebidaStr, String marcaStr){
        cargandoTxt.setText("Eliminando cliente...");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bebidas");
        query.whereEqualTo(title, fila)
        
    }
    
    
    private boolean validarForm() {
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
        if (existTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "La Existencia no puede estar vacia",
                    "Completar Existencia", JOptionPane.WARNING_MESSAGE);
            existTxt.requestFocus();
            return false;
        }

        //Validar que la exist sea un numero decimal
        try {
            Float.parseFloat(existTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La Existencia debe ser un numero decimal",
                    "Corregir Existencia", JOptionPane.WARNING_MESSAGE);
            existTxt.requestFocus();
            return false;
        }

        //Validar que el contUnit no este vacio
        if (valorTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Valor no puede estar vacio",
                    "Completar Valor", JOptionPane.WARNING_MESSAGE);
            valorTxt.requestFocus();
            return false;
        }

        //Validar que el contUnit sea un numero decimal
        try {
            Float.parseFloat(valorTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Valor debe ser un numero decimal",
                    "Corregir Valor", JOptionPane.WARNING_MESSAGE);
            valorTxt.requestFocus();
            return false;
        }

        //Validar que el existencia no este vacio
        if (minimoTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "El Minimo no puede estar vacio",
                    "Completar Minimo", JOptionPane.WARNING_MESSAGE);
            minimoTxt.requestFocus();
            return false;
        }

        //Validar que el existencia sea un numero decimal
        try {
            Float.parseFloat(minimoTxt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El Minimo debe ser un numero decimal",
                    "Corregir Minimo", JOptionPane.WARNING_MESSAGE);
            minimoTxt.requestFocus();
            return false;
        }

        return true;
    }

    private void limpiarForm() {
        bebidaTxt.setText("");
        marcaTxt.setText("");
        contUnitTxt.setText("");
        existTxt.setText("");
        valorTxt.setText("");
        minimoTxt.setText("");
        bebidasTbl.clearSelection();

    }

    private void cargarVariosYBebidas() {
        cargandoTxt.setText("Cargando tablas Varios...");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Varios");

        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> variosParse, ParseException parseException) {
                cargandoTxt.setText("");
                if (parseException == null) {
                    for (int i = 0; i < variosParse.size(); i++) {
                        ParseObject insumo = variosParse.get(i);

                        Object concepto = insumo.get("concepto");
                        Object existencia = insumo.get("Existencia");
                        Object valor = insumo.get("Valor");
                        Object minimo = insumo.get("Minimo");

                        Object[] fila = new Object[]{concepto, existencia,
                            valor, minimo};

                        modeloTablaVarios.addRow(fila);

                    }
                    cargarBebidas();
                } else {
                    JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                            parseException.toString(), //Mensaje
                            "Error al cargar la tabla Varios", //Titulo
                            JOptionPane.WARNING_MESSAGE); //Imagen
                }

            }
        });
    }

    private void cargarBebidas() {
        cargandoTxt.setText("Cargando tabla Bebidas...");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bebidas");

        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> bebidasParse, ParseException parseException) {
                cargandoTxt.setText("");
                if (bebidasParse != null) {
                    if (parseException == null) {
                        for (int i = 0; i < bebidasParse.size(); i++) {
                            ParseObject bebida = bebidasParse.get(i);

                            Object bebidaVal = bebida.get("Bebida");
                            Object marca = bebida.get("Marca");
                            Object contUnit = bebida.get("ContUnit");
                            Object existencia = bebida.get("Existencia");
                            Object valor = bebida.get("Valor");
                            Object minimo = bebida.get("Minimo");

                            Object[] fila = new Object[]{bebidaVal, marca,
                                contUnit, existencia, valor, minimo};

                            modeloTablaBebidas.addRow(fila);
                            //Se agregan los valor de Bebida y Marca a los Array
                            //que controlan que no se modifiquen
                            bebidasBebidas.add(bebidaVal.toString());
                            marcasBebidas.add(marca.toString());

                        }

                    } else {
                        JOptionPane.showMessageDialog(InventarioVentana.this, //Componente
                                parseException.toString(), //Mensaje
                                "Error al cargar la tabla Bebidas", //Titulo
                                JOptionPane.WARNING_MESSAGE); //Imagen
                    }
                }

            }
        }
        );

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBebida;
    private javax.swing.JButton agregarBebida1;
    private javax.swing.JTextField bebidaTxt;
    private javax.swing.JTable bebidasTbl;
    private javax.swing.JLabel cargandoTxt;
    private javax.swing.JTextField contUnitTxt;
    private javax.swing.JTextField existTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField marcaTxt;
    private javax.swing.JTextField minimoTxt;
    private javax.swing.JTextField valorTxt;
    private javax.swing.JTable variosTbl;
    // End of variables declaration//GEN-END:variables
}
