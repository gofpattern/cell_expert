package com.cellexperts.db.hbm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Driver {

	static SessionFactory factory = getSessionFactory();

	public static void main(String[] args) {
		addEmployee();
	}

	private static SessionFactory getSessionFactory()
			throws ExceptionInInitializerError {
		SessionFactory factory;
		try {
			// loads configuration and mappings
	        Configuration configuration = new Configuration().configure();
	        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
	        registry.applySettings(configuration.getProperties());
	        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
	         
	        // builds a session factory from the service registry
	        factory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

	public static Integer addEmployee() {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Employees emp = new Employees("aaqib", "rehman", null, null,
					"gofpattern@gmail.com", null, "31 N Street, Allentown",
					null, null);
			employeeID = (Integer) session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

}
