package com.test;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: SpringTest
 */

import com.entity.User;
import com.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user=new User();

//       for(int i=0;i<5;i++){
//           User user=new User();
//           user.setId(i);
//           user.setUsername("admin"+i);
//           user.setPassword("admin"+i);
//           userService.add(user);
//       }
        user.setId(2);
        user.setUsername("aaa111");
        user.setPassword("aaa111");
//        userService.add(user);

     //  userService.update(user);
     //  userService.delete(1);

//        userService.queryAll();

        userService.queryResult();
    }


}
