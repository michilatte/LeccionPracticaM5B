/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.repository;

import com.tap.m5b.proyectousuario.model.Compras;
import com.tap.m5b.proyectousuario.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface ComprasRepository extends JpaRepository<Compras, Integer>{
        @Query(value = "Select * from compras c where c.id_compra = :id_compra", nativeQuery = true)
    public Compras buscarCompras(String id_compra);
}

