package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {
		
		/*
		//��ȡhibernate.cfg.xml�ļ�
		Configuration cfg = new Configuration().configure();
		//����SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		//ȡ��Session
		Session session = sf.openSession();
		//��������
		session.beginTransaction();
		//��������
		User user = new User("xm", "С��", "123");
		session.save(user);
		//�ύ����
		session.getTransaction().commit();
		//�ر�Session
		session.close();
		*/
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		
		session.beginTransaction();
		User user = new User("dm", "����", "456");
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
