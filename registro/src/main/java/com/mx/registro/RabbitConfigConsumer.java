package com.mx.registro;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigConsumer {

    public final static String QUEUE_SAVE_USER = "queue-save-user";
    public final static String QUEUE_SAVE_ALL = "queue-save-all";

    @Bean
    Queue queue(){
        return new Queue(QUEUE_SAVE_USER);
    }

    @Bean
    Queue queue2(){
        return  new Queue(QUEUE_SAVE_ALL);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange-principal2");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(QUEUE_SAVE_USER);
    }

    @Bean
    Binding binding2(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(QUEUE_SAVE_ALL);
    }
}
