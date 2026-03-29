package com.isai.appisa.service;

import com.isai.appisa.models.entities.Cliente;

public interface ICliente {

    Cliente guardarCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long idCliente);

    void eliminarCliente(Cliente clienteEliminar);

}
