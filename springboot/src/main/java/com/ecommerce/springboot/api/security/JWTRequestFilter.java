package com.ecommerce.springboot.api.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.ecommerce.springboot.model.Customer;
import com.ecommerce.springboot.model.repo.CustomerRepo;
import com.ecommerce.springboot.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final CustomerRepo customerRepo;
    public JWTRequestFilter(JWTService jwtService, CustomerRepo customerRepo) {
        this.jwtService = jwtService;
        this.customerRepo = customerRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if (tokenHeader !=null && tokenHeader.startsWith("Bearer ")){
            String token = tokenHeader.substring(7);
            try {
            String username = jwtService.getUsername(token);
            Optional <Customer> opCustomer = customerRepo.findByUsernameIgnoreCase(username);
            if (opCustomer.isPresent()){
                Customer customer = opCustomer.get();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customer,null, new ArrayList<>());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            } catch (JWTDecodeException ex){
            }
        }
        filterChain.doFilter(request,response);
    }
}
