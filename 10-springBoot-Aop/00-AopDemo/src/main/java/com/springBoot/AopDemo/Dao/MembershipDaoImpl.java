package com.springBoot.AopDemo.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {
    @Override
    public boolean addSillyMember() {

        System.out.println(getClass() +"Adding An Account");

        return true;
    }

    @Override
    public void idk() {
        System.out.println(getClass() +"idk");
    }
}
