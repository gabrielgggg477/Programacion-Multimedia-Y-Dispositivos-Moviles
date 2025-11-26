package com.example.listacompra;

public class Item {
    private String nombre;
    private int cantidad;
    private int imagenResId;

    // Constructor
    public Item(String nombre, int cantidad, int imagenResId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.imagenResId = imagenResId;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }
}
