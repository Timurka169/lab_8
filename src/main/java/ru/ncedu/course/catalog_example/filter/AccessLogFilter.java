package ru.ncedu.course.catalog_example.filter;

import ru.ncedu.course.catalog_example.service.AuthorizationBean;
import ru.ncedu.course.catalog_example.service.JourneyBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebFilter(urlPatterns = {"*"})
public class AccessLogFilter implements Filter {

    @Inject
    private JourneyBean journeyBean;

    @Inject
    private AuthorizationBean authorizationBean;

    private final static Logger LOGGER = Logger.getLogger(AccessLogFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        StringBuffer url = null;
        String params = null;
        if (request instanceof HttpServletRequest) {
            url = ((HttpServletRequest)request).getRequestURL();
            params = ((HttpServletRequest)request).getQueryString();
            if (params!=null ){
                url.append("?");
                url.append(params);
            }

            LOGGER.info("Client " + request.getRemoteAddr() + " opened " + url.toString());
        }
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        addLine(url.toString());
        chain.doFilter(request, response);
    }

    private void addLine(String str){
        if (authorizationBean.isAuthorized()){
            journeyBean.getJourneyList().add(str);
        }
    }
}
