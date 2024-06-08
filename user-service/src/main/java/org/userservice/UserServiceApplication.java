package org.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.userservice.entity.User;
import org.userservice.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            List<User> users = List.of(
                    new User("John Doe", "email@gmail.com", BCrypt.hashpw("password", BCrypt.gensalt()), "USER")
            );

            userRepository.saveAll(users);
        };
    }


}
