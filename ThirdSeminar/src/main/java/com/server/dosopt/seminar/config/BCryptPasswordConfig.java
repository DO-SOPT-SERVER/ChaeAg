package com.server.dosopt.seminar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BCryptPasswordConfig {

    // salt 할 때 보안 강도를 어느정도로 할지 설정
    // 높을수록 세지는데, 어느정도 높아지면 비슷함
    // default가 10
    private static final int STRENGTH = 10;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(STRENGTH);
    }
}
