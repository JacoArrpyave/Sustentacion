package com.sustentacion.app.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_VEHICULO")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name ="marca")
    private String marca;
    @Column(name ="modelo")
    private String  modelo;
    @Column(name ="año")
    private int año;
    @Column(name ="color")
    private String color;
    @Column(name ="precio")
    private float precio;
    @Column(name ="tipo_vehiculo")
    private String tipo_vehiculo;
    @Column(name ="concesionaria")
    private String consesionaria;
    @Column(name ="imagen")
    private String imagen;
    public Vehiculo( String marca, String modelo, int año, String color, float precior, String tipo_vehiculo,
            String consesionaria, String imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.precio = precior;
        this.tipo_vehiculo = tipo_vehiculo;
        this.consesionaria = consesionaria;
        this.imagen = imagen;
    }
    public Vehiculo() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precior) {
        this.precio = precior;
    }
    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }
    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }
    public String getConsesionaria() {
        return consesionaria;
    }
    public void setConsesionaria(String consesionaria) {
        this.consesionaria = consesionaria;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
}
