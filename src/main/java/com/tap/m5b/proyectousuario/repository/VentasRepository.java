/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.repository;

import com.tap.m5b.proyectousuario.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
        @Query(value = "Select * from ventas v where v.fecha = :fecha", nativeQuery = true)
    public Ventas buscarVentas(String fecha);
}

