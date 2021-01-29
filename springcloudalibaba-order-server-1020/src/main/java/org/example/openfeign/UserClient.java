package org.example.openfeign;

import org.example.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-server")
public interface UserClient {
    @GetMapping("/user/{id}")
    User getById(@PathVariable Long id);
}