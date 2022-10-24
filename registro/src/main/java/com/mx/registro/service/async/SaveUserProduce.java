package com.mx.registro.service.async;

import com.mx.registro.RabbitConfigConsumer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SaveUserProduce {

    private RabbitTemplate rabbitTemplate;

    public SaveUserProduce(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void seandMessage(String contractEvent){
        rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_SAVE_USER, contractEvent);
        System.out.println("SE ENVIO EL MENSAJE A COLA ....");
    }
}
