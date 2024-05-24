package com.webtup.SpringWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webtup.SpringWeb.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    
   @Query(value="select * from administradores where email = :email and senha = :senha", nativeQuery = true)
   public Administrador Login(String email, String senha);
}
