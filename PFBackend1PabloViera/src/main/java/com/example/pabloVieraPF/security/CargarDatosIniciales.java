package com.example.pabloVieraPF.security;

import com.example.pabloVieraPF.model.Usuario;
import com.example.pabloVieraPF.model.UsuarioRole;
import com.example.pabloVieraPF.repository.UsuarioRepository;
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
        BCryptPasswordEncoder cifradorAdmin = new BCryptPasswordEncoder();

        String passCifrada = cifrador.encode("1234");
        String passCifradaAdmin = cifradorAdmin.encode("12341234");

        Usuario usuario = new Usuario("Pablo", "pabloviera", "pablo@gmail.com", passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);

        Usuario usuarioAdmin = new Usuario("Pablo", "pabloviera", "pabloadmin@gmail.com", passCifradaAdmin, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuarioAdmin);
    }

}
