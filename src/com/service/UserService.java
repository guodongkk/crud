package com.service;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserService
 */

import com.dao.UserDao;
import com.entity.User;
import com.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


//业务层
@Service
public class UserService {



  //Resource 通过byName赋值，  autowire的通过byType赋值
@Resource
    private UserDao userDao;

@Autowired
private TransactionUtil transaction;

       public void add(User user){

           TransactionStatus begin = null;
           try {
               begin = transaction.begin();
               userDao.add(user);
               System.out.println(1/0);
               transaction.commit(begin);
           } catch (Exception e) {
               e.printStackTrace();
               transaction.rollback(begin);
           }



    }

   public void add01(User user){
           userDao.add(user);
         //在service层不要捕捉异常，异常交给controller解决
//       System.out.println(1/0);

   }

   public void add02(User user){
       System.out.println("UserService...add02");
       userDao.add(user);
       System.out.println(1/0);

   }

   public void add03(User user){
       System.out.println("UserService...add03");
       userDao.add(user);
       System.out.println(1/0);

   }
@Transactional
    public void add04(User user){
        System.out.println("UserService...add04");
        userDao.add(user);
        System.out.println(1/0);
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
