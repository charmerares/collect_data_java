package com.iris.util;

import com.iris.domain.StockRecord;
import org.apache.commons.lang.StringUtils;

public class RecordParse {
    /**
     * string信息转化为StockRecord数据类型
     * @param responseString
     * @return
     */
    public static StockRecord parseRecordFromResponseString(String responseString,String recordId) {
        if (StringUtils.isEmpty(responseString)) {
            return null;
        }
        String[] recordItems=responseString.split(",");
        StockRecord record=new StockRecord();
        record.setRecordId(recordId);
        record.setTodayStartPoint(Double.parseDouble(recordItems[1]));
        record.setLastDayFinalPoint(Double.parseDouble(recordItems[2]));
        record.setDate(recordItems[recordItems.length-3]);
        record.setTimeNow(recordItems[recordItems.length-2]);

        return record;
    }
}
