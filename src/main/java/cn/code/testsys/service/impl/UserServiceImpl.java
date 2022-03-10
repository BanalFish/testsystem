package cn.code.testsys.service.impl;

import cn.code.testsys.domain.User;
import cn.code.testsys.mapper.UserMapper;
import cn.code.testsys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByNameAndPass(String name, String password) {
        return userMapper.getByNameAndPass(name, password);
    }

    @Override
    public User selectById(Long userid) {
        return userMapper.selectById(userid);
    }
}
