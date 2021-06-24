package com.iris.persist;

public interface RecordSaveService {
    /**
     * save record to file
     * @param recordString
     * @param filepath
     * @return
     */
    boolean saveRecordStringToPath(String recordString,String filepath);
}
