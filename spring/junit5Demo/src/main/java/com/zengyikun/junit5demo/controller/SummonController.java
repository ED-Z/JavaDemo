package com.zengyikun.junit5demo.controller;


import com.zengyikun.junit5demo.service.SummonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonController {

    @Autowired
    SummonService summonService;

    @GetMapping("/summon")
    public String summon(){
        return summonService.summonDragon();
    }

}
