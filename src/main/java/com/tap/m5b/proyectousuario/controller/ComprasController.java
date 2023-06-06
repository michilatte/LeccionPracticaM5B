/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.controller;

import com.tap.m5b.proyectousuario.model.Compras;
import com.tap.m5b.proyectousuario.service.ComprasServiceImpl;
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
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    ComprasServiceImpl comprasService;

    @Operation(summary = "Obtener lista de compras")
    @GetMapping("/listar")
    public ResponseEntity<List<Compras>> listaCompras() {
        return new ResponseEntity<>(comprasService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Enviar los campos de compras")
    @PostMapping("/crear")
    public ResponseEntity<Compras> crearCompra(@RequestBody Compras c) {
        return new ResponseEntity<>(comprasService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Compras> actualizarCompra(@PathVariable Integer id, @RequestBody Compras c) {
        Compras compras = comprasService.findById(id);
        if (compras != null) {
            try {
                compras.setPvp(c.getPvp());
                compras.setUsuario(c.getUsuario());
                compras.setProducto(c.getProducto());

                return new ResponseEntity<>(comprasService.save(compras), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Compras> eliminarCompra(@PathVariable Integer id) {
        comprasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
