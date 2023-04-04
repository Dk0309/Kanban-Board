//package com.project.config;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.project.domain.User;
//import com.project.exception.UserAlreadyExistsException;
//import com.project.rabbitMQ.domain.UserDTO;
//import com.project.service.UserServiceImpl;
//
//@Component
//public class Consumer {
//
//	@Autowired
//    private UserServiceImpl userService;
//
//    @RabbitListener(queues = "userQueue")
//    public void getUserDTOFromRabbitMQ(UserDTO userDTO) throws UserAlreadyExistsException
//    {
//        User user = new User();
//        user.setEmail(userDTO.getEmail());;
//        user.setPassword(userDTO.getPassword());
//        userService.saveUser(user);
//    }
//}
