package com.iris.util.impl;

import com.iris.constant.CommonConstant;
import com.iris.domain.vo.ExecuteResult;
import com.iris.util.CmdExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: royalvald
 * @Date: 2022/6/18 9:48
 */
@Component
@Slf4j
public class CmdExecutorServiceImpl implements CmdExecutorService {
    @Override
    public ExecuteResult executeCommand(String cmd, Object... params) {
        Process process=null;
        InputStream pIn=null;
        InputStream pErr=null;
        try {

            String message = MessageFormatter.arrayFormat(cmd, params).getMessage();
            String[] commands = new String[]{CommonConstant.EXECUTE_SHELL, "-c", message};
            ProcessBuilder pb = new ProcessBuilder(commands);
            process = pb.start();
            process.waitFor();
            String utf8 = CommonConstant.CHARACTER_UTF_8;
            int exitCode = process.exitValue();
            pIn = process.getInputStream();
            pErr = process.getErrorStream();
            String executeOut = pIn.available() > 0 ? IOUtils.toString(pIn, utf8) : null;
            String executeError = pErr.available() > 0 ? IOUtils.toString(pErr, utf8) : null;
            log.info("command:{}, code:{}, out:{}, error:{}", new Object[]{message, exitCode, executeOut, executeError});
            return new ExecuteResult(exitCode, executeOut, executeError);
        }catch (Exception e){
            log.info("execute command {} error {}",cmd,e);
        }finally {
            this.closeQuietly(pIn);
            this.closeQuietly(pErr);
            if(process!=null){
                process.destroy();
            }
        }

        return null;
    }

    @Override
    public String getExecuteOut(String cmd, Object... params) {
        ExecuteResult result= this.executeCommand(cmd,params);
        return result==null?null:result.getExecuteOut();
    }

    @Override
    public String getExecuteError(String cmd, Object... params) {
        ExecuteResult result= this.executeCommand(cmd,params);
        return result==null?null:result.getExecuteError();
    }

    private void closeQuietly(Closeable closeable){
        if(closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                log.info("close {} failed",closeable.toString());
            }
        }
    }
}
