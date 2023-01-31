package com.shiro.ds.mapper;

import com.shiro.ds.pojo.AccountUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    AccountUser getUserInfo(String username);
}
