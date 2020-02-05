package com.hhy.community.community.service;

import com.hhy.community.community.exception.CustomizeErrorCode;
import com.hhy.community.community.exception.CustomizeException;
import com.hhy.community.community.mapper.UserMapper;
import com.hhy.community.community.model.User;
import com.hhy.community.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhy1997
 * 2020/2/3
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0){
            //新建
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            //更新
            User updateUser = new User();
            updateUser.setToken(user.getToken());
            updateUser.setName(user.getName());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setGmtModified(System.currentTimeMillis());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(users.get(0).getId());
            int update = userMapper.updateByExampleSelective(updateUser, example);
            if (update == 0){
                throw new CustomizeException(CustomizeErrorCode.USER_NOT_FOUNT);
            }
        }
    }
}
