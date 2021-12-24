package com.example.mp.system.service.impl;

import com.example.mp.system.entity.Student;
import com.example.mp.system.mapper.StudentMapper;
import com.example.mp.system.service.StudentService;
import com.edz.commons.service.impl.ZCommonServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author edz
 * @since 2021-12-23
 */
@Service
public class StudentServiceImpl extends ZCommonServiceImpl<StudentMapper, Student> implements StudentService {

}
