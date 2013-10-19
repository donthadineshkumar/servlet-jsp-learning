package com.vstadnyk;

import com.vstadnyk.model.Database;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Override;

/**
 * Date: 10/17/13
 * Time: 12:41 PM
 */
public class MainServlet extends HttpServlet {

    private static final String NEW_LINE = " === ";

    @Override
    public void destroy() {
        System.out.println("SERVLET IS DESTROYED NOW !!! ");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String host = servletContext.getInitParameter("host");
        String ip = servletContext.getInitParameter("ip");

        Database database = (Database) servletContext.getAttribute("database");

        servletContext.removeAttribute("attr");
        servletContext.setAttribute("attr", System.currentTimeMillis());

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append("host is ");
        writer.append(host);
        writer.append(NEW_LINE);
        writer.append("ip is ");
        writer.append(ip);
        writer.append(NEW_LINE);
        writer.append("db is ");
        writer.append(database.toString());

    }
}
