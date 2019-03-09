
package com.capgemini.java.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
	Con la anotacion @WebServlet indicamos la "etiqueta/nombre" de la clase. Asi podemos referenciarla en otro codigo
	JSP (en este caso fue a donde enviamos la info del formulario).
*/
@WebServlet ("/login")
public class LoginServlet extends HttpServlet {


    private final String userID   = "hsimpson";
	private final String password = "qwerty";


	private static final Logger logger = LoggerFactory.getLogger (LoginServlet.class);


	// Aparentemente doPost es lo que hace al recibir la info
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request.getParameter("atributo_name") es para obtener el valor del parametro
	    String user = request.getParameter ("user");
		String  pwd = request.getParameter ("pwd");

        logger.debug (String.format ("User %s PWD %s", user, pwd));

		if (userID.equals(user) && password.equals (pwd)) {

			// Constructor vacio crea una sesion con el username de setAttribute
		    HttpSession session = request.getSession ();
			session.setAttribute ("user", "hsimpson");

			session.setMaxInactiveInterval (30*60);

			// Crea la cookie, la agrega a response y redirecciona
			Cookie userName = new Cookie ("user", user);
			userName.setMaxAge (30*60);
			response.addCookie (userName);
			response.sendRedirect ("loginSuccess.jsp");

		} else {

			// No se lo que es el dispatcher. Buscar eso e include
			RequestDispatcher rd = getServletContext ().getRequestDispatcher ("/login.html");
			PrintWriter out= response.getWriter ();
			out.println ("<font color=red>User name or password is wrong !!!</font>");
			rd.include (request, response);
		}
	}
}