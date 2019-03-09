package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet {

    private ISecurityService securityService;

    public LoginServlet () {
        super ();
    }

    
    // Inicia la conexion
    @Override
    public void init (ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();

        DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");

        try {
            this.securityService = new SecurityServiceImpl (new UserDaoJDBC (manager.getConnection()));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User ();
        user.setUserName (req.getParameter ("user"));
        user.setPassword (req.getParameter ("pwd"));

        try {
            this.securityService.login (user);

            HttpSession session = req.getSession ();
            session.setAttribute ("user", user);

            resp.sendRedirect ("home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            
            resp.sendRedirect ("err.jsp");
        }
        
    }
    
}
