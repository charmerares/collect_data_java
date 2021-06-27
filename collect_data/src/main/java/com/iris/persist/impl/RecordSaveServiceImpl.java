package com.iris.persist.impl;

import com.iris.persist.RecordSaveService;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class RecordSaveServiceImpl implements RecordSaveService {
    @Override
    public boolean saveRecordStringToPath(String recordString, String filepath) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(filepath,true));
            out.append(recordString);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }
}
