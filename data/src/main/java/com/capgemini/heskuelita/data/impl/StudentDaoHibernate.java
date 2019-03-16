package com.capgemini.heskuelita.data.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.heskuelita.data.IStudentDao;
import com.capgemini.heskuelita.data.entity.StudentAnnotation;
import com.capgemini.heskuelita.data.util.HibernateUtil;

public class StudentDaoHibernate implements IStudentDao {

	private static SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoHibernate.class);


	public StudentDaoHibernate(SessionFactory sessionFactory) {
		super();

		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public void addStudent(StudentAnnotation student) {
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
			StudentAnnotation value = new StudentAnnotation(student.getFirstName(), student.getLastName(),
					student.getDni(), student.getPhone(), student.getAddress(), student.getGender(),
					student.getUserName());

			// Salva la data
			logger.info(String.format("Saving value %s", value.getFirstName()));
			session.save(value);
			logger.info(String.format("Value %s saved!", value.getFirstName()));
			
			tx.commit();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			
			tx.rollback();
		} finally {
			session.close();
		}

	}

}
