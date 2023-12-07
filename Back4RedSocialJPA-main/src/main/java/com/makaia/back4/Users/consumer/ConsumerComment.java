package com.makaia.back4.Users.consumer;

import com.makaia.back4.Users.entities.Comentario;
import com.makaia.back4.Users.entities.Usuario;
import com.makaia.back4.Users.services.UsuarioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComment {
    @Autowired
    UsuarioService usuarioService;
    @RabbitListener(queues = {"comments_created"})
    public void receivenotify(@Payload Long id){
        System.out.println("El usuario "+ id+ "comento su publicación");
    }

}
