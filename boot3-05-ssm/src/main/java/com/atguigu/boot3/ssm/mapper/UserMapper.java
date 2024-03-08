package com.atguigu.boot3.ssm.mapper;

import com.atguigu.boot3.ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author : chenyv
 * @since :  2024-03-08 10:42:22
 **/
public interface UserMapper {
    TUser getUserById(@Param("id") Long id);
}
