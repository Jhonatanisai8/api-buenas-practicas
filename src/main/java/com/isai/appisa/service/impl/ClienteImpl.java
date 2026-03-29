package com.isai.appisa.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.isai.appisa.models.dao.ClienteDao;
import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteImpl implements ICliente {

    private final ClienteDao clienteDao;

    @Override
    public void eliminarCliente(UUID idCliente) {
        clienteDao.deleteById(idCliente);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteDao.save(cliente);

    }

    @Override
    public Cliente obtenerClientePorId(UUID idCliente) {
        return clienteDao.findById(idCliente).orElseThrow();
    }

}
