package com.trading.coin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {
    List<Map<String, Object>> selectTest();
}
