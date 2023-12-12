package com.makaia.back4.Amistad.publisher;

import org.springframework.amqp.core.Queue;

public class QueueFriends extends Queue {
    public QueueFriends(String name) {
        super(name);
    }
}
