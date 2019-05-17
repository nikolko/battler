package ru.cft.aml.seabattler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.aml.seabattler.data.CellsRepository;
import ru.cft.aml.seabattler.data.entity.Cell;
import ru.cft.aml.seabattler.model.AttackResult;
import ru.cft.aml.seabattler.model.CellModel;
import ru.cft.aml.seabattler.service.CellsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CellsServiceImpl implements CellsService {

    private final CellsRepository repository;

    @Autowired
    public CellsServiceImpl(CellsRepository repository) {
        this.repository = repository;
    }

    @Override
    public AttackResult checkCell(Integer x, Integer y) {
        AttackResult r = new AttackResult();
        r.setX(x);
        r.setY(y);
        Optional<Cell> opt = repository.findByXAndYAndSelfIsTrue(x, y);

        if (opt.isPresent()) {
            Cell c = opt.get();
            if (c != null) {
                if (c.getDamaged()) {
                    r.setDamage(false);
                } else {
                    r.setDamage(true);
                    c.setDamaged(true);
                    repository.save(c);
                }
            }
        } else {
            r.setDamage(false);
        }

        return r;
    }

    @Override
    public void initCells(List<CellModel> cells) {
        repository.deleteAll();
        repository.saveAll(cells.stream().map(
                v -> {
                    Cell c = new Cell();
                    c.setSelf(true);
                    c.setDamaged(false);
                    c.setX(v.getX());
                    c.setY(v.getY());
                    return c;
                }
        )
        .collect(Collectors.toList()));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                Cell c = new Cell();
                c.setSelf(false);
                c.setDamaged(false);
                c.setY(j);
                c.setX(i);
                repository.save(c);
            }
        }
    }

    @Override
    public Boolean noMoreCells() {
        return repository.countByDamagedIsFalseAndSelfIsTrue() == 0;
    }
}
