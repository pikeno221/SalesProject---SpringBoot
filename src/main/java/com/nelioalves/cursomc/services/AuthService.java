package com.nelioalves.cursomc.services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class AuthService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Random rand = new Random();

	public void sendNewPassword(String email) {

		Optional<Cliente> cliente = clienteRepository.findByEmail(email);
		
		cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + email + ", Tipo: " + Cliente.class.getName()));
		
		
		String newPass = newPassword();
		cliente.get().setSenha(pe.encode(newPass));

		clienteRepository.save(cliente.get());
		emailService.sendNewPasswordEmail(cliente.get(), newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // Gera um Digito
			return (char) (rand.nextInt(10) + 48); 
		} else if (opt == 1) { // Gera um Maiusculo
			return (char) (rand.nextInt(26) + 65); 
		} else { // Gera um Minuscula
			return (char) (rand.nextInt(26) + 97); 
		}
	}

}
