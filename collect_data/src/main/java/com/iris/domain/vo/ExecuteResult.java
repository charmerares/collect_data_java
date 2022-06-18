package com.iris.domain.vo;

import lombok.Data;

@Data
public class ExecuteResult {
    public ExecuteResult(int exitCode, String executeOut, String executeError) {
        this.exitCode = exitCode;
        this.executeOut = executeOut;
        this.executeError = executeError;
    }

    /**
     * command execute errorcode
     */
    int exitCode;
    /**
     * command execute out
     */
    String executeOut;
    /**
     * command execute error
     */
    String executeError;
}
