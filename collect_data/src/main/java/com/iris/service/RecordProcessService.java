package com.iris.service;

import com.iris.domain.StockRecord;

public interface RecordProcessService {
    /**
     * 从网站获取数据并转化为指定格式
     * @param recordNumber
     * @return
     */
    StockRecord getRecordByStockNumber(String recordNumber,String stockPrefix);

}
