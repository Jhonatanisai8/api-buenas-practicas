package com.isai.appisa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isai.appisa.models.dao.ClienteDao;
import com.isai.appisa.models.dtos.ClienteDTO;
import com.isai.appisa.models.entities.Cliente;
import com.isai.appisa.service.ICliente;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteImpl implements ICliente {

    private final ClienteDao clienteDao;

    @Override
    @Transactional
    public Cliente guardarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDTO.getIdCliente())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .correo(clienteDTO.getCorreo())
                .fechaRegistro(clienteDTO.getFechaRegistro())
                .build();
        return clienteDao.save(cliente);

    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerClientePorId(Long idCliente) {
        return clienteDao.findById(idCliente).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDTO.getIdCliente())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .correo(clienteDTO.getCorreo())
                .fechaRegistro(clienteDTO.getFechaRegistro())
                .build();
        clienteDao.delete(cliente);
    }

}
