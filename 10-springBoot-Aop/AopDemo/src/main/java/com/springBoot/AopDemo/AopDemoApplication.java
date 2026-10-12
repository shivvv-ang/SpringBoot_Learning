package com.springBoot.AopDemo;
import com.springBoot.AopDemo.Dao.AccountDao;
import com.springBoot.AopDemo.Dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao , MembershipDao membershipDao) {
		return runner ->{

			demoBeforeAdvice(accountDao,membershipDao);

		};
	}

	private void demoBeforeAdvice(AccountDao accountDao,MembershipDao membershipDao) {

		Account account = new Account();

		accountDao.addAccount(account,true);
		accountDao.doSomething();

		membershipDao.addSillyMember();
		membershipDao.idk();

	}
}


