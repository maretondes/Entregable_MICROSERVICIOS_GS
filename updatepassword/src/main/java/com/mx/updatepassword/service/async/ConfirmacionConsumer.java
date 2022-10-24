package com.mx.updatepassword.service.async;

import com.google.gson.Gson;
import com.mx.updatepassword.RabbitConfigConsumer;
import com.mx.updatepassword.entity.Usuarios;
import com.mx.updatepassword.repository.UsuarioRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmacionConsumer {

    @Autowired
    UsuarioRepository usuarioRepository;
    private Gson json = new Gson();


    //QUEUE_ADMINISTRACION_AUTORIZACION--bueno
    @RabbitListener(queues = RabbitConfigConsumer.QUEUE_ADMINISTRACION_AUTORIZACION)
    public void listaConsumo(Message message){
        String body = new String(message.getBody());

        Usuarios users = json.fromJson(body,Usuarios.class);
        usuarioRepository.updatePassword(users.getId(), users.getPassword());
        System.out.println("SE CONSUME LA COLA CON BODY: "+body);
    }
}
