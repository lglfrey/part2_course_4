package com.example.demo;

import com.example.demo.dao.GenericDAO;
import com.example.demo.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "userGenericDAO")
    public GenericDAO<User> userGenericDAO() {
        return new GenericDAO<>();
    }

    @Bean(name = "commentGenericDAO")
    public GenericDAO<Comment> commentGenericDAO() {
        return new GenericDAO<>();
    }

    @Bean(name = "friendshipGenericDAO")
    public GenericDAO<Friendship> friendshipGenericDAO() {
        return new GenericDAO<>();
    }

    @Bean(name = "messageGenericDAO")
    public GenericDAO<Message> messageGenericDAO() {
        return new GenericDAO<>();
    }
    @Bean(name = "postGenericDAO")
    public GenericDAO<Post> postGenericDAO() {
        return new GenericDAO<>();
    }

}
