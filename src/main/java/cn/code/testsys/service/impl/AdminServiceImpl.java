package cn.code.testsys.service.impl;

import cn.code.testsys.domain.Course;
import cn.code.testsys.mapper.AdminMapper;
import cn.code.testsys.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Course> selectCour() {
        return adminMapper.selectCour();
    }
}
