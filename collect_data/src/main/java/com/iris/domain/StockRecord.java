package com.iris.domain;

import lombok.Data;

@Data
public class StockRecord {
    public double last_day_final_point;
    public double today_start_point;
    public String date;
    public String timeNow;

    @Override
    public String toString() {
        return "StockRecord{" +
                "last_day_final_point=" + last_day_final_point +
                ", today_start_point=" + today_start_point +
                ", date='" + date + '\'' +
                ", timeNow='" + timeNow + '\'' +
                '}';
    }
}
