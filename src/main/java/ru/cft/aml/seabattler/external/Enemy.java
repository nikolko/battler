package ru.cft.aml.seabattler.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cft.aml.seabattler.model.AttackResult;
import ru.cft.aml.seabattler.model.Projectile;


@FeignClient(name = "enemy")
@RequestMapping("/api")
public interface Enemy {

    @PostMapping(value = "/fire?enemy=true", consumes = "application/json")
    AttackResult fire(@RequestBody  Projectile projectile);
}
