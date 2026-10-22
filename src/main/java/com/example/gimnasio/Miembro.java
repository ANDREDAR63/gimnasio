package com.example.gimnasio;

public class Miembro {
    private String nombre;
    private int edad;

    public Miembro(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);
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
        if (edad > 0) {
            this.edad = edad;
        } else {
            this.edad = 0;
            System.out.println("Edad no valida.");
        }
    }

    public double cuotaMensual() {
        return 50000.0;
    }

    public String descripcion() {
        return nombre + " (" + edad + " años)";
    }
}
