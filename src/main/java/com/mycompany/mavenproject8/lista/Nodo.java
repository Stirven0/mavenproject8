package com.mycompany.mavenproject8.lista;

import com.mycompany.mavenproject8.Oters.Payer;

public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;


    private Payer value;


    public Nodo(Payer persona) {
        this.value = persona;
        this.anterior = null;
        this.siguiente = null;
    }
    public Nodo() {
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public Payer getValue() {
        return value;
    }
    public void setValue(Payer persona) {
        this.value = persona;
    }
    

    
}
