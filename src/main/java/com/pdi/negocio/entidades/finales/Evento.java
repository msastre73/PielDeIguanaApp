/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.enums.EstadoDeEvento;
import com.pdi.negocio.enums.TipoDeEvento;
import com.pdi.util.General;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Marcos Sastre
 */
public class Evento {

    private String objectId;
    private Date created;
    private Date updated;
    private Date fecha;
    private String lugar;
    private int cantidadDePersonas;
    private TipoDeEvento tipoDeEvento;
    private Aliado aliado;
    private Cliente cliente;
    private float precio;
    private float costo;
    private float resultado;
    private float montoPagado;
    private float montoRestante;
    private EstadoDeEvento estadoDeEvento;
    private HashMap<String, Object> insumosNeecesarios;

    //Constructores
    public Evento() {
    }


    //Metodos
    public void cotizar() {
          //TODO - tomando los datos del evento y los valores de referencia,
        //calcula el costo del evento y setea el atributo costo
    }

    public void generarOrdenDeCompra() {
          //TODO - teniendo en cuenta las cantidades de insumos necesarias y las
        //que hay en stock por encima del minimo, elabora la orden de compra
    }

    //Getters y Setters

    public HashMap<String, Object> getInsumosNeecesarios() {
        return insumosNeecesarios;
    }

    public void setInsumosNeecesarios(HashMap<String, Object> insumosNeecesarios) {
        this.insumosNeecesarios = insumosNeecesarios;
    }
    
    
    
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public TipoDeEvento getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(TipoDeEvento tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    public Aliado getAliado() {
        return aliado;
    }

    public void setAliado(Aliado aliado) {
        this.aliado = aliado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public float getMontoRestante() {
        return montoRestante;
    }

    public void setMontoRestante(float montoRestante) {
        this.montoRestante = montoRestante;
    }

    public EstadoDeEvento getEstadoDeEvento() {
        return estadoDeEvento;
    }

    public void setEstadoDeEvento(EstadoDeEvento estadoDeEvento) {
        this.estadoDeEvento = estadoDeEvento;
    }

    @Override
    public String toString() {
        if(aliado != null){
            return tipoDeEvento + " de " + cliente.getNombre() + " " + cliente.getApellido()
                    +" el " + General.formatoFecha.format(fecha) + " en "
                    + lugar + ". " + estadoDeEvento + ". Aliado: " + aliado.getNombre()
                    + " " + aliado.getApellido();
        }else{
           return tipoDeEvento + " de " + cliente.getNombre() + " " + cliente.getApellido()
                    +" el " + General.formatoFecha.format(fecha) + " en "
                    + lugar + ". " + estadoDeEvento + ". Sin aliado.";
        }
        
    }

}
