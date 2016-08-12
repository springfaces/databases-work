package com.caveofprogramming.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
		
		Offer updateOffer = new Offer(3, "Claire", "claire@test.com", "clair test");

			if(offersDao.update(updateOffer)) {
				System.out.println("Object updated");
			} else {
				System.out.println("Can not update..!");
			}
		try {
			List<Offer> offers = new ArrayList<Offer>();
			offers.add((new Offer(1, "Dave", "@email", "Dave programmer")));
			offers.add((new Offer(2, "Dave1", "@email", "Dave1 programmer")));
			offers.add((new Offer(3, "Dave2", "@email", "Dave12 programmer")));
			
			int [] rvals = offersDao.create(offers);
			for (int i : rvals) {
				System.out.println("updated : " + i + " rows");
			}

			/*Offer offer1 = new Offer("dave", "dave@raghu.com", "dave coding");
			Offer offer2 = new Offer("Karen", "dave@raghu.com", "testing coding");
			
			if(offersDao.create(offer1)) {
				System.out.println("Created offer object");
			}
			if(offersDao.create(offer2)) {
				System.out.println("Created offer object");
			}
			
			//offersDao.delete(1);
			List<Offer> offers = offersDao.getOffer();
			for (Offer offer : offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(1);
			System.out.println("offer :" + offer.toString());*/
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
