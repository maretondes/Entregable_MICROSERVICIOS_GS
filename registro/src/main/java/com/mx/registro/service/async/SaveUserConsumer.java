package com.mx.registro.service.async;

import com.google.gson.Gson;
import com.mx.registro.RabbitConfigConsumer;
import com.mx.registro.entity.Usuarios;
import com.mx.registro.repository.UsuariosRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserConsumer {
    @Autowired
    UsuariosRepository usuariosRepository;

    private Gson json = new Gson();

    @RabbitListener(queues = RabbitConfigConsumer.QUEUE_SAVE_USER)
    public void listaConsumo(Message message){
        String body = new String(message.getBody());

        Usuarios user = json.fromJson(body, Usuarios.class);
        usuariosRepository.guardar(user.getId(), user.getNombre(),user.getApellidoPaterno(),
                user.getApellidoMaterno(),user.getEmail(), user.getPassword(),
                user.getUsuario());
        System.out.println("SE CONSUME LA COLA CON BODY: "+body);
    }
}
