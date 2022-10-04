package com.crustaceo_cascarudo.modelo;

import java.security.PublicKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carta")
public class Carta {

// ATRIBUTOS
@Id
private int id;
private String nombre;
private String categoria;
private String foto;
private String descripcion;
private Double precio;

// CONSTRUCTORES

public Carta() {}

public Carta(String nombre, String categoria, String foto, Double precio, String descripcion) {
    this.nombre = nombre;
    this.categoria = categoria;
    this.foto = foto;
    this.precio = precio;
    this.descripcion = descripcion;

}

// CONSULTORES 

public String getNombre(){
    return nombre;
}
public String getDescripcion(){
    return descripcion;
}

public String getFoto(){
    return foto;
}
public String getCategoria(){
    return categoria;
}
public double getPrecio(){
    return precio;
}
public int getId(){
    return id;
}

// MODIFICADORES

public void setNombre (String nombre_plato){
    this.nombre = nombre_plato;
}
public void setCategoria (String categoria){
    this.categoria = categoria;
}
public void setFoto (String foto){
    this.foto = foto;
}
public void setDescripcion (String descripcion){
    this.descripcion = descripcion;
}
public void setPrecio (Double precio){
    this.precio = precio;
}
    
}
