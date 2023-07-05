package com.trading.coin.chart.controller;


import com.trading.coin.chart.service.ChartService;
import com.trading.coin.chart.vo.MarketVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/chart")
public class ChartController {

    private ChartService chartService;

    @GetMapping("/insertMarket")
    public int insertMarket(){
        return this.chartService.insertMarket();
    }

    @GetMapping("/selectMarketInfo/{marketNm}")
    public MarketVo selectMarketInfo(@PathVariable String marketNm){
        return this.chartService.selectMarketInfo(marketNm);
    }
}
