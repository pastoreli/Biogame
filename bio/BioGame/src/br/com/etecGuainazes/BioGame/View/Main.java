package br.com.etecGuainazes.BioGame.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.etecGuainazes.BioGame.Controller.Efeitos;

public class Main {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Efeitos e = new Efeitos(); 
		
		e.splashBarra();

	}

}
