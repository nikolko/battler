package ru.cft.aml.seabattler.controller;


import org.springframework.web.bind.annotation.*;
import ru.cft.aml.seabattler.model.ActionResult;
import ru.cft.aml.seabattler.model.AttackResult;
import ru.cft.aml.seabattler.model.CellModel;
import ru.cft.aml.seabattler.model.Projectile;

import java.util.List;

@RestController
@RequestMapping("api")
public interface BattlerController {


    @PostMapping("fire")
    AttackResult fire(@RequestBody Projectile projectile);


    @PostMapping("init")
    ActionResult initPlayer(@RequestBody List<CellModel> cells);

    @PostMapping("run")
    ActionResult run();

}
