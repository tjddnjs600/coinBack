package com.trading.coin.chart.controller;

import com.trading.coin.chart.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    @GetMapping("/seletTest")
    public List<Map<String, Object>> seletTest(){
        return this.testService.selectTest();
    }
}
