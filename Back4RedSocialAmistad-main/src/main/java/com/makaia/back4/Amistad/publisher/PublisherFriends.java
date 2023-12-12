package com.makaia.back4.Amistad.publisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class PublisherFriends {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private QueueFriends queueFriends;
    public void send(Long idAmistad){
        this.rabbitTemplate.convertAndSend(queueFriends.getName(), idAmistad);
    }
}
