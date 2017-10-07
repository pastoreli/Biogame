package br.com.etecGuainazes.BioGame.View;

import java.awt.Color;
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

import br.com.etecGuainazes.BioGame.Controller.Efeitos;

public class Splash extends JFrame implements ActionListener{

	JPanel frame = new JPanel();
	
	static JButton fechar, minimizar;
	
	public static JLabel folks, barra, bio;
	
	Efeitos efeitos = new Efeitos();
	
	public Splash(){
	
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("img/iconeB.png"));
		
		this.setLayout(null);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		
		frame.setLayout(null);
		frame.setBounds(0, 0, this.getWidth(), this.getHeight());
		frame.setBackground(new Color(66,170,33));
		this.add(frame);
		
		fechar = (new JButton());
		fechar.setIcon(new ImageIcon("img/close2.png"));
		fechar.addActionListener(this);
		fechar.setBounds(frame.getWidth()-52,10,50,22);
		fechar.setContentAreaFilled(false);
		fechar.setFocusPainted(false);
		fechar.setBorder(null);
		fechar.setBorderPainted(false); 
		fechar.setOpaque(false);	
		fechar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 fechar.setIcon(new ImageIcon("img/close3.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 fechar.setIcon(new ImageIcon("img/close2.png"));
				 
			}
		});
		frame.add(fechar);
		
		minimizar = (new JButton());
		minimizar.setIcon(new ImageIcon("img/minimizar2.png"));
		minimizar.addActionListener(this);
		minimizar.setBounds(frame.getWidth()-102,10,50,22);
		minimizar.setContentAreaFilled(false);
		minimizar.setFocusPainted(false);
		minimizar.setBorder(null);
		minimizar.setBorderPainted(false);
		minimizar.setOpaque(false);	 
		minimizar.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 minimizar.setIcon(new ImageIcon("img/minimizar3.png"));
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 minimizar.setIcon(new ImageIcon("img/minimizar2.png"));
				 
			}
		});
		frame.add(minimizar);
		
		folks = new JLabel();
		folks.setBounds(105, 105, 305, 310);
		folks.setIcon(new ImageIcon("img/folks.png"));
		frame.add(folks);
		
		bio = new JLabel();
		bio.setBounds(500, 105, 305, 310);
		bio.setIcon(new ImageIcon("img/bioGame.png"));
		frame.add(bio);
		
		barra = new JLabel();
		barra.setBounds(0,460, 0, 2);
		barra.setOpaque(true);
		frame.add(barra);
		
		this.setUndecorated(true);  
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
		this.setResizable(false);
		this.setBackground(new Color(2,123,208));
		
	}

	@Override
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