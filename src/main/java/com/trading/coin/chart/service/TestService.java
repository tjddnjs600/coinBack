package com.trading.coin.chart.service;

import com.trading.coin.chart.dao.TestDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {

    private TestDao testDao;

    public List<Map<String, Object>> selectTest(){
        return this.testDao.selectTest();
    };
}
