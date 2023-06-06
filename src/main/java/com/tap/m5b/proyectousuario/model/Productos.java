/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;
    
    @NotBlank(message = "Llene el campo nombre de producto")
    @Column(name = "nombre")
    private String nombre;
    
    @NotBlank(message = "Llene el campo descripcion")
    @Column(name = "descripcion")
    private String descripcion;
      
    @Column(name = "precio_emprendedor")
    private double precio_emprendedor;
    
    @Column(name = "imagen")
    private String imagen;
    
    @NotBlank(message = "Llene el campo talla")
    @Column(name = "talla")
    private String talla;
    
    @NotBlank(message = "Llene el campo color")
    @Column(name = "color")
    private String color;
    

   @JsonIgnore 
    @OneToMany(mappedBy = "producto")
    private List<Ventas> listaVentas;
   
   
   @JsonIgnore 
    @OneToMany(mappedBy = "producto")
    private List<Compras> listaCompras;
}