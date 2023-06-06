/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.service;


import com.tap.m5b.proyectousuario.model.Ventas;
import com.tap.m5b.proyectousuario.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author USUARIO
 */
@Service
public class VentasServiceImpl extends GenericServiceImpl<Ventas, Integer> implements GenericService<Ventas, Integer> {

    @Autowired
    VentasRepository ventaRepository;

    @Override
    public CrudRepository<Ventas, Integer> getDao() {
        return ventaRepository;
    }  
}