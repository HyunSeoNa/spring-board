package com.example.springboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 비밀번호 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // csrf 보안 해제
        http
                .csrf((csrf) -> csrf.disable());

        // 점근 경로별 인가 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/**").permitAll());

        // 로그인 방식 설정 : form 로그인 방식
        http
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
