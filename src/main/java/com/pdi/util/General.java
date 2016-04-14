/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.util;

import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcos Sastre
 */
public abstract class General {

    public static String ID_CAJA = "60F4BCD9-7C85-AA78-FF4C-4C86DD1BAE00";

    public static String ID_CANT_BASE = "D4EB2C91-E18E-0D39-FF51-36D4955A9B00";

    public static String ID_PRECIOS_BASE = "4F646333-7CDE-EF93-FF33-75CF36013F00";

    public static String ID_VARS_COTIZ = "AEC8B495-9464-75E4-FFE0-65257339BF00";

    public static String COD_SIN_CLASE = "1009";

    public static SimpleDateFormat formatoFecha
            = new SimpleDateFormat("dd/MM/yyyy");

    public final static String formatoMail
            = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    public static BackendlessDataQuery getQueryDepth2() {

        BackendlessDataQuery query = new BackendlessDataQuery();
        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setRelationsDepth(2);
        query.setQueryOptions(queryOptions);
        return query;
    }

    public static float diferenciaFechasEnMes(Date fechaMayor, Date fechaMenor) {
        float diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
        float dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        float meses = dias / 30;
        return meses;
    }

}
