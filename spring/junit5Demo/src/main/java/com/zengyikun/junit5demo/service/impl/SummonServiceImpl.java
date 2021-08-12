package com.zengyikun.junit5demo.service.impl;

import com.zengyikun.junit5demo.service.SummonService;
import org.springframework.stereotype.Service;

@Service
public class SummonServiceImpl implements SummonService {
    @Override
    public String summonDragon() {
        return "你已集齐七龙珠，正在召唤神龙。";
    }
}
