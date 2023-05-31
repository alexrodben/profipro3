/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.model;

/**
 *
 * @author alexr
 */
public class NodoHanoi {

    private String dato;
    private NodoHanoi arriba;
    private NodoHanoi abajo;

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoHanoi getArriba() {
        return arriba;
    }

    public void setArriba(NodoHanoi arriba) {
        this.arriba = arriba;
    }

    public NodoHanoi getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoHanoi abajo) {
        this.abajo = abajo;
    }

}
