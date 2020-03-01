package ru.ncedu.course.catalog_example.servlet;

import ru.ncedu.course.catalog_example.exception.OfferingNotFoundException;
import ru.ncedu.course.catalog_example.service.LikeService;
import ru.ncedu.course.catalog_example.service.OfferingService;
import ru.ncedu.course.catalog_example.util.PathConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathConstants.LIKE_PATH)
public class LikeServlet extends HttpServlet {

    @Inject
    private LikeService likeService;

    private static final String OFFERING_ID_PARAM = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long offeringId = Long.parseLong(req.getParameter(OFFERING_ID_PARAM));
        likeService.addOffering(offeringId);
        getServletContext().getRequestDispatcher(PathConstants.CATALOG_PATH).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long offeringId = Long.parseLong(req.getParameter(OFFERING_ID_PARAM));
        likeService.addOffering(offeringId);
        getServletContext().getRequestDispatcher(PathConstants.CATALOG_PATH).forward(req, resp);
    }
}
