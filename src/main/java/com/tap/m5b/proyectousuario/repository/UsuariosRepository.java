/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.repository;

import com.tap.m5b.proyectousuario.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
        @Query(value = "Select * from usuarios u where u.cedula = :cedula", nativeQuery = true)
    public Usuarios buscarUsuarios(String cedula);
}

