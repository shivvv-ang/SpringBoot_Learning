package com.springBoot.AopDemo.Dao;
import com.springBoot.AopDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoimpl implements AccountDao {

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account account , boolean vipFlag) {

        System.out.println(getClass() +"Adding An Account");

    }

    @Override
    public boolean doSomething() {
        System.out.println(getClass() +"doSomething");
        return false;
    }

    public String getName() {
        System.out.println(getClass() +"getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() +"setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() +"getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() +"setServiceCode");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("idk bro");
        }

        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("john","silver");
        Account account2 = new Account("undertaker","gold");
        Account account3 = new Account("chimpanzee","platinum");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return  accounts;

    }
}
