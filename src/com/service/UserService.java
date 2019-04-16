package com.service;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserService
 */

import com.dao.UserDao;
import com.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


//业务层
@Service
public class UserService {

  //Resource 通过byName赋值，  autowire的通过byType赋值
@Resource
    private UserDao userDao;


       public void add(User user){
        userDao.add(user);
    }

    public void update(User user){
           userDao.update(user);
    }

    public void delete(int id){
           userDao.delete(id);
    }

    public void queryAll(){
           userDao.queryAll();
    }
    public void queryResult(){
           userDao.queryResult();
    }

}
