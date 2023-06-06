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
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int id_rol;
    
    @NotBlank(message = "Llene el campo tipo")
    @Column(name = "tipo")
    private String nombre_rol;
    
    @NotBlank(message = "Llene el campo descripcion")
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private int estado;
    
    
    //un rol tiene muchos usuarios y muchos usuarios pertenecen a un rol
    
    @JsonIgnore  //solo va en la relacion principal
    @OneToMany(mappedBy = "roles")
    private List<Usuarios> listaUsuarios;
    
}
