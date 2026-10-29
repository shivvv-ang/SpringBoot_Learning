package com.springBoot.AopDemo.Dao;
import com.springBoot.AopDemo.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAccounts();

    void addAccount(Account account , boolean vipFlag);

    boolean doSomething();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts(boolean tripWire);
}
