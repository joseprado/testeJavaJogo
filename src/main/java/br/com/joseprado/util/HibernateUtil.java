package br.com.joseprado.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;
 
    static {
        try {
            ourSessionFactory =
                new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
 
    public void close() {
        if (getSession() != null && getSession().isOpen()) {
            getSession().close();
        }
    }
}
