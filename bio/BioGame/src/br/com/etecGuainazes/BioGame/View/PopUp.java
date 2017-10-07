package br.com.etecGuainazes.BioGame.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PopUp extends JPanel{

	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	Jogos jogos;
	public  JPanel popUp = new JPanel(), derrotaPop = new JPanel();
	
	public  JLabel trofeu, parabens, estrela, pontos, medalha, imgMedalha;
	
	JLabel lose, derrotaD;
	
	public PopUp(){
		
		this.setLayout(null);
		this.setBounds(0,0,w+2,h-100);
		this.setBackground(new Color(243,22,38,0));
		this.setVisible(false);
		this.setFocusable(true);
		this.requestFocus();
		this.grabFocus();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}   
			  
	      });   
		
		popUp.setLayout(null);
		popUp.setBounds(0,(this.getHeight()/2)-175,0,350);
		popUp.setBackground(jogos.cores3);
		popUp.setVisible(false);
		this.add(popUp);
		
		parabens = new JLabel("Parabéns");
		parabens.setBounds((w/2)-100, 20, 200, 60);
		parabens.setForeground(new Color(255,255,255));
		parabens.setFont(new Font("Century Gothic",  Font. PLAIN,  35));
		parabens.setHorizontalAlignment(SwingConstants.CENTER);
		parabens.setVerticalAlignment(SwingConstants.CENTER);
		popUp.add(parabens);
		
		trofeu = new JLabel();
		trofeu.setBounds(w-320,50,250,250);
		ImageIcon imgTrofeu = new ImageIcon("img/trofeu.png");
		trofeu.setIcon(new ImageIcon(imgTrofeu.getImage().getScaledInstance(trofeu.getWidth(),trofeu.getHeight(), Image.SCALE_DEFAULT)));
		popUp.add(trofeu);
		
		estrela = new JLabel();
		estrela.setBounds(100,120,60,60);
		ImageIcon imgEstrela = new ImageIcon("img/estrelaPop.png");
		estrela.setIcon(new ImageIcon(imgEstrela.getImage().getScaledInstance(estrela.getWidth(),estrela.getHeight(), Image.SCALE_DEFAULT)));
		popUp.add(estrela);
		
		pontos = new JLabel();
		pontos.setBounds(80, 170, 100, 60);
		pontos.setForeground(new Color(255,255,255));
		pontos.setFont(new Font("Century Gothic",  Font. PLAIN,  30));
		pontos.setHorizontalAlignment(SwingConstants.CENTER);
		pontos.setVerticalAlignment(SwingConstants.CENTER);
		popUp.add(pontos);
		
		imgMedalha = new JLabel();
		imgMedalha.setBounds((w/2)-40,175-20,80,80);
		ImageIcon imgMedal = new ImageIcon("img/medalha.png");
		imgMedalha.setIcon(new ImageIcon(imgMedal.getImage().getScaledInstance(imgMedalha.getWidth(),imgMedalha.getHeight(), Image.SCALE_DEFAULT)));
		popUp.add(imgMedalha);
		
		medalha = new JLabel("Tratamento/Prevenção liberado");
		medalha.setBounds((w/2)-200,175+50, 400, 60);
		medalha.setForeground(new Color(255,255,255));
		medalha.setFont(new Font("Century Gothic",  Font. PLAIN,  25));
		medalha.setHorizontalAlignment(SwingConstants.CENTER);
		medalha.setVerticalAlignment(SwingConstants.CENTER);
		popUp.add(medalha);
		
		//derrota
		
		derrotaPop.setLayout(null);
		derrotaPop.setBounds(0,(this.getHeight()/2)-175,0,350);
		derrotaPop.setBackground(jogos.cores3);
		derrotaPop.setVisible(false);
		this.add(derrotaPop);
		
		derrotaD = new JLabel("Você perdeu!");
		derrotaD.setBounds((w/2)-200, 20, 400, 60);
		derrotaD.setForeground(new Color(255,255,255));
		derrotaD.setFont(new Font("Century Gothic",  Font. PLAIN,  35));
		derrotaD.setHorizontalAlignment(SwingConstants.CENTER);
		derrotaD.setVerticalAlignment(SwingConstants.CENTER);
		derrotaPop.add(derrotaD);
		
		lose = new JLabel();
		lose.setBounds((w/2)-100,175-100,200,200);
		ImageIcon imgLose = new ImageIcon("img/lose.png");
		lose.setIcon(new ImageIcon(imgLose.getImage().getScaledInstance(lose.getWidth(),lose.getHeight(), Image.SCALE_DEFAULT)));
		derrotaPop.add(lose);
		
	}
	
}
