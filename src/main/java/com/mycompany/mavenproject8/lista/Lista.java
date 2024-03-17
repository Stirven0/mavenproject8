package com.mycompany.mavenproject8.lista;

import com.mycompany.mavenproject8.Oters.Player;

public class Lista {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public boolean removeLast() {
        if (isEmpy()) {
            return false;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
            tamaño--;
            return true;
        }
    }

    public void clear() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    public boolean removeFirst() {
        if (isEmpy()) {
            return false;
        } else {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
            tamaño--;
            return true;
        }
    }

    public int zise() {
        return tamaño;
    }

    public Player get(int index) {
        if (isEmpy() || index < 0 || index >= tamaño) {
            return null;
        } else {
            Nodo aux = primero;
            for (int i = 0; i < index; i++) {
                aux = aux.getSiguiente();
            }
            return aux.getValue();
        }
    }

    public Player getFirst() {

        return primero.getValue();
    }

    public Player getLast() {
        return ultimo.getValue();
    }

    public void addToFirst(Player persona) {
        Nodo nodo = new Nodo(persona);
        if (isEmpy()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            nodo.setSiguiente(primero);
            primero.setAnterior(nodo);
            primero = nodo;
        }
        tamaño++;
    }

    public void add(int index, Player persona) {
        Nodo nodo = new Nodo(persona);
        if (index < 0 || index >= tamaño) {
            return;
        }
        if (isEmpy()) {
            primero = nodo;
            ultimo = nodo;
            primero.setSiguiente(ultimo);
            ultimo.setAnterior(primero);
            tamaño++;
            // return false;
        } else {
            Nodo aux = primero;
            for (int i = 0; i < index; i++) {
                aux = aux.getSiguiente();
            }
            nodo.setAnterior(aux.getAnterior());
            aux.getAnterior().setSiguiente(nodo);
            nodo.setSiguiente(aux);
            aux.setAnterior(nodo);

            tamaño++;
            // return false;
        }
    }

    public boolean add(Player persona) {
        return addToLasd(persona);
    }

    public boolean addToLasd(Player persona) {
        Nodo nodo = new Nodo(persona);
        if (isEmpy()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            nodo.setAnterior(ultimo);
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
        tamaño++;
        return true;
    }

    public boolean isEmpy() {
        if (primero == null && ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

}
