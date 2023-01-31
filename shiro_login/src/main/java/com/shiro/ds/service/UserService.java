package com.shiro.ds.service;

import com.shiro.ds.pojo.AccountUser;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;


public interface UserService {
    AccountUser getUserInfoByName(String username);
    LinkedList<Integer> findUserByName(String name);
}
