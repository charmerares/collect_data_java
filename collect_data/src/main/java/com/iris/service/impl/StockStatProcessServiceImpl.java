package com.iris.service.impl;

import com.iris.persist.RecordSaveService;
import com.iris.request.RecordRequest;

import com.iris.service.StockStatProcessService;
import com.iris.util.RequestBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.iris.constant.CollectModuleConstant.*;

@Component
public class StockStatProcessServiceImpl implements StockStatProcessService {
    @Autowired
    private RecordRequest recordRequest;
    @Autowired
    private RecordSaveService recordSaveService;

    public List<String> startCollectData() {
        List<String> resultList = startCollectStockDataByPrefixAndRange(STOCK_SHENZHEN_PREFIX,
                STOCK_REQUEST_START_INDEX_NUMBER_SZ, STOCK_REQUEST_END_INDEX_NUMBER_SZ);
        resultList.addAll(startCollectStockDataByPrefixAndRange(STOCK_SHENZHEN_PREFIX,
                STOCK_TEC_REQUEST_START_INDEX_NUMBER_SZ, STOCK_TEC_REQUEST_END_INDEX_NUMBER_SZ));
        resultList.addAll(startCollectStockDataByPrefixAndRange(STOCK_SHANGHAI_PREFIX,
                STOCK_REQUEST_START_INDEX_NUMBER_SH, STOCK_REQUEST_END_INDEX_NUMBER_SH));


        return resultList;
    }

    /**
     * collect data by prefix and int range
     *
     * @param stockPrefix
     * @param stockStartIndex
     * @param stockEndIndex
     * @return
     */
    private List<String> startCollectStockDataByPrefixAndRange(String stockPrefix, int stockStartIndex, int stockEndIndex) {
        List<String> resultStrings = new ArrayList<>();
        int temp_index = stockStartIndex;
        while (temp_index < stockEndIndex) {
            String temp_string = recordRequest.getRecordByStockNumber(RequestBuild.buildStockIdByIntNumber(temp_index),
                    stockPrefix);
            try {
                if (temp_string.length() > NULL_RESULT_STRING_LENGTH) {
                    resultStrings.add(temp_string);
                    System.out.println(temp_string);
                    recordSaveService.saveRecordStringToPath(temp_string, RECORD_SAVE_FILEPATH);
                }
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp_index++;
        }
        return resultStrings;
    }
}
