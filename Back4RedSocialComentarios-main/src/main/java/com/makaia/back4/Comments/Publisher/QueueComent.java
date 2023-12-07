package com.makaia.back4.Comments.Publisher;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;

public class QueueComent extends Queue {
    public QueueComent(String name) {
        super(name);
    }
}
