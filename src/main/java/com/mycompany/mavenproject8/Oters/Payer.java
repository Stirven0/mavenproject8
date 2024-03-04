package com.mycompany.mavenproject8.Oters;

public class Payer {
    private String nombre;
    private int iD;
    private int edad;
    
    public Payer(String nombre, int iD, int edad) {
        this.nombre = nombre;
        this.iD = iD;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getiD() {
        return iD;
    }
    public void setiD(int iD) {
        this.iD = iD;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", iD=" + iD + ", edad=" + edad  + "]";
    }
    
}
