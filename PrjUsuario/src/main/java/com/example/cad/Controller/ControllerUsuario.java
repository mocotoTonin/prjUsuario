package com.example.cad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cad.entities.Usuario;
import com.example.cad.service.ServiceUsuario;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    private final ServiceUsuario serviceusuario;

    @Autowired
    public ControllerUsuario(ServiceUsuario serviceusuario) {
        this.serviceusuario = serviceusuario;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscaUsuarioControlId(@PathVariable Long id) {
        Usuario usuario = serviceusuario.buscaUsuarioId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> buscaTodosUsuariosControl() {
        List<Usuario> usuarios = serviceusuario.buscaTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

	@PostMapping("/")
	public ResponseEntity<Usuario> salvaUsuariosControl(@RequestBody @Valid Usuario usuario) {
	    Usuario salvaUsuario = serviceusuario.salvaUsuario(usuario);
	    return ResponseEntity.status(HttpStatus.CREATED).body(salvaUsuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alteraUsuarioControl(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
	    Usuario alteraUsuario = serviceusuario.alterarUsuario(id, usuario);
	    if (alteraUsuario != null) {
	        return ResponseEntity.ok(alteraUsuario);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaUsuarioControl(@PathVariable Long id) {
	    boolean apagar = serviceusuario.apagarUsuario(id);
	    if (apagar) {
	        return ResponseEntity.ok().body("O Usuario foi excluido com sucesso");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}


