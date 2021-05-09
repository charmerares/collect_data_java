package com.iris.util;

import com.iris.domain.StockRecord;
import org.apache.commons.lang.StringUtils;

public class RecordParse {
    /**
     * string信息转化为StockRecord数据类型
     * @param responseString
     * @return
     */
    public static StockRecord parseRecordFromResponseString(String responseString) {
        if (StringUtils.isEmpty(responseString)) {
            return null;
        }
        String[] recordItems=responseString.split(",");
        StockRecord record=new StockRecord();
        record.today_start_point=Double.parseDouble(recordItems[1]);
        record.last_day_final_point=Double.parseDouble(recordItems[2]);
        record.date=recordItems[recordItems.length-3];
        record.timeNow=recordItems[recordItems.length-2];

        return record;
    }
}
