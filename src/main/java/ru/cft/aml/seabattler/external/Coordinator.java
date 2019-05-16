package ru.cft.aml.seabattler.external;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.cft.aml.seabattler.model.ActionResult;
import ru.cft.aml.seabattler.model.DamageData;
import ru.cft.aml.seabattler.model.PenaltyData;

import java.util.List;


@FeignClient(name = "coordinator")
@RestController
@RequestMapping("/api")
public interface Coordinator {


    @PostMapping("/online")
    List<String> online(@RequestParam("name") String name, @RequestParam("id") Integer id, @RequestParam("addr") String addr);

    @PostMapping("/start")
    ActionResult start(@RequestParam("id") Integer id);


    @PostMapping(value = "/report", consumes = "application/json")
    ActionResult damageReport(@RequestBody DamageData data, @RequestParam("id") Integer id);


    @PostMapping("/stop")
    ActionResult stopGame(@RequestParam("id") Integer id);


    @PostMapping(value = "/penalty", consumes = "application/json")
    ActionResult setPenalty(@RequestBody PenaltyData data, @RequestParam("id") Integer id);

}
