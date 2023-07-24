package com.trading.coin.chart.service.impl;

import com.trading.coin.chart.dao.MarketDao;
import com.trading.coin.chart.service.ChartService;
import com.trading.coin.chart.vo.CandleVo;
import com.trading.coin.chart.vo.MarketVo;
import com.trading.coin.util.ApiUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ChartServiceImpl implements ChartService {

    private MarketDao marketDao;

    @Override
    public List<Map<String, String>> selectMarketList() {
        return this.marketDao.selectMarketList();
    }

    @Override
    public MarketVo selectMarketInfo(String marketNm) {
        return ApiUtil.getMarketInfo(marketNm);
    }

    @Override
    public List<Map<String, Object>> selectCandle(String marketNm, int cnt, String moment, String minCnt) {

        List<CandleVo> resList = ApiUtil.getMarketCandles(marketNm, null, cnt, null, moment, minCnt);

        List<Map<String, Object>> list = new ArrayList<>();

        for ( CandleVo can : resList) {
            Map<String, Object> res = new HashMap<>();
            List<Long> canList = new ArrayList<>();
            canList.add(Math.round(Double.parseDouble(can.getOpening_price())));
            canList.add(Math.round(Double.parseDouble(can.getHigh_price())));
            canList.add(Math.round(Double.parseDouble(can.getLow_price())));
            canList.add(Math.round(Double.parseDouble(can.getTrade_price())));
            res.put("x", can.getCandle_date_time_kst());
            res.put("y", canList);

            list.add(res);
        }

        return list;
    }
}
