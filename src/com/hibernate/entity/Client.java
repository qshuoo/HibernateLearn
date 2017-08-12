package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {
		
		/*
		//读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		//建立SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		//取得Session
		Session session = sf.openSession();
		//开启事务
		session.beginTransaction();
		//操作数据
		User user = new User("xm", "小明", "123");
		session.save(user);
		//提交事务
		session.getTransaction().commit();
		//关闭Session
		session.close();
		*/
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		
		session.beginTransaction();
		User user = new User("dm", "大明", "456");
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
