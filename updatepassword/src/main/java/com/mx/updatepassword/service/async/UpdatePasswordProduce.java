package com.mx.updatepassword.service.async;

import com.mx.updatepassword.RabbitConfigConsumer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePasswordProduce {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    ConfirmacionConsumer confirmacionConsumer;

    public UpdatePasswordProduce(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String contractEvent){
        rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_ADMINISTRACION_AUTORIZACION, contractEvent);
        System.out.println("SE ENVIO EL MENSAJE A COLA ....");

    }
}
