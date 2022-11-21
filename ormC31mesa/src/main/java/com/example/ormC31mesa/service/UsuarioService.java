package com.example.ormC31mesa.service;

import com.example.ormC31mesa.entity.Usuario;
import com.example.ormC31mesa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerListaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarUsuario(Integer id){
        return usuarioRepository.findById(id);
    }

}
