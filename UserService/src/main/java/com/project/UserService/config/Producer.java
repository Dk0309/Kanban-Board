//package com.project.UserService.config;
//
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.project.rabbitMQ.domain.UserDTO;
//
//@Component
//public class Producer {
//
//
//	private RabbitTemplate rabbitTemplate;
//    private DirectExchange directExchange;
//
//    @Autowired
//    public Producer(RabbitTemplate rabbitTemplate,DirectExchange directExchange)
//    {
//        this.directExchange = directExchange;
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void sendMessageToRabbitMQ(UserDTO userDTO)
//    {
//        rabbitTemplate.convertAndSend(directExchange.getName(),"userRouting",userDTO);
//    }
//}
