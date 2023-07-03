package com.trading.coin.controller;

import com.trading.coin.dao.TestDao;
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

    private TestDao testDao;

    @GetMapping("/seletTest")
    public List<Map<String, Object>> seletTest(){
        return this.testDao.selectTest();
    }
}
