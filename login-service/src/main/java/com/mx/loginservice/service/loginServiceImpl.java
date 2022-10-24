package com.mx.loginservice.service;

import com.mx.loginservice.entity.Usuarios;
import com.mx.loginservice.model.LoginDTO;
import com.mx.loginservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public int login(LoginDTO request) {
        int response =0;

        try {
            Usuarios usuarios= usuarioRepository.findByUsuarioAndPassword(request.getUsuario(),request.getPassword());
            if(usuarios != null){
                response = 1;
            }
        }catch (Exception e){
            System.out.println("Error en login service "+e.getMessage());
        }
        return response;
    }
}
