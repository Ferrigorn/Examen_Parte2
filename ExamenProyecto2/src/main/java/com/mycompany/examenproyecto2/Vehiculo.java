/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenproyecto2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author fbabu
 */
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipo;
    private String marca;
    private int potencia;
    private int fechaDeCompra;
    
    public Vehiculo(){
        
    }
    
    /* Getters y Setters*/
    
    public  int getId(){
       return id; 
    }
    
    public void setId(int id){
       this.id = id;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public  String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public int getPotencia(){
        return potencia;
    }
    
    public void setPotencia(int potencia){
        this.potencia = potencia;
    }
    
    public int getFechaDeCompra(){
        return fechaDeCompra;
    }
    
    public void setFechaDeCompra( int fechaDeCompra){
        this.fechaDeCompra = fechaDeCompra;
    }
    
    
}
