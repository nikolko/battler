package ru.cft.aml.seabattler.service;


import org.springframework.stereotype.Service;
import ru.cft.aml.seabattler.model.AttackResult;
import ru.cft.aml.seabattler.model.CellModel;

import java.util.List;

@Service
public interface CellsService {

    AttackResult checkCell(Integer x, Integer y);

    void initCells(List<CellModel> cells);

    Boolean noMoreCells();

}
