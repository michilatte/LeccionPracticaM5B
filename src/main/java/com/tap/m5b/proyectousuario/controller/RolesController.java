/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.controller;

import com.tap.m5b.proyectousuario.model.Roles;
import com.tap.m5b.proyectousuario.service.RolesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    RolesServiceImpl rolesService;

    @Operation(summary = "Obtener lista de roles")
    @GetMapping("/listar")
    public ResponseEntity<List<Roles>> listaRoles() {
        return new ResponseEntity<>(rolesService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Enviar los campos del rol")
    @PostMapping("/crear")
    public ResponseEntity<Roles> crearRol(@RequestBody Roles r) {
        return new ResponseEntity<>(rolesService.save(r), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable Integer id, @RequestBody Roles r) {
        Roles rol = rolesService.findById(id);
        if (rol != null) {
            try {
                rol.setNombre_rol(r.getNombre_rol());
                rol.setDescripcion(r.getDescripcion());
                rol.setEstado(r.getEstado());
                
                return new ResponseEntity<>(rolesService.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Roles> eliminarRol(@PathVariable Integer id) {
        rolesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
