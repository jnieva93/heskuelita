package com.capgemini.heskuelita.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.heskuelita.data.entity.UserAnnotation;
import org.hibernate.SessionFactory;

import com.capgemini.heskuelita.data.IStudentDao;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.entity.StudentAnnotation;
import com.capgemini.heskuelita.data.impl.StudentDaoHibernate;
import com.capgemini.heskuelita.data.impl.UserDaoHibernate;
import com.capgemini.heskuelita.data.util.HibernateUtil;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	
	private IStudentDao studentDao;
	private IUserDao userDao;
	
	public RegistrationServlet() {		
		super();
	}
	
	
	@Override
	public void init (ServletConfig config) throws ServletException {
		
		SessionFactory manager = HibernateUtil.getSessionFactory();
		
		this.studentDao = new StudentDaoHibernate(manager);
		this.userDao = new UserDaoHibernate(manager);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtenemos datos del formulario
		StudentAnnotation student = new StudentAnnotation();
		student.setFirstName(request.getParameter("name"));
		student.setLastName(request.getParameter("lastName"));
		student.setDni(request.getParameter("dni"));
		student.setPhone(request.getParameter("phone"));
		student.setAddress(request.getParameter("address"));
		student.setGender(request.getParameter("gender"));
		student.setUserName(request.getParameter("userName"));
		
		UserAnnotation user = new UserAnnotation();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		
		try {
			// Agrega los datos del estudiante a la tabla student
			studentDao.addStudent(student);
			
			// Agrega los datos del usuario a la tabla users
			userDao.addUser(user);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect ("index.jsp");
	}

}
