package com.edz.commons.mapper;

import com.edz.commons.pojo.ZBaseObject;
import tk.mybatis.mapper.common.Mapper;

public interface ZCommonMapper<T extends ZBaseObject> extends Mapper<T> {
}
