package com.nelioalves.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${jwt.secret}")
	private String secret;
	
	
	@Value("${jwt.expiration}")
	private Long expiration;

	
	public String generateToken (String username, int idUser) {
		return Jwts.builder()
				.setSubject(username)
				.claim("iduser", idUser) //informação extra ("chave", valor)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}

}
