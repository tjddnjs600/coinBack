package com.trading.coin.chart.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketVo {
    private String market;
    private String trade_date;
    private String trade_time;
    private String trade_date_kst;
    private String trade_time_kst;
    private String trade_timestamp;
    private String opening_price;
    private String high_price;
    private String low_price;
    private String trade_price;
    private String prev_closing_price;
    private String charge;
    private String change_price;
    private String change_rate;
    private String signed_change_price;
    private String signed_change_rate;
    private String trade_volume;
    private String acc_trade_price;
    private String acc_trade_price_24h;
    private String acc_trade_volume;
    private String acc_trade_volume_24h;
    private String highest_52_week_price;
    private String highest_52_week_date;
    private String lowest_52_week_price;
    private String lowest_52_week_date;
    private String timestamp;
}
