package com.isai.appisa.service;

import com.isai.appisa.models.dtos.ClienteDTO;
import com.isai.appisa.models.entities.Cliente;

public interface ICliente {

    Cliente guardarCliente(ClienteDTO cliente);

    Cliente obtenerClientePorId(Long idCliente);

    void eliminarCliente(Cliente clienteEliminar);

}
