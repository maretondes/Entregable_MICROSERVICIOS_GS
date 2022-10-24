package com.mx.searchuser.service;

import com.mx.searchuser.entity.Usuarios;
import com.mx.searchuser.model.Request;
import com.mx.searchuser.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchUserService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public boolean searchUsuario(Request request){
        boolean response = false;
        List<Usuarios> usuarios = new ArrayList<>();

        try {
            usuarios = usuariosRepository.findByUsuario(request.getUsuario());

            if(usuarios.size() > 0){
                response = true;
            }else{
                response = false;
            }

        }catch (Exception e){
            System.out.println("Ocurrio un Error "+ e.getMessage());
        }
        return response;
    }
}
