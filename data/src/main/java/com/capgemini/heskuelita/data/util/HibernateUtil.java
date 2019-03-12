package com.capgemini.heskuelita.data.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.heskuelita.data.entity.StudentAnnotation;
import com.capgemini.heskuelita.data.entity.UserAnnotation;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

    private static SessionFactory sessionAnnotationFactory;

    private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory sessionHierarchyConfigFactory;

    private static final Logger logger = LoggerFactory.getLogger (HibernateUtil.class);


    private HibernateUtil () {

        super ();
    }



    private static SessionFactory buildSessionFactory () {

        try {

            Configuration configuration = new Configuration ();
        	configuration.configure ("hibernate.cfg.xml");
        	logger.debug ("Hibernate Configuration loaded...");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ().
                                    applySettings (configuration.getProperties()).build ();
        	logger.debug ("Hibernate serviceRegistry created...");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory (serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {

            logger.error ("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError (ex);
        }
    }

    private static SessionFactory buildSessionAnnotationFactory () {

        try {

            Configuration configuration = new Configuration ();
        	configuration.configure ("hibernate-annotation.cfg.xml");
        	logger.debug ("Hibernate Annotation Configuration loaded...");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ().
                    applySettings (configuration.getProperties ()).build ();
            logger.debug ("Hibernate Annotation serviceRegistry created...");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory (serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {

            logger.error ("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError (ex);
        }
	}

    private static SessionFactory buildSessionJavaConfigFactory () {

    	try {

    	    Configuration configuration = new Configuration ();

            Properties props = new Properties ();
            props.put ("hibernate.connection.driver_class", "org.postgresql.Driver");
            props.put ("hibernate.connection.url", "jdbc:postgresql://localhost:5432/heskuelita");
            props.put ("hibernate.connection.username", "postgres");
            props.put ("hibernate.connection.password", "mhfu17");
		
            // Agregar las clases anotadas
		    configuration.setProperties (props);
		    configuration.addAnnotatedClass (StudentAnnotation.class);
		    configuration.addAnnotatedClass (UserAnnotation.class);
		
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ().
                    applySettings (configuration.getProperties ()).build ();
    	    logger.debug ("Hibernate Java Config serviceRegistry created...");
    	
    	    SessionFactory sessionFactory = configuration.buildSessionFactory (serviceRegistry);
    	
            return sessionFactory;

    	} catch (Throwable ex) {

            logger.error ("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError (ex);
        }
	}

    private static SessionFactory buildSessionHierarchyAnnotationFactory () {

        try {

            Configuration configuration = new Configuration ();
            configuration.configure ("hibernate-heirarchy.cfg.xml");
            logger.debug ("Hibernate Hierarchy Annotation Configuration loaded...");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ().
                    applySettings (configuration.getProperties ()).build ();
            logger.debug ("Hibernate Hierarchy Annotation serviceRegistry created...");

            SessionFactory sessionFactory = configuration.buildSessionFactory (serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {

            logger.error ("Initial Hierarchy SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError (ex);
        }
    }

	public static SessionFactory getSessionFactory () {

		if (sessionFactory == null) { sessionFactory = buildSessionFactory (); }
        return sessionFactory;
    }
	
	public static SessionFactory getSessionAnnotationFactory () {

		if (sessionAnnotationFactory == null) { sessionAnnotationFactory = buildSessionAnnotationFactory (); }
        return sessionAnnotationFactory;
    }
	
	public static SessionFactory getSessionJavaConfigFactory () {

        if (sessionJavaConfigFactory == null) { sessionJavaConfigFactory = buildSessionJavaConfigFactory (); }
        return sessionJavaConfigFactory;
    }

    public static SessionFactory getSessionHierarchyConfigFactory () {

        if (sessionHierarchyConfigFactory == null) { sessionHierarchyConfigFactory = buildSessionHierarchyAnnotationFactory (); }
        return sessionHierarchyConfigFactory;
    }
    
}
