package ar.com.sysweb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "p4$$w0rd";
		System.out.println(encoder.encode(password));
		
	}

}
