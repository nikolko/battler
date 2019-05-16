package ru.cft.aml.seabattler.external;

import org.springframework.cloud.openfeign.FeignClient;
import ru.cft.aml.seabattler.controller.BattlerController;


@FeignClient(name = "enemy")
public interface Enemy// extends BattlerController
{
}
