package com.isai.appisa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isai.appisa.models.dao.ClienteDao;
import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteImpl implements ICliente {

    private final ClienteDao clienteDao;

    @Override
    @Transactional
    public void eliminarCliente(Cliente clienteEliminar) {
        clienteDao.delete(clienteEliminar);
    }

    @Override
    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        return clienteDao.save(cliente);

    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerClientePorId(Long idCliente) {
        return clienteDao.findById(idCliente).orElse(null);
    }

}
