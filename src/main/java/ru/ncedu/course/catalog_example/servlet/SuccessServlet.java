package ru.ncedu.course.catalog_example.servlet;

import ru.ncedu.course.catalog_example.service.AuthorizationBean;
import ru.ncedu.course.catalog_example.util.PathConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathConstants.SUCCESS_PAGE)
public class SuccessServlet extends HttpServlet {

    private static final String AUTHORIZED_ATTR = "authorized";
    private static final String SUCCESS_JSP = "/successPage.jsp";

    @Inject
    private AuthorizationBean authorizationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().setAttribute(AUTHORIZED_ATTR, authorizationBean.isAuthorized());
        getServletContext().getRequestDispatcher(SUCCESS_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
