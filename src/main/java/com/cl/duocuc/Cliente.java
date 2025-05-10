package com.cl.duocuc;

public class Cliente {

    public int edad;
    public String genero;
    public boolean creado;

    public Cliente () {}

    public Cliente(int edad, String genero) {
        this.edad = edad;
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
