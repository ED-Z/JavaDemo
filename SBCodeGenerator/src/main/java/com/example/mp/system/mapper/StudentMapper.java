package com.example.mp.system.mapper;

import com.example.mp.system.entity.Student;
import com.edz.commons.mapper.ZCommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author edz
 * @since 2021-12-23
 */
@Mapper
public interface StudentMapper extends ZCommonMapper<Student> {

}
