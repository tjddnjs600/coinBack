package com.trading.coin.chart.scheduler;

import com.trading.coin.chart.dao.MarketDao;
import com.trading.coin.chart.vo.MarketVo;
import com.trading.coin.util.ApiUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class MarketInfoScheduler {

    private MarketDao marketDao;

    /*@Scheduled(cron = "* 0/3 * * * *")
    public void getMarketInfoJob(){
        log.info("1번 "+Thread.currentThread().getName());

        List<MarketVo> list = new ArrayList<>();

        List<Map<String, String>> mrktList = this.marketDao.selectMarketList();

        mrktList.forEach(nm -> {
            MarketVo info = new MarketVo();
            try {
                info = ApiUtil.getMarketInfo(nm.get("MARKET"));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(ObjectUtils.isNotEmpty(info))
                list.add(info);
        });

        AtomicInteger cnt = new AtomicInteger();

        if(CollectionUtils.isNotEmpty(list)){
            list.forEach(info -> {
                cnt.addAndGet(this.marketDao.insertMarketInfo(info));
            });
        }

        log.info("1번 끄읏  : " + cnt.get());
    }*/


    @Scheduled(cron = "0 0 0/24 * * *")
    public void getMarketJob(){

        log.info("2번 start  "+Thread.currentThread().getName());

        List<Map<String, String>> resLsit = ApiUtil.getMarketList()
                .stream().filter(obj -> "KRW".contains(obj.get("market"))).collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(resLsit)){
            this.marketDao.insertMarket(resLsit);
        }

        log.info("2번 res  : {}",resLsit);
    }
}
