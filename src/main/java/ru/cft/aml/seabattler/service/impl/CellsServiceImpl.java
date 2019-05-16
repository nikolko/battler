package ru.cft.aml.seabattler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.aml.seabattler.data.CellsRepository;
import ru.cft.aml.seabattler.data.entity.Cell;
import ru.cft.aml.seabattler.service.CellsService;

import java.util.List;
import java.util.Optional;


@Service
public class CellsServiceImpl implements CellsService {

    private final CellsRepository repository;

    @Autowired
    public CellsServiceImpl(CellsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean checkCell(Integer x, Integer y) {

        Optional<Cell> opt = repository.findByXAndY(x, y);

        if (opt.isPresent()) {
            Cell c = opt.get();
            if (c.getNotEmpty()) {

            }
        }

        return false;
    }

    @Override
    public void initCells(List<List<Integer>> cells) {

        for (int i =  0; i < cells.size(); i++) {
            for(int j = 0; j < cells.get(i).size(); j++) {
                Cell c = new Cell();
                c.setX(cells.get(i).get(j));

            }
        }

    }
}
