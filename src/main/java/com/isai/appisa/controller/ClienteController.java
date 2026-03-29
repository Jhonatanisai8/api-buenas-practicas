package com.isai.appisa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ICliente clienteService;

    @RequestMapping(method = RequestMethod.POST)
    public Cliente guardarCliente(Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @RequestMapping(method=RequestMethod.GET)
    public void eliminraCliente() {
    
    }
    
}
