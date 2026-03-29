package com.isai.appisa.models.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.isai.appisa.models.entities.Cliente;

public interface ClienteDao
        extends CrudRepository<Cliente, UUID> {

}
