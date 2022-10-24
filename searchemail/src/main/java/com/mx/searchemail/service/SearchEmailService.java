package com.mx.searchemail.service;

import com.mx.searchemail.entity.Usuarios;
import com.mx.searchemail.model.Request;
import com.mx.searchemail.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchEmailService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public String searchEmail(Request request){
        String response = "false";
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            usuarios = usuariosRepository.findByEmail(request.getGmail());
            if(usuarios.size() > 0){
                response = "true";
            }else{
                response = "false";
            }

        }catch (Exception e){
            System.out.println("Ocurrio un error "+ e.getMessage());
        }
        return response;
    }
}
