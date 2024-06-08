package org.taskservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.taskservice.dto.UserDto;

@FeignClient("user-service")
public interface APIClient {

    @GetMapping("/api/v1/users/{id}")
    UserDto getUserById(@PathVariable Integer id);
    
    @GetMapping("/api/v1/users/port")
    String getPort();
}
