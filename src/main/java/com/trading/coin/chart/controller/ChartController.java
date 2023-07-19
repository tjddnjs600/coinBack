package com.trading.coin.chart.controller;


import com.trading.coin.chart.service.ChartService;
import com.trading.coin.chart.vo.CandleVo;
import com.trading.coin.chart.vo.MarketVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/chart")
public class ChartController {

    private ChartService chartService;

    @GetMapping("/selectMarket")
    public List<Map<String, String>> selectMarket(){
        return this.chartService.selectMarketList();
    }

    @GetMapping("/selectMarketInfo/{marketNm}")
    public MarketVo selectMarketInfo(@PathVariable String marketNm){
        return this.chartService.selectMarketInfo(marketNm);
    }

    @GetMapping("/selectCandles/{marketNm}/{moment}")
    public List<CandleVo> selectCandle(@PathVariable String marketNm, @PathVariable String moment){
        return this.chartService.selectCandle(marketNm, 200);
    }
}
