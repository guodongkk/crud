package com.dao;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: UserDao
 */

import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//持久层数据访问层DAO
@Repository("userDao")
public class UserDao {

@Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(User user){

        String sql="insert into user (username,password) values(?,?)";
        int i = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        System.out.println("添加成功"+i);
    }

    public void update(User user){
        String sql="update user set username=?,password=? where id=?";
        int i = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getId());
        System.out.println("修改成功"+i);
    }
    public void delete(int id){
        String sql="delete from user where id=?";
        int i = jdbcTemplate.update(sql, id);
        System.out.println("删除成功"+i);
    }

    public void queryAll(){
        String sql="select * from user ";
        List<User> list=new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                list.add(new User(id,username,password));
            }
        });
        System.out.println(list);
    }


    //jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class)) 有返回值list，不是query方法有返回值，也不需要提前建List<User>。
    public void queryResult(){
        String sql="select * from user";
//        List<User> list=new ArrayList<>();

        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
    }

}
