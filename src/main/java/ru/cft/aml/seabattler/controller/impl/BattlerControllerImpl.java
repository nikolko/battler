package ru.cft.aml.seabattler.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.aml.seabattler.conf.ConfigWrapper;
import ru.cft.aml.seabattler.controller.BattlerController;
import ru.cft.aml.seabattler.external.Coordinator;
import ru.cft.aml.seabattler.model.*;
import ru.cft.aml.seabattler.service.AttackService;
import ru.cft.aml.seabattler.service.CellsService;

import java.util.List;

@RestController
@RequestMapping("api")
public class BattlerControllerImpl implements BattlerController {


    private final ConfigWrapper wrapper;
    private final Coordinator coordinator;
    private final CellsService cellsService;
    private final AttackService attackService;


    @Autowired
    public BattlerControllerImpl(ConfigWrapper wrapper, Coordinator coordinator, CellsService cellsService, AttackService attackService) {
        this.wrapper = wrapper;
        this.coordinator = coordinator;
        this.cellsService = cellsService;
        this.attackService = attackService;
    }

    @ExceptionHandler(Exception.class)
    public void handle(Exception e) {
        e.printStackTrace();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < e.getStackTrace().length; i++) {
            b.append(e.getStackTrace()[i]).append("\n");
        }
        PenaltyData d = new PenaltyData();
        d.setErrTrace(b.toString());
        coordinator.setPenalty(d, wrapper.playgroundId);
    }


    @Override
    @PostMapping("fire")
    public AttackResult fire(Projectile projectile) {
        return null;
    }


    @Override
    public ActionResult initPlayer(List<CellModel> cells) {

        return new ActionResult();
    }

    @Override
    public ActionResult run() {
        attackService.attackEnemy();
        return new ActionResult();
    }
}
