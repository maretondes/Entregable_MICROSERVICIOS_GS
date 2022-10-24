package com.mx.updatepassword.service;

import com.google.gson.Gson;
import com.mx.updatepassword.entity.Usuarios;
import com.mx.updatepassword.model.Request;
import com.mx.updatepassword.repository.UsuarioRepository;
import com.mx.updatepassword.service.async.UpdatePasswordProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePasswordService {

    private UsuarioRepository usuarioRepository;
    private UpdatePasswordProduce updatePasswordProduce;

    private Gson json = new Gson();

    public UpdatePasswordService(UsuarioRepository usuarioRepository, UpdatePasswordProduce updatePasswordProduce) {
        this.usuarioRepository = usuarioRepository;
        this.updatePasswordProduce = updatePasswordProduce;
    }

    public int updatePassword(Request request){
        int response =0;
        Usuarios user = new Usuarios();
        Usuarios userUpdate = new Usuarios();
        try {
            user = usuarioRepository.findByEmailAndPassword(request.getEmail(),request.getPassword());
            if(user != null){
                userUpdate.setPassword(request.getNewPassword());
                userUpdate.setId(user.getId());
                System.out.println("SE MANDA MENSAJE A PRODUCES DESDE SERVICE");
                updatePasswordProduce.sendMessage(json.toJson(userUpdate));
                response = 1;
            }else{
                response = 2;
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error "+e.getMessage());
        }
        return response;
    }
}
