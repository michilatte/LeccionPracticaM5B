/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tap.m5b.proyectousuario.controller;

import com.tap.m5b.proyectousuario.model.Productos;
import com.tap.m5b.proyectousuario.service.ProductosServiceImpl;
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
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    ProductosServiceImpl productosService;

    @Operation(summary = "Obtener lista de productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Productos>> listaProductos() {
        return new ResponseEntity<>(productosService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Enviar los campos del productos")
    @PostMapping("/crear")
    public ResponseEntity<Productos> crearProducto(@RequestBody Productos p) {
        return new ResponseEntity<>(productosService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Integer id, @RequestBody Productos p) {
        Productos productos = productosService.findById(id);
        if (productos != null) {
            try {
                productos.setNombre(p.getNombre());
                productos.setDescripcion(p.getDescripcion());
                productos.setPrecio_emprendedor(p.getPrecio_emprendedor());
                productos.setImagen(p.getImagen());
                productos.setTalla(p.getTalla());
                productos.setColor(p.getColor());

                return new ResponseEntity<>(productosService.save(productos), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Productos> eliminarProducto(@PathVariable Integer id) {
        productosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
