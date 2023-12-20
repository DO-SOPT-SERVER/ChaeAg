//package com.server.dosopt.seminar.config;
//
//import com.server.dosopt.seminar.config.jwt.CustomAccessDeniedHandler;
//import com.server.dosopt.seminar.config.jwt.CustomJwtAuthenticationEntryPoint;
//import com.server.dosopt.seminar.config.jwt.JwtAuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    private final CustomJwtAuthenticationEntryPoint customJwtAuthenticationEntryPoint;
//    private final CustomAccessDeniedHandler customAccessDeniedHandler;
//
//    private static final String[] AUTH_WHITELIST = {
//            "/sign-up",
//            "/sign-in"
//    };
//
//    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, CustomJwtAuthenticationEntryPoint customJwtAuthenticationEntryPoint, CustomAccessDeniedHandler customAccessDeniedHandler) {
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//        this.customJwtAuthenticationEntryPoint = customJwtAuthenticationEntryPoint;
//        this.customAccessDeniedHandler = customAccessDeniedHandler;
//    }
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .formLogin().disable()
//                .httpBasic().disable()
////                .sessionManagement()
////                .sessionCreationPolicy(STATELESS)
////                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(customJwtAuthenticationEntryPoint)
//                .accessDeniedHandler(customAccessDeniedHandler)
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers(AUTH_WHITELIST).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedOriginPatterns("*")
//                        .allowedMethods("*");
//            }
//        };
//    }
//}
