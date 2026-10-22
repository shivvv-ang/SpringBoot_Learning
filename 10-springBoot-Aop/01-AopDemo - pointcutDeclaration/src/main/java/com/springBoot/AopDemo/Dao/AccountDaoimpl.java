package com.springBoot.AopDemo.Dao;
import com.springBoot.AopDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoimpl implements AccountDao {

    private String name;

    private String serviceCode;

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
}
