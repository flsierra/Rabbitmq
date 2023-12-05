package com.makaia.back4.JpaMySql.consumer;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.services.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    Service publicacionService;


    @RabbitListener(queues = {"user_created"}) // user_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload Long id){
        System.out.println("Crear una publicación para el usuario " + id);
   //     CrearDTO defaultP = new CrearDTO("Mi Primera Publicacion", "Contenido", id);
     //   this.publicacionService.crear(defaultP);
    }
        @RabbitListener(queues ={"comments_created"} )
        public void receivecomments(@Payload Long id){
            System.out.println("Crear un comentario para la publicación " + id);
        }
}
