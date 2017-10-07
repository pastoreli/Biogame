package br.com.etecGuainazes.BioGame.View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControladorFrame extends JFrame implements ActionListener {
	
	public static JButton fechar, minimizar, maximizar;
	
	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	public static JPanel cabecalho = new JPanel(); 
	public static JPanel telas = new JPanel();
	
	public static Login pLogin = new Login();
	
	public static Home pHome;
	public static Tratamentos pTratamento;
	
	public static Jogos pJogos;
	
	public static JogoMemoria pMemoria;
	public static Sequencia pSequencia;
	public static Sintomas pSintomas;
	
	public static Color cor1, cor2;
	
	public ControladorFrame(){
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img/iconeB.png"));
		
		this.setLayout(null);
		
		cabecalho.setLayout(null);
		cabecalho.setBounds(0,0, w,40);
		cabecalho.setBackground(new Color(230,230,230));
		
		cor1 = new Color(230,230,230);
		cor2 = new Color(210,210,210);
		
		fechar = (new JButton());
		fechar.setIcon(new ImageIcon("img/close.png"));
		fechar.addActionListener(this);
		fechar.setBounds(w-52,0,50,22);
		fechar.setBackground(cor1);
		fechar.setFocusPainted(false);
		fechar.setBorder(null);
		fechar.setBorderPainted(false); 
		fechar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 fechar.setIcon(new ImageIcon("img/close2.png"));
				 fechar.setBackground(new Color(232,17,35));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 fechar.setIcon(new ImageIcon("img/close.png"));
				 fechar.setBackground(cor1);
				 
			}
		});
		
		maximizar = (new JButton());
		maximizar.setIcon(new ImageIcon("img/maximizar.png"));
		maximizar.addActionListener(this);
		maximizar.setBounds(w-102,0,50,22);
		maximizar.setContentAreaFilled(false);
		maximizar.setFocusPainted(false);
		maximizar.setBorder(null);
		maximizar.setBorderPainted(false);
		maximizar.setOpaque(false);	   
		
		minimizar = (new JButton());
		minimizar.setIcon(new ImageIcon("img/minimizar.png"));
		minimizar.addActionListener(this);
		minimizar.setBounds(w-147,0,50,22);
		minimizar.setBackground(cor1);
		minimizar.setFocusPainted(false);
		minimizar.setBorder(null);
		minimizar.setBorderPainted(false);
		minimizar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 minimizar.setBackground(cor2);
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 minimizar.setBackground(cor1);
				 
			}
		});
		
		telas.setLayout(null);
		telas.setBackground(new Color(20,20,20));
		telas.setBounds(0, 40, w, h-40);
		
		cabecalho.add(fechar);
		cabecalho.add(maximizar);
		cabecalho.add(minimizar);
		telas.add(pLogin);
		this.add(telas);
	    this.add(cabecalho);
		
		this.setUndecorated(true);
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBackground(new Color(255,255,255));
		this.setVisible(false);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == fechar){
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
			
		}
		
		if(e.getSource() == minimizar){
			
			this.setState(this.ICONIFIED);
			
		}
		
	}

	
	
}
