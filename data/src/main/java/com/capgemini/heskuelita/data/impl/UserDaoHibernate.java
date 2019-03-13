package com.capgemini.heskuelita.data.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.data.util.HibernateUtil;

public class UserDaoHibernate implements IUserDao {
	
	private static SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoHibernate.class);
	
	// Recordar que la session es igual a la conn
	public UserDaoHibernate(SessionFactory sessionFactory) {
		super();
		
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public User login(String userName, String password) {
		Session session = null;
		final String filterUserName = userName;
		final String filterPassword = password;
		User user = new User();
		
		try {
			logger.info("Getting a session...");
			session = sessionFactory.openSession();
			logger.info("Checking username and password...");
			Criterion criterion1 = Restrictions.ilike("name", filterUserName);
			Criterion criterion2 = Restrictions.like("pwd", filterPassword);
			// Asi se hace el and
			LogicalExpression andExpression = Restrictions.and(criterion1, criterion2);
			
			// Se agrega a creteria?
			List<UserAnnotation> list = (List<UserAnnotation>) session.createCriteria(UserAnnotation.class)
					.add(andExpression).list();
			logger.info("Filter executed");
		} catch (Exception ex) {
			logger.error(String.format("Problems executing login %s", ex.getMessage()));
		} finally {
			logger.info("Closing session...");
			session.close();
		}
		
		return user;
	}	
	
	@Override
	public void addUser(User user) throws SQLException {
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
					new UserAnnotation(user.getUserName(), user.getPassword(), user.getEmail())
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
