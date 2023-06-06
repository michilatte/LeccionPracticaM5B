/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.service;

import com.tap.m5b.proyectousuario.model.Usuarios;
import com.tap.m5b.proyectousuario.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class UsuariosServiceImpl extends GenericServiceImpl<Usuarios, Integer> implements GenericService<Usuarios, Integer> {

    @Autowired
    UsuariosRepository usuarioRepository;

    @Override
    public CrudRepository<Usuarios, Integer> getDao() {
        return usuarioRepository;
    }  
}