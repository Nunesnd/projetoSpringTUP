package com.webtup.SpringWeb.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.webtup.SpringWeb.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    
}
