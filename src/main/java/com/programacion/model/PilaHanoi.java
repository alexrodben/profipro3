/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.model;

/**
 *
 * @author alexr
 */
public class PilaHanoi {

    private int contNodo = 0;
    private NodoHanoi cabeza;

    public int getContNodo() {
        return contNodo;
    }

    public void setContNodo(int contNodo) {
        this.contNodo = contNodo;
    }

    public NodoHanoi getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoHanoi cabeza) {
        this.cabeza = cabeza;
    }

    public void push(NodoHanoi n) {
        contNodo++;
        if (cabeza == null) {
            cabeza = n;
        } else {
            n.setAbajo(cabeza);
            cabeza.setArriba(n);
            cabeza = n;
        }
    }

    public void pop() {
        if (contNodo > 0) {
            contNodo--;
            cabeza = cabeza.getAbajo();
        }
    }

    public String peek() {
        return cabeza.getDato();
    }

}
