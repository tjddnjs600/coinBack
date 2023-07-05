package com.trading.coin.chart.service;

import com.trading.coin.chart.vo.MarketVo;

public interface ChartService {
    int insertMarket();

    MarketVo selectMarketInfo(String marketNm);
}
