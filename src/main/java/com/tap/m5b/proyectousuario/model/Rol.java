/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int id_rol;
    
    @NotBlank(message = "Llene el campo tipo")
    @Column(name = "tipo")
    private String tipo;
    
    @NotBlank(message = "Llene el campo descripcion")
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private int estado;
    
    
}
