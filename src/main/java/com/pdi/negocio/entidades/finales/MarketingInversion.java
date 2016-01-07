/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.entidades.finales;

import com.pdi.negocio.entidades.base.Inversion;
import java.util.Date;

/**
 *
 * @author Marcos Sastre
 */
public class MarketingInversion extends Inversion{

    //Atributos
    private int id;
    private float objetivoEconomico;
    private float presupuestoAsignado;
    private float resultadoFinanciero;
    private float cimplimientoObjetivo;
    private float roi;
    private Date fechaInicio;
    private Date fechaFin;
    private String medioDeDifusion;
    private String comentarios;
    
    //Constructores

    public MarketingInversion() {
    }

    public MarketingInversion(int id, float objetivoEconomico, 
            float presupuestoAsignado, float resultadoFinanciero, 
            float cimplimientoObjetivo, float roi, Date fechaInicio, 
            Date fechaFin, String medioDeDifusion, String comentarios, 
            String nombre, String objetivo) {
        super(nombre, objetivo);
        this.id = id;
        this.objetivoEconomico = objetivoEconomico;
        this.presupuestoAsignado = presupuestoAsignado;
        this.resultadoFinanciero = resultadoFinanciero;
        this.cimplimientoObjetivo = cimplimientoObjetivo;
        this.roi = roi;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.medioDeDifusion = medioDeDifusion;
        this.comentarios = comentarios;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getObjetivoEconomico() {
        return objetivoEconomico;
    }

    public void setObjetivoEconomico(float objetivoEconomico) {
        this.objetivoEconomico = objetivoEconomico;
    }

    public float getPresupuestoAsignado() {
        return presupuestoAsignado;
    }

    public void setPresupuestoAsignado(float presupuestoAsignado) {
        this.presupuestoAsignado = presupuestoAsignado;
    }

    public float getResultadoFinanciero() {
        return resultadoFinanciero;
    }

    public void setResultadoFinanciero(float resultadoFinanciero) {
        this.resultadoFinanciero = resultadoFinanciero;
    }

    public float getCimplimientoObjetivo() {
        return cimplimientoObjetivo;
    }

    public void setCimplimientoObjetivo(float cimplimientoObjetivo) {
        this.cimplimientoObjetivo = cimplimientoObjetivo;
    }

    public float getRoi() {
        return roi;
    }

    public void setRoi(float roi) {
        this.roi = roi;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMedioDeDifusion() {
        return medioDeDifusion;
    }

    public void setMedioDeDifusion(String medioDeDifusion) {
        this.medioDeDifusion = medioDeDifusion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
