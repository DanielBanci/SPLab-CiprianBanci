package com.example.crc;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RequestLoggingFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();
        log.info("Request start - {} {}", servletRequest.getMethod(), servletRequest.getRequestURI());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        log.info("Request finished - {} {} - Status: {} ({} ms)",
                servletRequest.getMethod(), servletRequest.getRequestURI(),
                servletResponse.getStatus(), duration);
    }
}
