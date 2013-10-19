package com.vstadnyk.listener;

import com.vstadnyk.model.Database;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Date: 10/19/13
 * Time: 1:14 PM
 */
public class MyServletInitialisedListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String host = servletContext.getInitParameter("host");
        String ip = servletContext.getInitParameter("ip");
        Database database = new Database(host, ip);
        servletContext.setAttribute("database", database);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Database database = (Database)servletContext.getAttribute("database");
        database.destroy();
    }
}
