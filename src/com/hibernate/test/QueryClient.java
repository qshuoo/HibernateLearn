package com.hibernate.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.entity.Manager;
import com.hibernate.entity.MySessionFactory;

public class QueryClient {
	

	

	@Test
	public void saveTest() {
		Session session = MySessionFactory.getSessionFactory().openSession(); 
		session.beginTransaction();
		Manager manager = new Manager();
		manager.setName("admin2");
		manager.setPwd("admin2");
		session.save(manager);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void deleteTest() {
		Session session = MySessionFactory.getSessionFactory().openSession(); 
		session.beginTransaction();
		Manager manager = session.find(Manager.class,2 );
		session.remove(manager);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void updateTest() {
		Session session = MySessionFactory.getSessionFactory().openSession(); 
		session.beginTransaction();
		Manager manager = session.find(Manager.class,3 );
		manager.setName("addddd");
		session.save(manager);
		session.getTransaction().commit();
		session.close();
	}
	
	

}
