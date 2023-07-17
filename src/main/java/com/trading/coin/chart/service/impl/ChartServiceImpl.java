package com.trading.coin.chart.service.impl;

import com.trading.coin.chart.dao.MarketDao;
import com.trading.coin.chart.service.ChartService;
import com.trading.coin.chart.vo.CandleVo;
import com.trading.coin.chart.vo.MarketVo;
import com.trading.coin.util.ApiUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ChartServiceImpl implements ChartService {

    private MarketDao marketDao;

    private ApiUtil apiUtil;

    @Override
    public int insertMarket() {

        List<Map<String, String>> list = this.apiUtil.getMarketList().stream()
                                        .filter(nm -> nm.get("market").contains("KRW")).collect(Collectors.toList());

        log.info("listtt  : {}", list);
        return this.marketDao.insertMarket(list);
    }

    @Override
    public int insertMarketInfo(String marketNm) {
        return 0;
    }

    @Override
    public MarketVo selectMarketInfo(String marketNm) {
        return this.apiUtil.getMarketInfo(marketNm);
    }

    @Override
    public List<CandleVo> selectCandle(String marketNm, int cnt) {
        return this.apiUtil.getMarketCandles(marketNm, null, cnt, null);
    }
}
