package com.iris.util;

import static com.iris.constant.CollectModuleConstant.SINA_RECORD_GET_ADDRESS;

public class RequestBuild {
    /**
     * 构造record请求体
     * @param stockNumber
     * @return
     */
    public static String buildRecordRequestUrl(String stockNumber) {
        return (SINA_RECORD_GET_ADDRESS + stockNumber).trim();
    }
}
