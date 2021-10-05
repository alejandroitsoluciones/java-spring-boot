package ar.com.sysweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ar.com.sysweb.entity.Role;
import ar.com.sysweb.entity.User;

import ar.com.sysweb.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_registration")
	public String processRegistration(User user) {
		userService.saveUserWithDefaultRole(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = userService.findAllUser();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		User user = userService.findUserById(id);
		List<Role> listRole = userService.findAllRole();
		model.addAttribute("user", user);
		model.addAttribute("listRole", listRole);
		return "edit_user";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/list_users";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "redirect:/list_users";
	}
	
}
