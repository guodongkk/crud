package com.test;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: SpringTest
 */

import com.entity.User;
import com.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest02 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring02.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user=new User();

        user.setUsername("111");
        user.setPassword("111");
       userService.add02(user);


    }


}
