package com.mycompany.mavenproject8.Oters;

import java.sql.Time;

public class Player {
    private int ID;
    private String usuario;
    private String contrasena;
    private String pregunta;
    private String respuesta;
    private Time tiempoGuego;
    private int puntaje;
    private int turnos;
    private int admin;
    
    
    
    public Player(int iD, String usuario, String contrasena, String pregunta, String respuesta, Time tiempoGuego,
            int puntaje, int turnos,int admin) {
        this.ID = iD;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.tiempoGuego = tiempoGuego;
        this.puntaje = puntaje;
        this.turnos = turnos;
        this.admin = admin;
    }
    public Player() {
        this.ID = 0;
        this.usuario = "";
        this.contrasena = "";
        this.pregunta = "";
        this.respuesta = "";
        this.tiempoGuego = Time.valueOf("00:00:00");
        this.puntaje = 0;
        this.turnos = 0;
        this.admin = 0;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String nombre) {
        this.usuario = nombre;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Time getTiempoGuego() {
        return tiempoGuego;
    }
    public void setTiempoGuego(Time tiempoGuego) {
        this.tiempoGuego = tiempoGuego;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public int getTurnos() {
        return turnos;
    }
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
    public int isAdmin() {
        return admin;
    }
    public void setAdmin(int admin) {
        this.admin = admin;
    }
    public String toString() {
        return "Payer [iD=" + ID + ", usuario=" + usuario + ", contrasena=" + contrasena + ", pregunta=" + pregunta
                + ", respuesta=" + respuesta + ", tiempoGuego=" + tiempoGuego + ", puntaje=" + puntaje + ", turnos="
                + turnos + admin+"]";
    }
    public String toString(int i){
        return ID+";"+usuario+";"+contrasena+";"+pregunta+";"+respuesta+";"+tiempoGuego+";"+puntaje+";"+turnos+";"+admin;
    }
    
}
