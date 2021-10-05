package ar.com.sysweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.com.sysweb.entity.Role;
import ar.com.sysweb.entity.User;
import ar.com.sysweb.repository.RoleRepository;
import ar.com.sysweb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void saveUserWithDefaultRole(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPasswordUser());
		user.setPasswordUser(encodedPassword);
		Role role = roleRepository.findByName("USER");
		user.addRole(role);
		userRepository.save(user);		
	}
	
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	
	public List<Role> findAllRole(){
		return roleRepository.findAll();
	}
	
	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	
	public void saveUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPasswordUser());
		user.setPasswordUser(encodedPassword);
		userRepository.save(user);		
	}
	
}
