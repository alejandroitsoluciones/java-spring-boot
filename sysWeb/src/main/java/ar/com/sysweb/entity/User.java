package ar.com.sysweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 25)
	private String nameUser;
	
	@Column(nullable = false, length = 25)
	private String lastNameUser;
	
	@Column(nullable = false, length = 10)
	private String identificacionNumberUser;
	
	@Column(nullable = false, length = 45, unique = true)
	private String emailUser;
	
	@Column(nullable = false, length = 64)
	private String passwordUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getIdentificacionNumberUser() {
		return identificacionNumberUser;
	}

	public void setIdentificacionNumberUser(String identificacionNumberUser) {
		this.identificacionNumberUser = identificacionNumberUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	
	
}
