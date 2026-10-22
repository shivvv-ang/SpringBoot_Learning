package com.springBoot.AopDemo.Dao;
import com.springBoot.AopDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoimpl implements AccountDao {

    @Override
    public void addAccount(Account account , boolean vipFlag) {

        System.out.println(getClass() +"Adding An Account");

    }

    @Override
    public boolean doSomething() {
        System.out.println(getClass() +"doSomething");
        return false;
    }
}
