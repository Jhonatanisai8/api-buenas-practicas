package com.isai.appisa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/clientes")
@RequiredArgsConstructor
@Tag(name = "Gestión de clientes", description = "Operaciones para administrar clientes en el sistema")
public class ClienteController {

    private final ICliente clienteService;

    @Operation(summary = "Crear un nuevo usuario")
    @RequestMapping(method = RequestMethod.POST)
    public Cliente guardarCliente(Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @Operation(summary = "Actualizar un usuario existente")
    @RequestMapping(method = RequestMethod.PUT)
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @Operation(summary = "Eliminar un usuario existente")
    @RequestMapping(path = "/{idCliente}", method = RequestMethod.DELETE)
    public void eliminarCliente(@PathVariable Long idCliente) {
        Cliente clienteEliminar = clienteService.obtenerClientePorId(idCliente);
        clienteService.eliminarCliente(clienteEliminar);
    }

    @Operation(summary = "Obtener un usuario por ID")
    @RequestMapping(path = "/{idCliente}", method = RequestMethod.GET)
    public Cliente obtenerCClientePorID(@PathVariable Long idCliente) {
        return clienteService.obtenerClientePorId(idCliente);
    }

}
