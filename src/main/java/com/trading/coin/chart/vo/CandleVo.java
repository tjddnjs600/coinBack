package com.trading.coin.chart.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandleVo {
    private String market;
    private String candle_date_time_utc;
    private String candle_date_time_kst;
    private String opening_price;
    private String high_price;
    private String low_price;
    private String trade_price;
    private String timestamp;
    private String candle_acc_trade_price;
    private String candle_acc_trade_volume;
    private String first_day_of_period;
}
