/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.service;

import com.tap.m5b.proyectousuario.model.Roles;
import com.tap.m5b.proyectousuario.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class RolesServiceImpl extends GenericServiceImpl<Roles, Integer> implements GenericService<Roles, Integer> {

    @Autowired
    RolesRepository rolRepository;

    @Override
    public CrudRepository<Roles, Integer> getDao() {
        return (CrudRepository<Roles, Integer>) rolRepository;
    }  
}
