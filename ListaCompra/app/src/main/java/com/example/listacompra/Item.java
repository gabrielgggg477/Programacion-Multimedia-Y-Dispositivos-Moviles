package com.example.listacompra;

public class Item {
    private String nombre;
    private int cantidad;
    private int imagenResId;

    public Item(String nombre, int cantidad, int imagenResId) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.imagenResId = imagenResId;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getImagenResId() { return imagenResId; }
    public void setImagenResId(int imagenResId) { this.imagenResId = imagenResId; }
}
