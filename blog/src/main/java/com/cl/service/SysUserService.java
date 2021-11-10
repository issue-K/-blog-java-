package com.cl.service;

import com.cl.dao.pojo.SysUser;

public interface SysUserService {

    public SysUser findUserById(Long id);

    public SysUser findUser(String account, String pwd);
}
