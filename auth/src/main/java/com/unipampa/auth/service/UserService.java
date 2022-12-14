package com.unipampa.auth.service;

import com.unipampa.auth.entity.User;
import com.unipampa.auth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByUser(String user){
        User responseUser = userFeignClient.findByUsuario(user).getBody();
        if(responseUser == null){
            logger.error("Usuario nao encontrado: " + user);
            throw new IllegalArgumentException("Usuario nao encontrado");
        }
        logger.info("Usuario encontrado: " + user);
        return responseUser;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        User responseUser = userFeignClient.findByUsuario(user).getBody();
        if(responseUser == null){
            logger.error("Usuario nao encontrado: " + user);
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
        logger.info("Usuario encontrado: " + user);
        return responseUser;
    }
}
