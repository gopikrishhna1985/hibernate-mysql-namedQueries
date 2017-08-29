package com.hibernate.startup;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NamedQueryApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("student_findByLastName");
		//Query query = session.getNamedQuery("student_findByFirstName");
		//Query query = session.getNamedQuery("student_findAgeGreaterThan");
		query.setString(0, "lastName3");

		List students = query.list();
		Iterator it = students.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

		session.getTransaction().commit();
		session.close();
	}
}
