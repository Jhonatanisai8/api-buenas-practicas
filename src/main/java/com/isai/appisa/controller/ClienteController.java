package com.isai.appisa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(path = "/api/v1/clientes")
@RequiredArgsConstructor
@Tag(name = "Gestión de clientes", description = "Operaciones para administrar clientes en el sistema")
public class ClienteController {

    private final ICliente clienteService;

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        log.info("Guardando cliente: " + cliente.getApellido());
        return clienteService.guardarCliente(cliente);
    }

    @Operation(summary = "Actualizar un usuario existente")
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }                   

    @Operation(summary = "Eliminar un usuario existente")
    @DeleteMapping(path = "/{idCliente}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long idCliente) {
        Map<String, Object> errorResponse = new HashMap<>();
        try {
            Cliente clienteEliminar = clienteService.obtenerClientePorId(idCliente);
            clienteService.eliminarCliente(clienteEliminar);
            return new ResponseEntity<>(clienteEliminar, HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            log.error("Error al eliminar cliente: " + e.getMessage());
            errorResponse.put("error", e.getMessage());
            errorResponse.put("cliente", null);
            errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Obtener un usuario por ID")
    @GetMapping(path = "/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente obtenerCClientePorID(@PathVariable Long idCliente) {
        return clienteService.obtenerClientePorId(idCliente);
    }

}
