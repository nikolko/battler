package ru.cft.aml.seabattler.conf;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cft.aml.seabattler.external.Coordinator;
import ru.cft.aml.seabattler.external.Enemy;

@Configuration
@EnableFeignClients
public class ExternalClientConfiguration {

    @Value("${app.enemy-url}")
    private String enemyUrl;

    @Value("${app.coordinator-url}")
    private String coordinatorUrl;

    private Feign.Builder getBuilder() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL);
    }

    @Bean("enemy")
    public Enemy getEnemy() {
        return getBuilder().target(Enemy.class, enemyUrl);
    }

    @Bean("coordinator")
    public Coordinator getCoordinator() {
        return getBuilder().target(Coordinator.class, coordinatorUrl);
    }

}
