package com.cl.service;

import com.cl.dao.vo.params.Result;
import com.cl.dao.vo.params.LoginParam;

public interface LoginService {
    /**
     * 登录
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);
}