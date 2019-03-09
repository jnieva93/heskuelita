package com.capgemini.heskuelita.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IStudentDao;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.StudentDaoJDBC;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	
	private IStudentDao studentDao;
	private IUserDao userDao;
	
	public RegistrationServlet() {		
		super();
	}
	
	
	@Override
	public void init (ServletConfig config) throws ServletException {
		
		ServletContext context = config.getServletContext();
		
		DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");
		
		this.studentDao = new StudentDaoJDBC(manager.getConnection());
		this.userDao = new UserDaoJDBC(manager.getConnection());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtenemos datos del formulario
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setLastName(request.getParameter("lastName"));
		student.setDni(request.getParameter("dni"));
		student.setPhone(request.getParameter("phone"));
		student.setAddress(request.getParameter("address"));
		student.setGender(request.getParameter("gender"));
		student.setUserName(request.getParameter("userName"));
		
		User user = new User();
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
