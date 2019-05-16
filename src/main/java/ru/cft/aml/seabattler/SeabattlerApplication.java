package ru.cft.aml.seabattler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.cft.aml.seabattler.conf.ConfigWrapper;
import ru.cft.aml.seabattler.external.Coordinator;

import java.net.UnknownHostException;

@SpringBootApplication
public class SeabattlerApplication {


    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(SeabattlerApplication.class, args);
        Coordinator cord = (Coordinator) context.getBean("coordinator");
        ConfigWrapper w = context.getBean(ConfigWrapper.class);
        cord.online(w.teamName, w.playgroundId, w.selfAddr);

    }
}
