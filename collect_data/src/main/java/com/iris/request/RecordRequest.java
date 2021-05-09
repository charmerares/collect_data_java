package com.iris.request;

public interface RecordRequest {
     /**
      * 根据股票ID获取股票涨幅情况
      * @param stockNumber
      * @return
      */
    String getRecordByStockNumber(String stockNumber);
}
