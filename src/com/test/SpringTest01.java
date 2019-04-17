package com.test;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: SpringTest
 */

import com.entity.User;
import com.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring01.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user=new User();
        user.setId(1);
        user.setUsername("111");
        user.setPassword("111");
       userService.add(user);


    }


}
