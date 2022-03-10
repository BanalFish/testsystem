package cn.code.testsys.service;

import cn.code.testsys.domain.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    User getByNameAndPass(@Param("name") String name, @Param("password") String password);

    User selectById(Long userid);
}
