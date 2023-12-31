package com.trading.coin.util;

import com.trading.coin.chart.vo.CandleVo;
import com.trading.coin.chart.vo.MarketVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
public class ApiUtil {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static List<Map<String, String>> getMarketList(){

        String url = "https://api.upbit.com/v1/market/all";

        ResponseEntity<List<Map<String, String>>> res = restTemplate.exchange(url, HttpMethod.GET
                                                        , null, new ParameterizedTypeReference<List<Map<String, String>>>() {});
        log.info("res!!  : {}", res);

        List<Map<String, String>> resList = res.getBody();


        return resList;
    };

    public static MarketVo getMarketInfo(String marketNm){
        String url = "https://api.upbit.com/v1/ticker?markets=";

        ResponseEntity<List<MarketVo>> res = restTemplate.exchange(url + marketNm, HttpMethod.GET
                , null, new ParameterizedTypeReference<List<MarketVo>>() {});

        MarketVo resVo = res.getBody().get(0);

        log.info("resVo : {}",resVo);
        return resVo;
    }

    public static List<CandleVo> getMarketCandles(String market, String to, int cnt, String convert, String moment, String minCnt){
        String url = "";

        if("minutes".equals(moment)){
            url = "https://api.upbit.com/v1/candles/"+moment+"/"+minCnt+"?market="+market+"&count="+cnt;
        } else {
            url = "https://api.upbit.com/v1/candles/"+moment+"?market="+market+"&count="+cnt;
        }

        if(StringUtils.isNotEmpty(to))
            url += "&to="+to;

        if(StringUtils.isNotEmpty(convert))
            url += "&convertingPriceUnit=" + convert;

        ResponseEntity<List<CandleVo>> res = restTemplate.exchange(url, HttpMethod.GET
                , null, new ParameterizedTypeReference<List<CandleVo>>() {});

        log.info("resVo : {}",res.getBody());

        return res.getBody();
    }
}
