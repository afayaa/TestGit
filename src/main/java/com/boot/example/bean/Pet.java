package com.boot.example.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ToString
@Data
@ConfigurationProperties(prefix = "person.pet")
public class Pet {
	private String name;
	private Double weight;

}
