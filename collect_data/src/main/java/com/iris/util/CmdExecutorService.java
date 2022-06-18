package com.iris.util;

import com.iris.domain.vo.ExecuteResult;

public interface CmdExecutorService {
    /**
     * 执行特定命令并返回执行结果
     * @param cmd
     * @param params
     * @return
     */
    ExecuteResult executeCommand(String cmd,Object... params);

    /**
     * 获取命令输出
     * @param cmd
     * @param params
     * @return
     */
    String getExecuteOut(String cmd,Object... params);

    /**
     * 获取命令的错误输出
     * @param cmd
     * @param params
     * @return
     */
    String getExecuteError(String cmd,Object... params);
}
