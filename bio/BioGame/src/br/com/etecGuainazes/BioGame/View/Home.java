package br.com.etecGuainazes.BioGame.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.html.parser.Parser;

import br.com.etecGuainazes.BioGame.Controller.Conexao;
import br.com.etecGuainazes.BioGame.Controller.Efeitos;
import br.com.etecGuainazes.BioGame.Controller.IniciarSessao;
import br.com.etecGuainazes.BioGame.Controller.LogicaMemoria;
import br.com.etecGuainazes.BioGame.Model.Usuario;

public class Home extends JPanel {

	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	Usuario usuario;
	
	private Connection conn = new Conexao().getConexao();
	
	IniciarSessao sessao = new IniciarSessao();
	
	public JLabel cabecalho, nomeUser, estrela;
	static JLabel pontuacao;
	
	JLabel jogar, descJogar, hoverDesc = new JLabel();
	
	public JButton nivel1, nivel2, nivel3, nivel4, nivel5;
	
	JButton sair;
	
	JButton tratamento;
	
	boolean iniciado = false;
	
	public Home(){
		
		this.setLayout(null);
		this.setBounds(w+20,20,w-40,h-80);
		
		cabecalho = new JLabel();
		cabecalho.setOpaque(true);
		cabecalho.setBounds(0,0,w,60);
		cabecalho.setBackground(new Color(230,230,230));
		cabecalho.setForeground(new Color(250,171,75));
		cabecalho.setFont(new Font("Century Gothic",  Font. PLAIN,  30));
		cabecalho.setHorizontalAlignment(SwingConstants.LEFT);
		cabecalho.setVerticalAlignment(SwingConstants.CENTER);
		
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarHour = new SimpleDateFormat("HH"); 
		int hora = Integer.parseInt(formatarHour.format(data));
		
		if(hora < 12){
		
			nomeUser = new JLabel("Bom dia, "+usuario.getUser());
		
		}else if(hora < 18){
			
			nomeUser = new JLabel("Boa tarde, "+usuario.getUser());
			
		}else{
			
			nomeUser = new JLabel("Boa noite, "+usuario.getUser());
			
		}
		nomeUser.setBounds(30,0,300,60);
		nomeUser.setBackground(new Color(255,255,255));
		nomeUser.setForeground(new Color(66,170,33));
		nomeUser.setFont(new Font("Century Gothic",  Font. PLAIN,  22));
		nomeUser.setHorizontalAlignment(SwingConstants.CENTER);
		nomeUser.setVerticalAlignment(SwingConstants.CENTER);
		
		estrela = new JLabel();
		estrela.setIcon(new ImageIcon("img/estrela.png"));
		estrela.setBounds((w/2)-25,0,50,60);
		
		try{
		
		String sql=null;
		
		sql = "SELECT nomeUsuario, pontoUsuario FROM tbUsuario WHERE nomeUsuario = '"+usuario.getUser()+"'";
		
		Statement stm = conn.createStatement();
		
		ResultSet rs = stm.executeQuery(sql);	
		
		if(rs.next()){
			
			if(rs.getString("nomeUsuario").equals(usuario.getUser())){
				
				pontuacao = new JLabel(Integer.toString((rs.getInt("pontoUsuario"))));
				
			}
		
		}
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}

		pontuacao.setBounds((w/2)-20,0,150,60);
		pontuacao.setForeground(new Color(66,170,33));
		pontuacao.setFont(new Font("Century Gothic",  Font. PLAIN,  22));
		pontuacao.setHorizontalAlignment(SwingConstants.CENTER);
		pontuacao.setVerticalAlignment(SwingConstants.CENTER);
		
		sair = (new JButton("Sair"));
		sair.setBounds(w-150,15,100,30);
		sair.setBackground(new Color(230,230,230));
		sair.setForeground(new Color(66,170,33));
		sair.setFont(new Font("Century Gothic",  Font. PLAIN,  18));
		sair.setBorder(new LineBorder(new Color(66,170,33), 2, false));
		sair.setFocusPainted(false);
		sair.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				sair.setBackground(new Color(66,170,33));
				sair.setForeground(new Color(230,230,230));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				sair.setBackground(new Color(230,230,230));
				sair.setForeground(new Color(66,170,33));
				 
			}
		});
		sair.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
				
					iniciado = true;
					
					Efeitos f = new Efeitos();
					
					f.setEntrada(1);
					f.setSaida(2);
					f.setEscolhaE(2);
					
					f.transicaoReducao(); 
				
				}
				
			}
					
		});
		
		jogar = new JLabel("Jogar");
		jogar.setBounds((w/2)-100,(this.getHeight()/2)-250,200,60);
		jogar.setForeground(new Color(66,170,33));
		jogar.setFont(new Font("Century Gothic",  Font. PLAIN,  50));
		jogar.setHorizontalAlignment(SwingConstants.CENTER);
		jogar.setVerticalAlignment(SwingConstants.CENTER);
		
		descJogar = new JLabel("Escolha o nivel de jogo.");
		descJogar.setBounds((w/2)-200,(this.getHeight()/2)-150,400,60);
		descJogar.setForeground(new Color(20,20,20));
		descJogar.setFont(new Font("Century Gothic",  Font. PLAIN,  25));
		descJogar.setHorizontalAlignment(SwingConstants.CENTER);
		descJogar.setVerticalAlignment(SwingConstants.CENTER);
		
		int centro = (w-(((w/100)*15)*5))/4;
		
		hoverDesc.setFont(new Font("Century Gothic",  Font. PLAIN,  22));
		hoverDesc.setForeground(new Color(255,255,255));
		hoverDesc.setOpaque(true);
		hoverDesc.setVisible(false);
		hoverDesc.setHorizontalAlignment(SwingConstants.CENTER);
		hoverDesc.setVerticalAlignment(SwingConstants.CENTER);
		
		
		nivel1 = (new JButton("M"));
		nivel1.setBounds(centro,(this.getHeight()/2)-50,(w/100)*15,(w/100)*15);
		nivel1.setBackground(new Color(255,255,255));
		nivel1.setForeground(new Color(2,123,208));
		nivel1.setFont(new Font("Century Gothic",  Font. PLAIN,  100));
		nivel1.setBorder(new LineBorder(new Color(2,123,208), 4, false));
		nivel1.setHorizontalAlignment(SwingConstants.CENTER);
		nivel1.setVerticalAlignment(SwingConstants.CENTER);
		nivel1.setFocusPainted(false);
		nivel1.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 hoverDesc.setBounds(nivel1.getLocation().x,nivel1.getLocation().y+nivel1.getHeight(),nivel1.getWidth(),60);
				 hoverDesc.setBackground(new Color(2,123,208));
				 hoverDesc.setText("Mosquito");
				 hoverDesc.setVisible(true);
				 
				 nivel1.setBackground(new Color(2,123,208));
				 nivel1.setForeground(new Color(255,255,255));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				
				 if(iniciado == false){
				 
					 nivel1.setBackground(new Color(255,255,255));
					 nivel1.setForeground(new Color(2,123,208));
					 hoverDesc.setVisible(false);
				 
				 }
				 
			}
		});
		nivel1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
					
					iniciado = true;
				
					Efeitos f = new Efeitos();
					LogicaMemoria l = new LogicaMemoria();
					
					l.nivel = 1;
					f.setEscolhaE(1);
					Jogos.cores = new Color(2,123,208);
					Jogos.cores2 = new Color(2,74,124);
					Jogos.cores3 = new Color(2,123,208,250);
					ControladorFrame.cor1 = new Color(2,123,208);
					ControladorFrame.cor2 = new Color(2,74,124);
					
					f.iniciaJogo();
					
				}
				
			}
			
		});
		
		nivel2 = (new JButton("D"));
		nivel2.setBounds(nivel1.getLocation().x+((w/100)*15)+50,(this.getHeight()/2)-50,(w/100)*15,(w/100)*15);
		nivel2.setBackground(new Color(255,255,255));
		nivel2.setForeground(new Color(243,22,38));
		nivel2.setFont(new Font("Century Gothic",  Font. PLAIN,  100));
		nivel2.setBorder(new LineBorder(new Color(243,22,38), 4, false));
		nivel2.setHorizontalAlignment(SwingConstants.CENTER);
		nivel2.setVerticalAlignment(SwingConstants.CENTER);
		nivel2.setFocusPainted(false);
		nivel2.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 hoverDesc.setBounds(nivel2.getLocation().x,nivel2.getLocation().y+nivel2.getHeight(),nivel2.getWidth(),60);
				 hoverDesc.setBackground(new Color(243,22,38));
				 hoverDesc.setText("Dengue");
				 hoverDesc.setVisible(true);
				 
				 nivel2.setBackground(new Color(243,22,38));
				 nivel2.setForeground(new Color(255,255,255));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(iniciado == false){
				 
					 nivel2.setBackground(new Color(255,255,255));
					 nivel2.setForeground(new Color(243,22,38));
					 hoverDesc.setVisible(false);
					 
				 }
				 
			}
		});
		nivel2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
					
					iniciado = true;
				
					Efeitos f = new Efeitos();
					LogicaMemoria l = new LogicaMemoria();
					
					l.nivel = 2;
					f.setEscolhaE(2);
					Jogos.cores = new Color(243,22,38);
					Jogos.cores2 = new Color(176,5,17);
					Jogos.cores3 = new Color(243,22,38,250);
					ControladorFrame.cor1 = new Color(243,22,38);
					ControladorFrame.cor2 = new Color(176,5,17);
					
					f.iniciaJogo();
					
				}
				
			}
			
		});
		
		nivel3 = (new JButton("F"));
		nivel3.setBounds(nivel2.getLocation().x+((w/100)*15)+50,(this.getHeight()/2)-50,(w/100)*15,(w/100)*15);
		nivel3.setBackground(new Color(255,255,255));
		nivel3.setForeground(new Color(255,174,0));
		nivel3.setFont(new Font("Century Gothic",  Font. PLAIN,  100));
		nivel3.setBorder(new LineBorder(new Color(255,174,0), 4, false));
		nivel3.setHorizontalAlignment(SwingConstants.CENTER);
		nivel3.setVerticalAlignment(SwingConstants.CENTER);
		nivel3.setFocusPainted(false);
		nivel3.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 hoverDesc.setBounds(nivel3.getLocation().x,nivel3.getLocation().y+nivel3.getHeight(),nivel3.getWidth(),60);
				 hoverDesc.setBackground(new Color(255,174,0));
				 hoverDesc.setText("Febre Amarela");
				 hoverDesc.setVisible(true);
				 
				 nivel3.setBackground(new Color(255,174,0));
				 nivel3.setForeground(new Color(255,255,255));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(iniciado == false){
				 
					 nivel3.setBackground(new Color(255,255,255));
					 nivel3.setForeground(new Color(255,174,0));
					 hoverDesc.setVisible(false);
					 
				 }
				 
			}
		});
		nivel3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
					
					iniciado = true;
				
					Efeitos f = new Efeitos();
					LogicaMemoria l = new LogicaMemoria();
					
					l.nivel = 3;
					f.setEscolhaE(3);
					Jogos.cores = new Color(255,174,0);
					Jogos.cores2 = new Color(192,132,3);
					Jogos.cores3 = new Color(255,174,0,250);
					ControladorFrame.cor1 = new Color(255,174,0);
					ControladorFrame.cor2 = new Color(192,132,3);
					
					f.iniciaJogo();
					
				}
				
			}
			
		});
		
		nivel4 = (new JButton("Z"));
		nivel4.setBounds(nivel3.getLocation().x+((w/100)*15)+50,(this.getHeight()/2)-50,(w/100)*15,(w/100)*15);
		nivel4.setBackground(new Color(255,255,255));
		nivel4.setForeground(new Color(130,81,187));
		nivel4.setFont(new Font("Century Gothic",  Font. PLAIN,  100));
		nivel4.setBorder(new LineBorder(new Color(130,81,187), 4, false));
		nivel4.setHorizontalAlignment(SwingConstants.CENTER);
		nivel4.setVerticalAlignment(SwingConstants.CENTER);
		nivel4.setFocusPainted(false);
		nivel4.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 hoverDesc.setBounds(nivel4.getLocation().x,nivel4.getLocation().y+nivel4.getHeight(),nivel4.getWidth(),60);
				 hoverDesc.setBackground(new Color(130,81,187));
				 hoverDesc.setText("Zika v�rus");
				 hoverDesc.setVisible(true);
				 
				 nivel4.setBackground(new Color(130,81,187));
				 nivel4.setForeground(new Color(255,255,255));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				
				 if(iniciado == false){
				 
					 nivel4.setBackground(new Color(255,255,255));
					 nivel4.setForeground(new Color(130,81,187));
					 hoverDesc.setVisible(false);
					 
				 }
				 
			}
		});
		nivel4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
					
					iniciado = true;
				
					Efeitos f = new Efeitos();
					LogicaMemoria l = new LogicaMemoria();
					
					l.nivel = 4;
					f.setEscolhaE(4);
					Jogos.cores = new Color(130,81,187);
					Jogos.cores2 = new Color(65,25,110);
					Jogos.cores3 = new Color(130,81,187,250);
					ControladorFrame.cor1 = new Color(130,81,187);
					ControladorFrame.cor2 = new Color(65,25,110);
					
					f.iniciaJogo();
					
				}
				
			}
			
		});
		
		nivel5 = (new JButton("C"));
		nivel5.setBounds(nivel4.getLocation().x+((w/100)*15)+50,(this.getHeight()/2)-50,(w/100)*15,(w/100)*15);
		nivel5.setBackground(new Color(255,255,255));
		nivel5.setForeground(new Color(66,170,33));
		nivel5.setFont(new Font("Century Gothic",  Font. PLAIN,  100));
		nivel5.setBorder(new LineBorder(new Color(66,170,33), 4, false));
		nivel5.setHorizontalAlignment(SwingConstants.CENTER);
		nivel5.setVerticalAlignment(SwingConstants.CENTER);
		nivel5.setFocusPainted(false);
		nivel5.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 hoverDesc.setBounds(nivel5.getLocation().x,nivel5.getLocation().y+nivel5.getHeight(),nivel5.getWidth(),60);
				 hoverDesc.setBackground(new Color(66,170,33));
				 hoverDesc.setText("Chickunguya");
				 hoverDesc.setVisible(true);
				 
				 nivel5.setBackground(new Color(66,170,33));
				 nivel5.setForeground(new Color(255,255,255));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(iniciado == false){
				 
					 nivel5.setBackground(new Color(255,255,255));
					 nivel5.setForeground(new Color(66,170,33));
					 hoverDesc.setVisible(false);
					 
				 }
				 
			}
		});
		nivel5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
					
					iniciado = true;
				
					Efeitos f = new Efeitos();
					LogicaMemoria l = new LogicaMemoria();
					
					l.nivel = 5;
					f.setEscolhaE(5);
					Jogos.cores = new Color(66,170,33);
					Jogos.cores2 = new Color(33,112,8);
					Jogos.cores3 = new Color(66,170,33,250);
					ControladorFrame.cor1 = new Color(66,170,33);
					ControladorFrame.cor2 = new Color(33,112,8);
					
					f.iniciaJogo();
					
				}
				
			}
			
		});
		
		//tratamento bot�o
		
		tratamento = (new JButton("Tratamentos/Preven��o"));
		tratamento.setBounds(0,this.getHeight()-8,w+2,50);
		tratamento.setBackground(new Color(60,60,60));
		tratamento.setForeground(new Color(255,255,255));
		tratamento.setFont(new Font("Century Gothic",  Font. PLAIN,  30));
		tratamento.setBorder(new LineBorder(new Color(60,60,60), 4, false));
		tratamento.setHorizontalAlignment(SwingConstants.CENTER);
		tratamento.setVerticalAlignment(SwingConstants.CENTER);
		tratamento.setFocusPainted(false);
		tratamento.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 tratamento.setBackground(new Color(120,120,120));
				 tratamento.setForeground(new Color(255,255,255));
				 tratamento.setBorder(new LineBorder(new Color(120,120,120), 4, false));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 tratamento.setBackground(new Color(60,60,60));
				 tratamento.setForeground(new Color(255,255,255));
				 tratamento.setBorder(new LineBorder(new Color(60,60,60), 4, false));
				 
			}
		});
		tratamento.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				if(iniciado == false){
					
					iniciado = true;
				
					Efeitos f = new Efeitos();
					
					f.setEntrada(4);
					f.setSaida(2);
					f.setEscolhaE(4);
					
					f.transicaoReducao();
					
				}
				
			}
			
		});
		
		this.add(nivel1);
		this.add(nivel2);
		this.add(nivel3);
		this.add(nivel4);
		this.add(nivel5);
		this.add(hoverDesc);
		this.add(tratamento);
		this.add(jogar);
		this.add(descJogar);
		this.add(sair);
		this.add(estrela);
		this.add(pontuacao);
		this.add(nomeUser);
		this.add(cabecalho);
		
		this.setBackground(new Color(255,255,255)); 
		
	}
	
}
