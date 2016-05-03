/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdi.negocio.enums;

/**
 *
 * @author Marcos
 */
public enum TipoDeBebida {

    CACHACA,
    VODKA,
    RON_DORADO,
    RON_BLANCO,
    FERNET,
    GANCIA,
    WHISKY,
    CAMPARI,
    LICOR_KIWI,
    LICOR_DURAZNO,
    LIMON,
    LIMA,
    MENTA,
    AZUCAR,
    GRANADINA,
    JUGO_NARANJA,
    JUGO_MANZANA,
    PULPA_FRUTILLA,
    PULPA_DURAZNO,
    PULPA_ANANA,
    SPRITE,
    SODA;

    public static TipoDeBebida getFromInt(int i) {
        switch (i) {
            case 1:
                return TipoDeBebida.CACHACA;
            case 2:
                return TipoDeBebida.VODKA;
            case 3:
                return TipoDeBebida.RON_DORADO;
            case 4:
                return TipoDeBebida.RON_BLANCO;
            case 5:
                return TipoDeBebida.FERNET;
            case 6:
                return TipoDeBebida.GANCIA;
            case 7:
                return TipoDeBebida.WHISKY;
            case 8:
                return TipoDeBebida.CAMPARI;
            case 9:
                return TipoDeBebida.LICOR_KIWI;
            case 10:
                return TipoDeBebida.LICOR_DURAZNO;
            case 11:
                return TipoDeBebida.LIMON;
            case 12:
                return TipoDeBebida.LIMA;
            case 13:
                return TipoDeBebida.MENTA;
            case 14:
                return TipoDeBebida.AZUCAR;
            case 15:
                return TipoDeBebida.GRANADINA;
            case 16:
                return TipoDeBebida.JUGO_NARANJA;
            case 17:
                return TipoDeBebida.JUGO_MANZANA;
            case 18:
                return TipoDeBebida.PULPA_FRUTILLA;
            case 19:
                return TipoDeBebida.PULPA_DURAZNO;
            case 20:
                return TipoDeBebida.PULPA_ANANA;
            case 21:
                return TipoDeBebida.SPRITE;
            case 22:
                return TipoDeBebida.SODA;

        }
        return null;

    }

}
