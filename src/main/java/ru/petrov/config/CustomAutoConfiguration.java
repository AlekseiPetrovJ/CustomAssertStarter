package ru.petrov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.petrov.util.mapper.LogRowMapper;

@Configuration
public class CustomAutoConfiguration {
    @Bean
    public LogRowMapper logMapper(){
        return new LogRowMapper();
    }
}