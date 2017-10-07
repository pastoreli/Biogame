package br.com.etecGuainazes.BioGame.Controller;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;

import br.com.etecGuainazes.BioGame.Model.Usuario;
import br.com.etecGuainazes.BioGame.View.ControladorFrame;
import br.com.etecGuainazes.BioGame.View.Jogos;

public class Vitoria {

	public static int jogosG = 0;
	
	LogicaMemoria logica;
	
	Efeitos efeitos;
	
	public void vitoria(){
		
		if(jogosG == 2){
			
			for(int i=0; i<ControladorFrame.pMemoria.pecas.length; i++){
				
				ControladorFrame.pMemoria.pecas[i].setEnabled(false);
				
			}
			
			if(logica.nivel==1){
				
				for(int i=0; i<ControladorFrame.pSequencia.pecas.length; i++){
				
					ControladorFrame.pSequencia.pecas[i].setEnabled(false);
				
				}
			
			}else{
				
				for(int i=0; i<ControladorFrame.pSintomas.sintomasB.length; i++){
					
					ControladorFrame.pSintomas.sintomasB[i].setEnabled(false);
					
				}
			
			}
			
			Jogos.pPopUp.setVisible(true);
			Jogos.pPopUp.popUp.setVisible(true);
			
			jogosG = 0;
			
			efeitos.tipoPop = 1;
			
			Efeitos e = new Efeitos();
			
			e.popUpT();
			
			efeitos.finaliza = 1;
			
			pontos();
			
		}
		
	}
	
	public void derrota(){
			
		for(int i=0; i<ControladorFrame.pMemoria.pecas.length; i++){
			
			ControladorFrame.pMemoria.pecas[i].setEnabled(false);
			
		}
		
		if(logica.nivel==1){
			
			for(int i=0; i<ControladorFrame.pSequencia.pecas.length; i++){
			
				ControladorFrame.pSequencia.pecas[i].setEnabled(false);
			
			}
		
		}else{
			
			for(int i=0; i<ControladorFrame.pSintomas.sintomasB.length; i++){
				
				ControladorFrame.pSintomas.sintomasB[i].setEnabled(false);
				
			}
		
		}
		
			Jogos.pPopUp.setVisible(true);
			Jogos.pPopUp.derrotaPop.setVisible(true);
			jogosG = 0;
			
			efeitos.tipoPop = 2;
			
			Efeitos e = new Efeitos();
			
			e.popUpT();
			
			efeitos.finaliza = 1;
	
	}
	
	private Connection conn = new Conexao().getConexao();
	
	private String sql = null;
	
	public void pontos(){
		
		try{
			
			Statement stm = conn.createStatement();
			
			sql = "UPDATE tbUsuario SET pontoUsuario = pontoUsuario+"+efeitos.pontos+" WHERE nomeUsuario = '"+Usuario.getUser()+"'";
			stm.execute(sql);
			
			switch(logica.nivel){
			
			case 1:
			
				sql = "UPDATE tbUsuario SET nivel1 = 1 WHERE nomeUsuario = '"+Usuario.getUser()+"'";
				
			break;
			
			case 2:
				
				sql = "UPDATE tbUsuario SET nivel2 = 1 WHERE nomeUsuario = '"+Usuario.getUser()+"'";
				
			break;
				
			case 3:
				
				sql = "UPDATE tbUsuario SET nivel3 = 1 WHERE nomeUsuario = '"+Usuario.getUser()+"'";
				
			break;
				
			case 4:
				
				sql = "UPDATE tbUsuario SET nivel4 = 1 WHERE nomeUsuario = '"+Usuario.getUser()+"'";
				
			break;
				
			case 5:
				
				sql = "UPDATE tbUsuario SET nivel5 = 1 WHERE nomeUsuario = '"+Usuario.getUser()+"'";
				
			break;
			
			}
			
			stm.execute(sql);
			
			Efeitos e = new Efeitos();
			
			Jogos.pPopUp.pontos.setText(Integer.toString(efeitos.pontos));
			
			e.pontos();
		
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
}
