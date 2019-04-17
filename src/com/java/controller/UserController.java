package com.java.controller;/*
 * @author :张
 * Date  : 2019/4/17
 * @Description: UserController
 */

import com.java.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static List<User> list=new ArrayList<>();

    static{
    list.add(new User(1,"aa11","aa11"));
    list.add(new User(2,"bb22","bb22"));
    list.add(new User(3,"cc33","cc33"));

    }

    @RequestMapping("/query")
   public String query(HttpServletRequest request , HttpServletResponse response, Model model){
        model.addAttribute("list",list);
       return "/user/list";
   }

   @RequestMapping(value = "/delete/{id}")
   public String delete(@PathVariable(name = "id") Integer id ){
        System.out.println("delete....."+id);
      User user=null;
      for(User u:list){
          if(u.getId().equals(id)){
              user=u;
              break;
          }
      }
      list.remove(user);
     return "redirect:/user/query";//重定向到userController下的query标识符的方法。
   }

   @RequestMapping(value="/toadd")
public String queryOne(){
       System.out.println("toadd....");
        return "forward:/WEB-INF/views/user/update.jsp"; //转发 全路径+.jsp

}



@RequestMapping(value = "/update/{id}")
public ModelAndView toupdate(@PathVariable(name = "id") Integer id){
    System.out.println("update..."+id);
   int index=-1;
    User user=null;
    for(User u:list){
        if(u.getId().equals(id)){
            user=u;
            break;
        }
    }
    ModelAndView mv=new ModelAndView("/user/update");
    mv.addObject("user",user);
    return mv;
}

@RequestMapping(value="/save")
public String add(User user){
    System.out.println("post...."+user);
 //获取集合最大索引位置的id, id+1是新添加user的id，给user添加找位置。
    Integer id = list.get(list.size() - 1).getId()+1;
    //如果传过来的user，id是空（interger 类型的默认值是null），表示是新添加的user。如果id不是空，表示传过来的user是原先集合中的user。
    if(user.getId()==null){
        user.setId(id);
        list.add(user);
    }
    else{
        int index=-1;
     //判断传递过来的user在list集合中的索引值，将索引值赋给index。
         for(int i=0;i<list.size();i++){
//             System.out.println(list.get(i).equals(user));
//             System.out.println(list.get(i));
             if(list.get(i).getId()==(user.getId())){
                 index=i;
                 System.out.println(index);
             }
         }
    //index不是-1，表示查到了user在集合中的索引值，修改索引位置上的user为传递过来的user。
        System.out.println(index);
         if(index!=-1){
            list.set(index,user);
         }
        }
    return "redirect:/user/query";
    }

}


