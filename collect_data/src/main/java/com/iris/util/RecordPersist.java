package com.iris.util;

import com.iris.domain.StockRecord;
import lombok.Data;

@Data
public class RecordPersist {
    /**
     * 持久化文件所在位置
     */
    private String persistFilePath;

    /**
     * 将record写入到文件
     * @param record
     */
    public void writeRecordToFile(StockRecord record) {
        //TODO
    }
}
