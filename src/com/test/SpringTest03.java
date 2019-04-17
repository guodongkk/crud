package com.test;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: SpringTest
 */

import com.entity.User;
import com.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest03 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring03.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user=new User();
        user.setUsername("222");
        user.setPassword("222");
       userService.add03(user);


    }


}
