package com.makaia.back4.Amistad.publisher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherFriendsConfig {

    private String friend;
    @Bean
    public QueueFriends queueFriends(){
        return new QueueFriends("friends_created");
    }
}
