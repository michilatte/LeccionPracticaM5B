/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.proyectousuario.controller;

import com.tap.m5b.proyectousuario.model.Usuarios;
import com.tap.m5b.proyectousuario.service.UsuariosServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/usuarios")
public class UsuariosController {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UsuariosServiceImpl usuariosService;

    @Operation(summary = "Obtener lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Usuarios>> listaUsuarios() {
        return new ResponseEntity<>(usuariosService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Enviar los campos del usuario")
    @PostMapping("/crear")
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios u) {
        return new ResponseEntity<>(usuariosService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios u) {
        Usuarios usuario = usuariosService.findById(id);

        if (usuario != null) {
            try {
                usuario.setNombre(u.getNombre());
                usuario.setApellido(u.getApellido());
                usuario.setCedula(u.getCedula());
                usuario.setDireccion(u.getDireccion());
                usuario.setTelefono(u.getTelefono());
                //USO DEPENDENCIA DE SEGURIDAD
                String hashedPassword = passwordEncoder.encode(u.getContrasena());
                u.setContrasena(hashedPassword);
                usuario.setCorreo(u.getCorreo());
                usuario.setRoles(u.getRoles());
                return new ResponseEntity<>(usuariosService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuarios> eliminarUsuario(@PathVariable Integer id) {
        usuariosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
