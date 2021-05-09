package com.iris.service;

import com.iris.domain.StockRecord;

public interface RecordProcessService {
    StockRecord getRecordByStockNumber(String recordNumber);
}
