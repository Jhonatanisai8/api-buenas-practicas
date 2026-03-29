package com.isai.appisa.models.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isai.appisa.models.entities.Cliente;

@Repository
public interface ClienteDao
        extends CrudRepository<Cliente, Long> {

}
