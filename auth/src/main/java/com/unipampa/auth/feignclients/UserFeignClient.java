package com.unipampa.auth.feignclients;

import com.unipampa.auth.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "usuarios", url = "localhost:8080/usuarios", path = "/api/v1/Usuario")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity<User> findByUsuario(@RequestParam String usuario);
}
