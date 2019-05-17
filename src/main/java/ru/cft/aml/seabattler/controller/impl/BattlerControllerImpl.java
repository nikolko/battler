package ru.cft.aml.seabattler.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        StringBuilder b = new StringBuilder();
        e.printStackTrace();
        for (int i = 0; i < e.getStackTrace().length; i++) {
            b.append(e.getStackTrace()[i]).append("\n");
        }
        PenaltyData d = new PenaltyData();
        d.setErrTrace(b.toString());
        coordinator.setPenalty(d, wrapper.playgroundId);
    }


    @Override
    @PostMapping(value = "fire",  consumes = "application/json")
    public AttackResult fire(@RequestBody Projectile projectile) {
        AttackResult r = this.cellsService.checkCell(projectile.getX(), projectile.getY());
        DamageData report = new DamageData();

        report.setX(r.getX());
        report.setY(r.getY());
        report.setShooted(r.getDamage());
        coordinator.damageReport(report, wrapper.playgroundId);
        return r;
    }


    @Override
    @PostMapping(value = "init", consumes = "application/json")
    public ActionResult initPlayer(@RequestBody List<CellModel> cells) {

        this.cellsService.initCells(cells);

        return new ActionResult();
    }

    @Override
    @PostMapping("run")
    public ActionResult run() {
        attackService.attackEnemy();
        return new ActionResult();
    }
}
