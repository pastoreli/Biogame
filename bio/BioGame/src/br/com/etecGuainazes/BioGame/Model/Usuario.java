package br.com.etecGuainazes.BioGame.Model;

public class Usuario {

	static private String user;
	static private String senha;
	static private String email;

	public static String getUser() {
	
		if (user == null) user = new String();  
		return user;
	
	}
	
	public void setUser(String user) {
	
		this.user = user;
	
	}
	
	public static String getSenha() {
	
		return senha;
	
	}
	
	public void setSenha(String senha) {
	
		this.senha = senha;
	
	}
	
	public static String getEmail() {
		
		return email;
	
	}

	public void setEmail(String email) {
		
		this.email = email;
	
	}
	
	
	
}