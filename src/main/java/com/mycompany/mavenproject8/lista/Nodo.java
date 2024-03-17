package com.mycompany.mavenproject8.lista;

import com.mycompany.mavenproject8.Oters.Player;

public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;


    private Player value;


    public Nodo(Player persona) {
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
    public Player getValue() {
        return value;
    }
    public void setValue(Player persona) {
        this.value = persona;
    }
    

    
}
