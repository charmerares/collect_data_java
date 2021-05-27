package com.iris.domain;

import lombok.Data;

@Data
public class StockRecord {

    private String recordId;
    private double lastDayFinalPoint;
    private double todayStartPoint;
    private String date;
    private String timeNow;

    @Override
    public String toString() {
        return "StockRecord{" +
                "recordId='" + recordId + '\'' +
                ", lastDayFinalPoint=" + lastDayFinalPoint +
                ", todayStartPoint=" + todayStartPoint +
                ", date='" + date + '\'' +
                '}';
    }
}
