package br.com.etecGuainazes.BioGame.Controller;

import br.com.etecGuainazes.BioGame.Model.Usuario;
import br.com.etecGuainazes.BioGame.View.ControladorFrame;
import br.com.etecGuainazes.BioGame.View.Home;
import br.com.etecGuainazes.BioGame.View.Login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

public class IniciarSessao {

	Usuario usuario;
		
	private String senha;
	
	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	private Connection conn = new Conexao().getConexao();
	
	private String sql = null;
	
	public void cadastrar() {
		
		try{
			
			sql = "SELECT nomeUsuario FROM tbUsuario WHERE nomeUsuario = '"+usuario.getUser()+"'";
		
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);	
			
			if(rs.next()){
				
				Efeitos efeitos = new Efeitos();
				
				Login.desc.setText("O nome de usu�rio j� existe!");
				efeitos.popSobe();
				Login.iniciado = false;
				
			}else{
				
				String sql2 = "SELECT * FROM tbUsuario";
				
				sql2 = "INSERT INTO tbUsuario(nomeUsuario, senhaUsuario	, emailUsuario, pontoUsuario, nivel1, nivel2, nivel3, nivel4, nivel5)" + "VALUES ('"+usuario.getUser()+"' , '"+Senha(senha)+"' , '"+usuario.getEmail()+"', '0', '0', '0', '0', '0', '0')";
				
				Statement st2 = conn.createStatement();
				st2.execute(sql2);	
				
				Efeitos f = new Efeitos();
				
				f.setEntrada(2);
				f.setSaida(1);
				f.setEscolhaE(1);
				
				f.transicaoReducao();
				
			}
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public void Logar(){
		
		try{
			
			sql = "SELECT nomeUsuario, senhaUsuario FROM tbUsuario WHERE nomeUsuario = '"+usuario.getUser()+"'";
			
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);	
			
			if(rs.next()){
				
				if(rs.getString("senhaUsuario").equals(Senha(senha))){
					
					Efeitos f = new Efeitos();
					
					f.setEntrada(2);
					f.setSaida(1);
					f.setEscolhaE(1);
					
					f.transicaoReducao(); 
					
				}else{
					
					Efeitos efeitos = new Efeitos();
					Login.desc.setText("Nome de usu�rio ou senha invalidos");
					efeitos.popSobe();
					Login.iniciado = false;
					
				}
				
			}else{
				
				Efeitos efeitos = new Efeitos();
				Login.desc.setText("Nome de usu�rio ou senha invalidos");
				efeitos.popSobe();
				Login.iniciado = false;
				
			}
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	//criptograva��o de senha
	public String Senha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		
		byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		
		for (byte b : messageDigest) {
		
			hexString.append(String.format("%02X", 0xFF & b));
		
		}
		 
		senha = hexString.toString();
		
		return senha;
		
	}
	
}
