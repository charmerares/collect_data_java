package com.iris.util;


import static com.iris.constant.CollectModuleConstant.SINA_RECORD_GET_ADDRESS_PREFIX;

public class RequestBuild {
    /**
     * 构造record请求体
     *
     * @param stockNumber
     * @return
     */
    public static String buildRecordRequestUrl(String stockNumber, String stockPrefix) {
        return (SINA_RECORD_GET_ADDRESS_PREFIX + stockPrefix + stockNumber).trim();
    }

    /**
     * transfer int to string
     * @param stockNumber
     * @return
     */
    public static String buildStockIdByIntNumber(int stockNumber){
        return String.format("%06d",stockNumber);
    }
}
