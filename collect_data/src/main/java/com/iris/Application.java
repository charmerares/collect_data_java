package com.iris;

import com.iris.domain.StockRecord;
import com.iris.request.RecordRequest;
import com.iris.service.RecordProcessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
//        RecordProcessService recordProcessService=new RecordProcessServiceImpl();
//        StockRecord record = recordProcessService.getRecordByStockNumber("sz002307");
//        System.out.println(record);
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        RecordProcessService recordRequest = (RecordProcessService)context.getBean("recordProcessServiceImpl");
        StockRecord record = recordRequest.getRecordByStockNumber("sz002307");
        System.out.println(record);
    }
}
