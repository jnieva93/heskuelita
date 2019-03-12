package com.capgemini.heskuelita.data.impl;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.data.util.HibernateUtil;

public class UserDaoHibernate {
	
	private static SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoHibernate.class);
	
	public UserDaoHibernate() {
		super();
	}
	
		
	public void addUser() throws SQLException {
		// Setup
		sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
		
		// Empieza la creacion
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("Getting a session...");
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Setea la data a guardar
			logger.info("Creating values to insert...");
			UserAnnotation[] values = new UserAnnotation[] {
					new UserAnnotation("basurita", "test02", "basurita@gmail.com"),
					new UserAnnotation("basurita2", "test04", "basurita2@gmail.com")
			};
			
			// Salva la data
			for (UserAnnotation u : values) {
				logger.info(String.format("Saving value %s", u.getUserName()));
				session.save(u);
				logger.info(String.format("Value %s saved!", u.getUserName()));
			}
			
			tx.commit();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			
			tx.rollback();
		} finally {
			session.close();
			
			// Destroy
			sessionFactory.close();
		}

	}
	
//	public static void main(String[] args) {
//		UserDaoHibernate test = new UserDaoHibernate();
//		try {
//			test.addUser();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
