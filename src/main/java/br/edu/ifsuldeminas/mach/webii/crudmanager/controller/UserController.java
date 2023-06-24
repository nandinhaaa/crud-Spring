package br.edu.ifsuldeminas.mach.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/users/form")
	public String userForm(@ModelAttribute("user") User user) { //indicando que vai ser um atrib do modelo 
		
		
		return "user_form";
		
	}
	
	@PostMapping("/users/new")
	public String userNew(@ModelAttribute("user") User user) {
		
		userRepository.save(user);
		
		return"redirect:/users"; //usuario n sabe que isso foi feito é um requisicao interna
	}
	
	@GetMapping("/users/update/{id}")
	public String userUpdate(@PathVariable ("id") Integer id, Model model) { //variavel cujo o valor está inserido na URL
		
		Optional<User> optUser = userRepository.findById(id); //Optional usado pra evitar erros (verificar se o obj n é nulo) 
		
		if (!optUser.isPresent()) {
			//Gerar erro
		}
		
		User user = optUser.get();
		
		model.addAttribute("user", user);
		
		return"user_form";
		}
	
	
	@GetMapping("/users/delete/{id}")
    public String userDelete(@PathVariable("id") Integer id) {

        Optional<User> optUser = userRepository.findById(id);
        
        if (!optUser.isPresent()) { // recupera no banco de dados quando clica em alterar
            // Gerar erro
        }
        
        User user = optUser.get();
        
        userRepository.delete(user);

        return "redirect:/users";
    }
	
}
