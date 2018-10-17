package com.cima.capacitacion.rest.data.controlador;

import java.util.ArrayList;
import java.util.List;

import com.cima.capacitacion.rest.data.repositorio.Usuario;
import com.cima.capacitacion.rest.data.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorDatos {

        @Autowired
        public UsuarioRepositorio usuarioRepositorio;

        @GetMapping("/usuario")
        public List<Usuario> getUsuarios() {
            return usuarioRepositorio.findAll();
        }


        @PostMapping(path="/usuario")
        public ResponseEntity<String>  insertarUsuarios( @RequestBody Usuario l) {
            usuarioRepositorio.save(l);
            return new ResponseEntity(HttpStatus.OK);
        }



}
