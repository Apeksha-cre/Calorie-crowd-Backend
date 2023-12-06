package com.calorieCrowd.caloriecrowdAPIs.filter;

import com.calorieCrowd.caloriecrowdAPIs.AuthenticationException;
import com.calorieCrowd.caloriecrowdAPIs.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class RequestInterceptor extends OncePerRequestFilter {

@Autowired
private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(jwtUtil.resolveClaims(request)==null){
            throw new AuthenticationException("Invalid token");
        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
            throws ServletException {
        String path = request.getRequestURI();
        return path.contains("/login");
    }
}
