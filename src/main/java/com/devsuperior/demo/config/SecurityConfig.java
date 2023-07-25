package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); //Essa configucao disabilita a protecao csrf, pois nao sera guardado
        //secao de acesso no sistemam
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        //Essa configuracao permite que qualquer requisicao que seja feita neste servidor seja aceita
        return http.build();
    }

}

