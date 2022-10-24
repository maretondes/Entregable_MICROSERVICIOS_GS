package com.mx.registro.service;

import com.google.gson.Gson;
import com.mx.registro.client.SearchEmailClient;
import com.mx.registro.client.SearchUserClient;
import com.mx.registro.entity.Usuarios;
import com.mx.registro.model.RequestEmail;
import com.mx.registro.model.RequestUsuario;
import com.mx.registro.model.ResponseEmailDTO;
import com.mx.registro.model.registroDTO;
import com.mx.registro.repository.UsuariosRepository;
import com.mx.registro.service.async.SaveUserProduce;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class RegistroServiceImpl implements RegistroService{

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    SearchEmailClient searchEmailClient;

    @Autowired
    SearchUserClient searchUserClient;

    @Autowired
    SaveUserProduce saveUserProduce;

    private Gson json = new Gson();

    @Override
    public int guardar(registroDTO request) {
        RequestEmail requestEmail = new RequestEmail();
        RequestUsuario requestUsuario = new RequestUsuario();
        int response = 0;
        UUID uuid = UUID.randomUUID();
        try {
            Usuarios user = new Usuarios();
            user.setId(uuid.toString());
            user.setNombre(request.getNombre());
            user.setApellidoPaterno(request.getApellidoPaterno());
            user.setApellidoMaterno(request.getApellidoMaterno());
            user.setEmail(request.getGmail());
            user.setPassword(request.getPassword());
            user.setUsuario(request.getUsuario());

            requestEmail.setGmail(request.getGmail());
            requestUsuario.setUsuario(request.getUsuario());

            HashMap<String,String> responseEmailDTO = searchEmailClient.searchEmail(requestEmail);
            System.out.println("DATOS EMAIL \n"+ responseEmailDTO.toString());

            HashMap<String,Object> responseUsuarioDTO = searchUserClient.searchUser(requestUsuario);
            System.out.println("DATOS USUARIO \n"+ responseUsuarioDTO.toString());

            if(responseEmailDTO.get("Existe").equals("true")){
                response = 2;
            }else if(responseUsuarioDTO.get("Existe").equals(true)){
                response = 3;
            }else{
                System.out.println("SE MANDA MENSAJE A PRODUCES DESDE SERVICE");
                saveUserProduce.seandMessage(json.toJson(user));
                response = 1;
            }

            System.out.println("CODE DE RESPONSE || "+response);
           //usuariosRepository.save(user);
        }catch (Exception e){
            System.out.println("Error en el servicio guardar "+e.getMessage());
        }
        return response;
    }

    public void falloCliente(){
        System.out.println("Ocurrio un error en cliente");
    }
}
