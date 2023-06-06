/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.service;

import com.tap.m5b.proyectousuario.model.Productos;
import com.tap.m5b.proyectousuario.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ProductosServiceImpl extends GenericServiceImpl<Productos, Integer> implements GenericService<Productos, Integer> {

    @Autowired
    ProductosRepository productoRepository;

    @Override
    public CrudRepository<Productos, Integer> getDao() {
        return productoRepository;
    }
}
