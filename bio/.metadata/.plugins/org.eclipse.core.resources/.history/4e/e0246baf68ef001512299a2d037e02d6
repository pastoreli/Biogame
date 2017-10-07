package br.com.etecGuainazes.BioGame.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConexao() {
		
		Connection conn = null;
		
		try{
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bdBio","root" , "");
			
			return conn;
		
		}catch(SQLException e){
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
			
		}
	
	}
	
	
}
