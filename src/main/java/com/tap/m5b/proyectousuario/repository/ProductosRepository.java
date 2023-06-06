/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.repository;

import com.tap.m5b.proyectousuario.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface ProductosRepository extends JpaRepository<Productos, Integer>{
        @Query(value = "Select * from productos p where p.nombre = :nombre", nativeQuery = true)
    public Productos buscarProductos(String nombre);
}

