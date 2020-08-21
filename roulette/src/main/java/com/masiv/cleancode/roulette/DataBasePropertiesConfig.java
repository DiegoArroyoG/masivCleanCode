package com.masiv.cleancode.roulette;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource("classpath:database.properties")
})

public class DataBasePropertiesConfig {
}