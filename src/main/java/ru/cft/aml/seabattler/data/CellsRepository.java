package ru.cft.aml.seabattler.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cft.aml.seabattler.data.entity.Cell;

import java.util.Optional;

@Repository
public interface CellsRepository extends CrudRepository<Cell, Long> {
    Optional<Cell> findByXAndY(Integer x, Integer y);
}
