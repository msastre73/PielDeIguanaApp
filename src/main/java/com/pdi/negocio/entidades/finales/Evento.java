/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.enums.EstadoDeEvento;
import com.pdi.negocio.enums.TipoDeEvento;
import java.util.Date;

/**
 *
 * @author Marcos Sastre
 */
class Evento {
    private int id;
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
    
    //Constructores

    public Evento() {
    }

    public Evento(int id, Date fecha, String lugar, int cantidadDePersonas,
            TipoDeEvento tipoDeEvento, Aliado aliado, Cliente cliente, 
            float precio, float costo, float resultado, float montoPagado, 
            float montoRestante, EstadoDeEvento estadoDeEvento) {
        
        //Atributos
        this.id = id;
        this.fecha = fecha;
        this.lugar = lugar;
        this.cantidadDePersonas = cantidadDePersonas;
        this.tipoDeEvento = tipoDeEvento;
        this.aliado = aliado;
        this.cliente = cliente;
        this.precio = precio;
        this.costo = costo;
        this.resultado = resultado;
        this.montoPagado = montoPagado;
        this.montoRestante = montoRestante;
        this.estadoDeEvento = estadoDeEvento;
    }
    
    
    //Metodos
    
      public void cotizar(){
          //TODO - tomando los datos del evento y los valores de referencia,
          //calcula el costo del evento y setea el atributo costo
      }
    
      public void generarOrdenDeCompra(){
          //TODO - teniendo en cuenta las cantidades de insumos necesarias y las
          //que hay en stock por encima del minimo, elabora la orden de compra
      }
    
      
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
           
    
    
    
    
    
}
