package br.edu.ifsuldeminas.mach.webii.crudmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.UserRepository;

@Controller //receber e tratar requisições 
public class UserController {
	
	@Autowired //Já sabe trabalhar com os dados 
	private UserRepository userRepository;
	
	@GetMapping ("/users")//req chama e so vai ser atendida se for do tipo Get e o Request Recebe qualquer um Post ou Get
	public String usuarios(Model model) { //framework Model 

		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		
		return "index"; // página que vai ser redirecionada 
	}
	
}
