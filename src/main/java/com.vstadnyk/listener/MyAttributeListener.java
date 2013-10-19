package com.vstadnyk.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Date: 10/19/13
 * Time: 1:33 PM
 */
public class MyAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        printMessage(servletContextAttributeEvent, "added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        printMessage(servletContextAttributeEvent, "removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        printMessage(servletContextAttributeEvent, "replaced");
    }

    private void printMessage(ServletContextAttributeEvent servletContextAttributeEvent, String message) {
        servletContextAttributeEvent.getServletContext().log(String.format("Attribute % is %", servletContextAttributeEvent.getName(), message));
    }
}
