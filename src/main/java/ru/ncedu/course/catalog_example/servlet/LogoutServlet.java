package ru.ncedu.course.catalog_example.servlet;

import ru.ncedu.course.catalog_example.service.JourneyService;
import ru.ncedu.course.catalog_example.service.LikeService;
import ru.ncedu.course.catalog_example.service.UserService;
import ru.ncedu.course.catalog_example.util.PathConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathConstants.LOGOUT_PATH)
public class LogoutServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Inject
    private JourneyService journeyService;

    @Inject
    LikeService likeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.logout();
        journeyService.closeSession();
        likeService.closeSession();
        getServletContext().getRequestDispatcher(PathConstants.CATALOG_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.logout();
    }

}
