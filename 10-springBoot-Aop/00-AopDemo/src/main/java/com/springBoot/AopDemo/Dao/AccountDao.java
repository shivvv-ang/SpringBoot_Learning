package com.springBoot.AopDemo.Dao;
import com.springBoot.AopDemo.Account;

public interface AccountDao {

    void addAccount(Account account , boolean vipFlag);

    boolean doSomething();
}
