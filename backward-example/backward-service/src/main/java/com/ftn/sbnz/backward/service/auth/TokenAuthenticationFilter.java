package com.ftn.sbnz.backward.service.auth;

import com.ftn.sbnz.backward.service.services.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ftn.sbnz.backward.service.models.*;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userDetails;

    @Autowired
    private TokenUtils jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURL = request.getRequestURL().toString();
        System.out.println("Processing URL: " + requestURL);
        if (requestURL.contains("/api/")) {
            System.out.println("Processing API request.");
            String requestTokenHeader = request.getHeader("Authorization");
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                String jwtToken = requestTokenHeader.substring(7);
                System.out.println("JWT Token: " + jwtToken);
                try {
                    String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                    UserDetails userDetails = this.userDetails.loadUserByUsername(username);
                    if (jwtTokenUtil.validateToken(jwtToken, (User) userDetails)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        System.out.println("Authenticated user: " + username);
                    }
                } catch (Exception e) {
                    System.out.println("Token validation failed: " + e.getMessage());
                }
            } else {
                System.out.println("JWT Token is missing or doesn't start with 'Bearer '");
            }
        }
        filterChain.doFilter(request, response);
    }
}
