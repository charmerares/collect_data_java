package com.iris.util;

import static com.iris.constant.CollectModuleConstant.SINA_RECORD_GET_ADDRESS;

public class RequestBuild {
    public static String buildRecordRequestUrl(String stockNumber) {
        return (SINA_RECORD_GET_ADDRESS + stockNumber).trim();
    }
}
