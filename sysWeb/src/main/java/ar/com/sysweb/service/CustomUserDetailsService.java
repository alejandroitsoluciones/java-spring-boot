package ar.com.sysweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ar.com.sysweb.detail.CustomUserDetails;
import ar.com.sysweb.entity.User;
import ar.com.sysweb.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String emailUser) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = repository.findByEmailUser(emailUser);
		
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new CustomUserDetails(user);
	}

}
