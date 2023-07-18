package com.trading.coin.chart.dao;

import com.trading.coin.chart.vo.MarketVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MarketDao {
    List<Map<String, String>> selectMarketList();

    int insertMarket(List<Map<String, String>> param);

    int insertMarketInfo(MarketVo marketVo);
}
