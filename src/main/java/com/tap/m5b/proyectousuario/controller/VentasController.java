/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.controller;

import com.tap.m5b.proyectousuario.model.Ventas;
import com.tap.m5b.proyectousuario.service.VentasServiceImpl;
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
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    VentasServiceImpl ventasService;

    @Operation(summary = "Obtener lista de ventas")
    @GetMapping("/listar")
    public ResponseEntity<List<Ventas>> listaVentas() {
        return new ResponseEntity<>(ventasService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Enviar los campos de ventas")
    @PostMapping("/crear")
    public ResponseEntity<Ventas> crearVenta(@RequestBody Ventas v) {
        return new ResponseEntity<>(ventasService.save(v), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ventas> actualizarVenta(@PathVariable Integer id, @RequestBody Ventas v) {
        Ventas ventas = ventasService.findById(id);
        if (ventas != null) {
            try {
                ventas.setCantidad(v.getCantidad());
                ventas.setPrecio(v.getPrecio());
                ventas.setFecha(v.getFecha());
                ventas.setUsuario(v.getUsuario());
                ventas.setProducto(v.getProducto());

                return new ResponseEntity<>(ventasService.save(ventas), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Ventas> eliminarVenta(@PathVariable Integer id) {
        ventasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
