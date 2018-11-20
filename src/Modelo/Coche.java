package Modelo;

import java.util.ArrayList;

public class Coche {
    private int id;
    private int precio;
    private String marca;
    private String modelo;
    private String puertas;
    private ArrayList<Motor> listaMotores = new ArrayList<Motor>();

    public Coche() {
    }

    public Coche(int precio, String marca, String modelo, String puertas) {
        this.id = 0;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.puertas = puertas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPuertas() {
        return puertas;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    public ArrayList<Motor> getListaMotores() {
        return listaMotores;
    }

    public void setListaMotores(ArrayList<Motor> listaMotores) {
        this.listaMotores = listaMotores;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", puertas='" + puertas + '\'' +
                ", listaMotores=" + listaMotores +
                '}';
    }
}