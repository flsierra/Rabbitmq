package com.makaia.back4.Comments.Publisher;

import com.makaia.back4.Comments.entities.Comentario;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class PublisherComments {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private QueueComent queuecom;
    public void send(Long id){
        this.rabbitTemplate.convertAndSend(queuecom.getName(),id);
    }

}
