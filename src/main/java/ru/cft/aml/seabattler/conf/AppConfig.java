package ru.cft.aml.seabattler.conf;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppConfig {


    @Value("${app.team-name}")
    private String teamName;



    @Value("${app.playground-id}")
    private Integer playgroundId;

    @Value("${app.self-addr}")
    private String addr;


    @Bean("configWrapper")
    public ConfigWrapper getConfig() {
        return  new ConfigWrapper(teamName, playgroundId, addr);
    }





}
