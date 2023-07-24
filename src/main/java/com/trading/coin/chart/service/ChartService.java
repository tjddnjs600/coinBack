package com.trading.coin.chart.service;

import com.trading.coin.chart.vo.CandleVo;
import com.trading.coin.chart.vo.MarketVo;

import java.util.List;
import java.util.Map;

public interface ChartService {

    List<Map<String, String>> selectMarketList();

    MarketVo selectMarketInfo(String marketNm);

    List<Map<String, Object>> selectCandle(String marketNm, int cnt, String moment, String minCnt);
}
