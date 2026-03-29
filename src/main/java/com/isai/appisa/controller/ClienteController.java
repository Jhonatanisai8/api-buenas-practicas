package com.isai.appisa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ICliente clienteService;

    @RequestMapping(method = RequestMethod.POST)
    public Cliente guardarCliente(Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @RequestMapping(path = "/{idCliente}", method = RequestMethod.DELETE)
    public void eliminarCliente(@PathVariable Long idCliente) {
        Cliente clienteEliminar = clienteService.obtenerClientePorId(idCliente);
        clienteService.eliminarCliente(clienteEliminar);
    }

    @RequestMapping(path = "/{idCliente}", method = RequestMethod.GET)
    public Cliente obtenerCClientePorID(@PathVariable Long idCliente) {
        return clienteService.obtenerClientePorId(idCliente);
    }

}
