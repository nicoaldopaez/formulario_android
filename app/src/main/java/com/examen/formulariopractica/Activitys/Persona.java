package com.examen.formulariopractica.Activitys;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;

    private int edad;

    private int valoracion;

    private int genero;

    public Persona(String nombre, String anyos){
        this.nombre = nombre;
        this.edad = Integer.parseInt(anyos);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int isGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        if (genero == 0 || genero == 1) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("El género debe ser 0 (Femenino) o 1 (Masculino).");
        }
    }
}
