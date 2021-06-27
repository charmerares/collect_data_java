package com.iris.service.impl;

import com.iris.persist.RecordSaveService;
import com.iris.request.RecordRequest;

import com.iris.service.StockStatProcessService;
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
        List<String> resultStrings = new ArrayList<>();
        int temp_index = REQUEST_START_INDEX_NUMBER;
        while (temp_index <= REQUEST_END_INDEX_NUMBER) {
            String temp_string = recordRequest.getRecordByStockNumber(String.valueOf(temp_index));
            if (temp_string.length() > NULL_RESULT_STRING_LENGTH) {
                resultStrings.add(temp_string);
                System.out.println(temp_string);
                recordSaveService.saveRecordStringToPath(temp_string,RECORD_SAVE_FILEPATH);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            temp_index++;
        }
        return resultStrings;
    }
}
