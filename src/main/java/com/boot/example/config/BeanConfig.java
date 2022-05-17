package com.boot.example.config;

import com.boot.example.bean.Person;
import com.boot.example.bean.Pet;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties({Person.class, Pet.class})
public class BeanConfig {

}
