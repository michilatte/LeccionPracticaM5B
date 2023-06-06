/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.service;

import com.tap.m5b.proyectousuario.model.Compras;
import com.tap.m5b.proyectousuario.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ComprasServiceImpl extends GenericServiceImpl<Compras, Integer> implements GenericService<Compras, Integer> {

    @Autowired
    ComprasRepository compraRepository;

    @Override
    public CrudRepository<Compras, Integer> getDao() {
        return compraRepository;
    }
}
