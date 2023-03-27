package br.eletrotech.energia.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTValidationFilter extends BasicAuthenticationFilter {
	
	public static final String HEADER_ATTRIBUTE = "Authorization";
	public static final String ATTRIBUTO_PREFIX = "Bearer ";

	public JWTValidationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String attribute = request.getHeader(HEADER_ATTRIBUTE);
		if (attribute == null || !attribute.startsWith(ATTRIBUTO_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		String token = attribute.replace(ATTRIBUTO_PREFIX, "");
		UsernamePasswordAuthenticationToken authenticationToken = TokenJWT.getAuthenticationToken(token);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}
	
	
}
