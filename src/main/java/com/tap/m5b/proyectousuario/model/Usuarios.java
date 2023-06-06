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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    @NotBlank(message = "Llene el campo usuario")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "Llene el campo apellido")
    @Column(name = "apellido")
    private String apellido;

    @Size(min = 10, max = 10, message = "La cedula debe tener 10 digitos")
    @NotBlank(message = "Llene el campo usuario")
    @Column(name = "cedula")
    private String cedula;

    @NotBlank(message = "Llene el campo direccion")
    @Column(name = "direccion")
    private String direccion;

    @Size(min = 7, max = 10, message = "El telefono debe tener entre 7 y 10 digitos")
    @NotBlank(message = "Llene el campo telefono")
    @Column(name = "telefono")
    private String telefono;

    @Email(message = "Ingrese un correo válido")
    @Column(name = "correo")
    private String correo;

    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    @Column(name = "contrasena")
    private String contrasena;

    //  *   *   *   RELACIONES  *   *   *
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Roles roles;
    
    @JsonIgnore 
    @OneToMany(mappedBy = "usuario")
    private List<Ventas> listaVentas;
    
    @JsonIgnore 
    @OneToMany(mappedBy = "usuario")
    private List<Compras> listaCompras;
    
}
