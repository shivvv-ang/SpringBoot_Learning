package com.springBoot.AopDemo;
import com.springBoot.AopDemo.Dao.AccountDao;
import com.springBoot.AopDemo.Dao.MembershipDao;
import com.springBoot.AopDemo.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao , MembershipDao membershipDao , TrafficFortuneService trafficFortuneService) {
		return runner ->{

			//demoBeforeAdvice(accountDao,membershipDao);
			//demoAfterReturningAdvice(accountDao);
			//demoAfterThrowingAdvice(accountDao);
			//demoAfterAdvice(accountDao);
			//demoAroundAdvice(trafficFortuneService);
			demoAroundAdviceException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main program : demoAroundAdviceException");

		System.out.println("Calling getFortune()");

		boolean tripwire = true;

		String data = trafficFortuneService.getFortune(tripwire);

		System.out.println("fortune : " + data);

		System.out.println("Done !");

	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main program : demoAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("fortune : " + data);

		System.out.println("Done !");

	}

	private void demoAfterAdvice(AccountDao accountDao) {

		List<Account> theAccounts = null;

		try{

			boolean tripWire = false;

			theAccounts = accountDao.findAccounts(tripWire);

		}catch(Exception e){
			System.out.println("caught exception");

		}

		System.out.println("after throwing");
		System.out.println(theAccounts);

	}

	private void demoAfterThrowingAdvice(AccountDao accountDao) {

		List<Account> theAccounts = null;

		try{

			boolean tripWire = true;

			theAccounts = accountDao.findAccounts(tripWire);

		}catch(Exception e){
			System.out.println("caught exception");

		}

		System.out.println("after throwing");
		System.out.println(theAccounts);

	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {

        List<Account> theAccounts = accountDao.findAccounts();


		System.out.println("After returning accounts: " + theAccounts);

	}

	private void demoBeforeAdvice(AccountDao accountDao,MembershipDao membershipDao) {

		Account account = new Account();

		accountDao.addAccount(account,true);
		accountDao.doSomething();

		accountDao.setName("pikachu");
		accountDao.setServiceCode("idk what this would be honestly");

		String name  = accountDao.getName();
		String serviceCode = accountDao.getServiceCode();

		membershipDao.addSillyMember();
		membershipDao.idk();

	}
}


