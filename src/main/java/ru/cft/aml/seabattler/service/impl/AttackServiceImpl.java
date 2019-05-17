package ru.cft.aml.seabattler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.aml.seabattler.data.CellsRepository;
import ru.cft.aml.seabattler.external.Enemy;
import ru.cft.aml.seabattler.model.AttackResult;
import ru.cft.aml.seabattler.model.Projectile;
import ru.cft.aml.seabattler.service.AttackService;

import java.util.Random;


@Service
public class AttackServiceImpl implements AttackService {

    private final Enemy enemy;

    private final CellsRepository repository;

    private final int min = 0;
    private final int max = 9;

    @Autowired
    public AttackServiceImpl(Enemy enemy, CellsRepository repository) {
        this.enemy = enemy;
        this.repository = repository;
    }

    @Override
    public void attackEnemy() {

        // TODO: Implement here

    }
}
