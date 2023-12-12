package com.makaia.back4.Users.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class ConsummerFriend {
    @RabbitListener(queues = "friends_created")
    public void receivenotifyFriends(@Payload Long id){
        System.out.println("Se ha creado una amistada "+ id);
    }
}
