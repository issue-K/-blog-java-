package com.cl.service.impl;

import com.cl.dao.mapper.SysUserMapper;
import com.cl.dao.pojo.SysUser;
import com.cl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById( id );
        if( sysUser==null ){
            sysUser = new SysUser();
            sysUser.setNickname("hhhhhhhhhhhhhhhhhhh");
        }
        return sysUser;
    }
}
