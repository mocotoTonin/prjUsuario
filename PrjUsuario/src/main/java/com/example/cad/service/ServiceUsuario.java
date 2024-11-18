package com.example.cad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cad.entities.Usuario;
import com.example.cad.repository.RepositoryUsuario;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuario {

    private final RepositoryUsuario repositoryusuario;

    @Autowired
    public ServiceUsuario(RepositoryUsuario repositoryusuario) {
        this.repositoryusuario = repositoryusuario;
    }

    public List<Usuario> buscaTodosUsuarios() {
        return repositoryusuario.findAll();
    }

    public Usuario buscaUsuarioId(Long id) {
        Optional<Usuario> usuario = repositoryusuario.findById(id);
        return usuario.orElse(null);
    }

    public Usuario salvaUsuario(Usuario usuario) {
        return repositoryusuario.save(usuario);
    }

    public Usuario alterarUsuario(Long id, Usuario alterarUsuario) {
        Optional<Usuario> existeUsuario = repositoryusuario.findById(id);
        if (existeUsuario.isPresent()) {
            alterarUsuario.setId(id);
            return repositoryusuario.save(alterarUsuario);
        }
        return null;
    }
    public boolean apagarUsuario(Long id) {
        Optional<Usuario> existeUsuario = repositoryusuario.findById(id);
        if (existeUsuario.isPresent()) {
        	repositoryusuario.deleteById(id);
            return true;
        }
        return false;
    }
}

