package com.visenze.example.apis.filter;

import org.eclipse.jetty.http.HttpStatus;
import org.glassfish.jersey.server.ContainerRequest;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by dalec on 23/8/16.
 */
public class ParamRequestFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {

            if(((HttpServletRequest) request).getMethod().equals("GET")){
                chain.doFilter(request, response);
            }
            String[] reqParam = request.getParameterMap().get("quantity");
            if (reqParam != null && reqParam[0].matches("-?\\d+")) {
                chain.doFilter(request, response);
            }else if(reqParam == null){
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpStatus.BAD_REQUEST_400);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("error", 1);
                jsonObject.put("err_code", 102);
                jsonObject.put("err_msg", "No Parameter specified");
                httpResponse.getWriter().print(jsonObject);
            }else {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(HttpStatus.BAD_REQUEST_400);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("error", 1);
                jsonObject.put("err_code", 102);
                jsonObject.put("err_msg", "Invalid non numeric parameters");
                httpResponse.getWriter().print(jsonObject);
            }
        }
    }

    @Override
    public void destroy(){};
}

