package br.eletrotech.energia.security;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenJWT {
	
	public static final Integer TOKEN_EXPIRATION = 1800000;
	public static final String KEY = "a2f85012-40bd-417a-a7bd-11054d94a1e7";
	
	public static String create(String email) {
		return JWT.create().withSubject(email).withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION)).sign(Algorithm.HMAC512(KEY));
	}

	public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
		String email = JWT.require(Algorithm.HMAC512(KEY)).build().verify(token).getSubject();
		if (email == null) {
			return null;
		}
		return new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
	}
}
