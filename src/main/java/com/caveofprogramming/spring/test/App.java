package com.caveofprogramming.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		try {
			List<Offer> offers = offersDao.getOffer();
			for (Offer offer : offers) {
				System.out.println(offer);
			}
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
