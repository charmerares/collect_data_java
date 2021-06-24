package com.iris.service.impl;

import com.iris.domain.StockRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.iris.request.RecordRequest;
import com.iris.service.RecordProcessService;
import com.iris.util.RecordParse;

@Component
public class RecordProcessServiceImpl implements RecordProcessService {
    @Autowired
    private RecordRequest recordRequest;
    public StockRecord getRecordByStockNumber(String recordNumber) {
        String recordString = recordRequest.getRecordByStockNumber(recordNumber);
        return RecordParse.parseRecordFromResponseString(recordString,recordNumber);
    }
}
