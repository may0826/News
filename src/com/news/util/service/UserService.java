package com.news.util.service;

import com.news.util.pojo.NewsUser;

public interface UserService {
    //验证用户登录
    public boolean LoginUser(String username,String password);

    //注册功能
    public boolean register(NewsUser user);
}
