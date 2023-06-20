package br.edu.ifsuldeminas.mach.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.UserRepository;

@Component // tratar como componente assim que o sistema inicializa
@Transactional // operações dentro do DB -> inicilizar/finalizar as transações
public class InitializeDataBase implements CommandLineRunner {

	@Autowired //faz a mágica user é uma interface mas eu quero um obj 
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User nanda = new User();
		nanda.setName("Nanda");
		nanda.setEmail("nanda@gmail.com");
		nanda.setGender("F");

		User emerson = new User();
		emerson.setName("Emerson");
		emerson.setEmail("Emerson@gmail.com");
		emerson.setGender("M");

		User le = new User();
		le.setName("Le");
		le.setEmail("Le@gmail.com");
		le.setGender("F");
		
		userRepository.save(nanda);
		userRepository.save(emerson);
		userRepository.save(le);
		
		List<User> users = userRepository.findAll(); // disparou um select 
		
		for (User user : users) {
			System.err.println(user.getName());
			System.err.println(user.getEmail());
			System.err.println(user.getGender());
			
		}
	}

}
