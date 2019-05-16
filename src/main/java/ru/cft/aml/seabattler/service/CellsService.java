package ru.cft.aml.seabattler.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CellsService {

    Boolean checkCell(Integer x, Integer y);

    void initCells(List<List<Integer>> cells);

}
