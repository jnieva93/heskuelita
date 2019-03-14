package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.data.impl.UserDaoHibernate;
import com.capgemini.heskuelita.data.util.HibernateUtil;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.SessionFactory;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet {

    private ISecurityService securityService;

    public LoginServlet () {
        super ();
    }

    
    // Inicia la conexion. Lo antes aplicado a DBConn, va con HibernateUtil
    @Override
    public void init (ServletConfig config) throws ServletException {

        SessionFactory manager = HibernateUtil.getSessionFactory();

        try {
            this.securityService = new SecurityServiceImpl (new UserDaoHibernate(manager));
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserAnnotation user = new UserAnnotation();
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
