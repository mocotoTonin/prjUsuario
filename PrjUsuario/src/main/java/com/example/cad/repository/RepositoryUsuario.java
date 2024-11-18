package com.example.cad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cad.entities.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
   
}

