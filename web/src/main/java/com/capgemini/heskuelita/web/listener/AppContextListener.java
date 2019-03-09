package com.capgemini.heskuelita.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.capgemini.heskuelita.data.db.DBConnectionManager;

@WebListener
// Contexto, la aplicacion
public class AppContextListener implements ServletContextListener {

    public AppContextListener () {
        super ();
    }


    public void contextInitialized (ServletContextEvent servletContextEvent) {

    	ServletContext ctx = servletContextEvent.getServletContext ();
    	
    	// Setea los parametros obteniendolos de web.xml
    	String url = ctx.getInitParameter ("DBURL");
    	String u   = ctx.getInitParameter ("DBUSER");
    	String p   = ctx.getInitParameter ("DBPWD");
        String d   = ctx.getInitParameter ("DRIVER");

        // Bindea db al objeto dbManager instanciado con los parametros pasados
    	DBConnectionManager dbManager = new DBConnectionManager (url, u, p, d);
    	ctx.setAttribute ("db", dbManager);
    }

    public void contextDestroyed (ServletContextEvent servletContextEvent) {

    	ServletContext ctx = servletContextEvent.getServletContext ();
    	
    	// Cierra la conexion
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute ("db");
    	dbManager.closeConnection ();
    }
    
}
