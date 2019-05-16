package ru.cft.aml.seabattler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.aml.seabattler.data.CellsRepository;
import ru.cft.aml.seabattler.external.Enemy;
import ru.cft.aml.seabattler.service.AttackService;


@Service
public class AttackServiceImpl implements AttackService {

    private final Enemy enemy;

    private final CellsRepository repository;


    @Autowired
    public AttackServiceImpl(Enemy enemy, CellsRepository repository) {
        this.enemy = enemy;
        this.repository = repository;
    }

    @Override
    public void attackEnemy() {

    }
}
