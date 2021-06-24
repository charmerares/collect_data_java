package com.iris;

import com.iris.domain.StockRecord;
import com.iris.request.RecordRequest;
import com.iris.service.RecordProcessService;
import com.iris.service.StockStatProcessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {
//        RecordProcessService recordProcessService=new RecordProcessServiceImpl();
//        StockRecord record = recordProcessService.getRecordByStockNumber("sz002307");
//        System.out.println(record);
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        StockStatProcessService recordRequest = (StockStatProcessService)context.getBean("stockStatProcessServiceImpl");
        List<String> strings = recordRequest.startCollectData();
        System.out.println(strings);
    }
}
