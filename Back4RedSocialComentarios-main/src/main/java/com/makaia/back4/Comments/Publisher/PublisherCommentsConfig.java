package com.makaia.back4.Comments.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherCommentsConfig {


    private String comment;
    @Bean
    public QueueComent queuecom() {
        return new QueueComent("comments_created");
    }


}
