package com.trading.coin.chart.service;

import com.trading.coin.chart.vo.CandleVo;
import com.trading.coin.chart.vo.MarketVo;

import java.util.List;

public interface ChartService {

    MarketVo selectMarketInfo(String marketNm);

    List<CandleVo> selectCandle(String marketNm, int cnt);
}
