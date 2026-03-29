package com.isai.appisa.service;

import java.util.UUID;

import com.isai.appisa.models.entities.Cliente;

public interface ICliente {

    Cliente guardarCliente(Cliente cliente);

    Cliente obtenerClientePorId(UUID idCliente);

    void eliminarCliente(UUID idCliente);

}
