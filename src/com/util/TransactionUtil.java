package com.util;/*
 * @author :张
 * Date  : 2019/4/16
 * @Description: TransactionUtil
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component  //除了dao层，service层，controller层的类，使用该注解
public class TransactionUtil {

    @Autowired  //通过byType 注入
    private DataSourceTransactionManager txManager;


    //事务开启
    public TransactionStatus begin(){
        TransactionStatus transaction = txManager.getTransaction(new DefaultTransactionDefinition());
        return transaction;

    }
//事务提交
    public void commit(TransactionStatus transaction){
     txManager.commit(transaction);
    }

//事务回滚
    public void rollback(TransactionStatus transaction){
        txManager.rollback(transaction);

    }


}
