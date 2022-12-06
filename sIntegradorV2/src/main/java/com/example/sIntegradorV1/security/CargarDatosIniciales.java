package com.example.sIntegradorV1.security;

import com.example.sIntegradorV1.model.Usuario;
import com.example.sIntegradorV1.model.UsuarioRole;
import com.example.sIntegradorV1.repository.UsuarioRepository;
import com.example.sIntegradorV1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargarDatosIniciales implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public CargarDatosIniciales(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
        String passCifrada = cifrador.encode("1234");
        Usuario usuario = new Usuario("Pablo", "pabloviera", "pablo@gmail.com", passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
    }

}
