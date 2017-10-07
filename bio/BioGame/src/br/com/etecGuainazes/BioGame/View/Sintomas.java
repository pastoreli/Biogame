package br.com.etecGuainazes.BioGame.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.com.etecGuainazes.BioGame.Controller.Efeitos;
import br.com.etecGuainazes.BioGame.Controller.LogicaMemoria;
import br.com.etecGuainazes.BioGame.Controller.Vitoria;

public class Sintomas extends JPanel{

	LogicaMemoria logica = new LogicaMemoria();
	Jogos jogos;
	Vitoria vitoria = new Vitoria();
	
	JLabel ajuda;
	
	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	//arrasta
	private static final long serialVersionUID = 1L; 
    private int x;  
    private int y; 
    
    boolean ganhou=false;
    
    JLabel div, resultado;
    JButton verifica;
    
    public static JButton sintomasB[];
    
    String descSintomas[];
    int cont[], roleta, qtdSintomas;
	
	public Sintomas(){
		
		this.setLayout(null);
		this.setBounds(w,0,w+2,h-140);
		this.setBackground(new Color(255,255,255));
			
			int centralizar = (this.getWidth()/2) - (((this.getWidth()/100)*15)/2)*5;
			
			sintomasB = new JButton[15];
			
			if(logica.nivel == 2){
				descSintomas = new String[]{"Febre alta", "Dores de cabeça", "Dores atrás dos olhos", "Perda de apetite", "Manchas na pele", "Náuseas e vômito", "Tonturas", "Cansaço", "Moleza e dor no corpo", "Dor nos ossos e articulaçoes", "Baixa pressão", "Alucinações", "Desmaios", "Dores no estômago", "Resfriado"};
				qtdSintomas = 10;
			}else if(logica.nivel == 3){
				descSintomas = new String[]{"Febre alta", "Calafrios", "Cansaço", "Dores de cabeça", "Dores muscular", "Náuseas", "Dores no corpo", "Icterícia", "Hemorragias", "Vômitos", "Perda de memória", "Resfriado", "Sono", "Manchas roxas", "Dores nos olhos"};
				qtdSintomas = 10;
			}else if(logica.nivel == 4){
				descSintomas = new String[]{"Febre", "Erupções", "Vermelhidão", "Coceira na pele", "Dores nas articulações ", "Conjuntivite", "Vômito", "Resfriado", "Dores de estômago", "Sono", "Falta de apetite", "Baixa pressão", "Sensações de cansaço", "Desmaios", "Icterícia"};
				qtdSintomas = 6;
			}else{
				descSintomas = new String[]{"Febre alta", "Dores nas articulações", "Dores de cabeça", "Manchas na pele ", "Dores musculares", "Icterícia", "Vômito", "Desmaios", "Sono", "Resfriado", "Tonturas", "Dores nos olhos", "Falta de apetite", "Baixa pressão", "Cansaço"};
				qtdSintomas = 5;
			}
			
			cont = new int[15];
			
			Random espalhar = new Random();
			int roda=0;
			
			while(roda<sintomasB.length){
				
				roleta = espalhar.nextInt(sintomasB.length);
					
					if(cont[roleta]==0){
					
						cont[roleta] = 1;
						sintomasB[roda] = new JButton(descSintomas[roleta]);
						
						if(roda == 0){
							sintomasB[roda].setBounds(centralizar, (this.getHeight()/2)+((((this.getHeight()/100)*8)*3)/2)+10, (this.getWidth()/100)*15, (this.getHeight()/100)*8);
						}else if(roda < 5){
							sintomasB[roda].setBounds(sintomasB[roda-1].getLocation().x+((this.getWidth()/100)*15)+8, sintomasB[roda-1].getLocation().y, (this.getWidth()/100)*15, (this.getHeight()/100)*8);
						}else if(roda == 5){
							sintomasB[roda].setBounds(centralizar, sintomasB[roda-1].getLocation().y+((this.getHeight()/100)*8)+10, (this.getWidth()/100)*15, (this.getHeight()/100)*8);
						}else if(roda < 10){
							sintomasB[roda].setBounds(sintomasB[roda-1].getLocation().x+((this.getWidth()/100)*15)+8, sintomasB[roda-1].getLocation().y, (this.getWidth()/100)*15, (this.getHeight()/100)*8);
						}else if(roda == 10){
							sintomasB[roda].setBounds(centralizar, sintomasB[roda-1].getLocation().y+((this.getHeight()/100)*8)+10, (this.getWidth()/100)*15, (this.getHeight()/100)*8);
						}else{
							sintomasB[roda].setBounds(sintomasB[roda-1].getLocation().x+((this.getWidth()/100)*15)+8, sintomasB[roda-1].getLocation().y, (this.getWidth()/100)*15, (this.getHeight()/100)*8);
						}
						
						sintomasB[roda].setBackground(new Color(255,255,255));
						sintomasB[roda].setForeground(jogos.cores);
						sintomasB[roda].setFocusPainted(false);
						sintomasB[roda].setFont(new Font("Century Gothic",  Font. PLAIN, (sintomasB[0].getWidth()/14)));
						sintomasB[roda].setBorder(new LineBorder(jogos.cores, 2, true));
						sintomasB[roda].setHorizontalAlignment(SwingConstants.CENTER);
						sintomasB[roda].setVerticalAlignment(SwingConstants.CENTER);
						
						sintomasB[roda].addMouseMotionListener(new MouseMotionListener(){

							@Override
							public void mouseDragged(MouseEvent e) {
								
									if (e.getX() - x == 0 || e.getX() - x == 0) {  
						                x = e.getX();  
						            }  
						            if (e.getY() - y == 0 || e.getY() - y == 0) {  
						                y = e.getY();  
						            }  
						           
						            if(ControladorFrame.pJogos.barra.getWidth() > 0){
						            	sintomasB[roleta].setLocation(sintomasB[roleta].getX() + (e.getX() - x), sintomasB[roleta].getY() + (e.getY() - y)); 
						            }else{
						            	sintomasB[roleta].setVisible(false);
						            }
						            	
							}

							@Override
							public void mouseMoved(MouseEvent e) {
							}

						});
						sintomasB[roda].addMouseListener(new MouseListener(){

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
								
								ajuda.setVisible(false);
								
								for(int i=0; i<sintomasB.length;i++){
									
									if(((JButton)e.getSource()).getText().equals(sintomasB[i].getText())){
										
										roleta = i;
										
									}
									
								}

								 if(ControladorFrame.pJogos.barra.getWidth() > 0){
									sintomasB[roleta].setBackground(new Color(255,255,255));
									sintomasB[roleta].setBorder(new LineBorder(jogos.cores2, 2, true));
									sintomasB[roleta].setForeground(jogos.cores2);
								
									 x = e.getX();  
							         y = e.getY(); 
							         
								 }else{
							      
									 sintomasB[roleta].setVisible(false);
							    	  
							      }
								
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								
								sintomasB[roleta].setBorder(new LineBorder(jogos.cores, 2, true));
								sintomasB[roleta].setForeground(jogos.cores2);
								
							}
								
						});  
						
						this.add(sintomasB[roda]);
						
						roda++;
					
					}
				
			}
		
		div = new JLabel();
		div.setOpaque(true);
		div.setBounds(0,this.getHeight()/2,this.getWidth(),2);
		div.setBackground(jogos.cores);
		
		
		resultado = (new JLabel("0/"+qtdSintomas));
		resultado.setBounds(this.getWidth()-200,20,200,100);
		resultado.setForeground(jogos.cores);
		resultado.setFont(new Font("Century Gothic",  Font. PLAIN,  50));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setVerticalAlignment(SwingConstants.CENTER);
		this.add(resultado);
		
		verifica = (new JButton("Verificar"));
		verifica.setBounds((this.getWidth()/2)-50,(this.getHeight()/2)-15,100,30);
		verifica.setFocusPainted(false);
		verifica.setBackground(new Color(255,255,255));
		verifica.setForeground(jogos.cores);
		verifica.setFont(new Font("Century Gothic",  Font. PLAIN,  18));
		verifica.setBorder(new LineBorder(jogos.cores, 2, false));
		verifica.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(ControladorFrame.pJogos.barra.getWidth() <= 0){
					 
					 verifica.setVisible(false);
					 
				 }
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(ControladorFrame.pJogos.barra.getWidth() <= 0){
					 
					 verifica.setVisible(false);
					 
				 }
			}   
			  
	      });   
		verifica.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseEntered(MouseEvent e) {
				 
				 if(ControladorFrame.pJogos.barra.getWidth() > 0){
				 
					 verifica.setBackground(jogos.cores);
					 verifica.setForeground(new Color(255,255,255));
				 
				 }else{
					 
					 verifica.setVisible(false);
					 
				 }
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(ControladorFrame.pJogos.barra.getWidth() > 0){
				 
					 verifica.setBackground(new Color(255,255,255));
					 verifica.setForeground(jogos.cores);
					 
				 }else{
					 
					 verifica.setVisible(false);
					 
				 }
				 
			}
		});
		verifica.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				int acertos=0;
				
				for(int i=0; i<sintomasB.length; i++){
					
					for(int q=0; q<qtdSintomas; q++){
						
						if(sintomasB[i].getText().equals(descSintomas[q])){
							
							if(sintomasB[i].getLocation().y < div.getLocation().y-40){
								
								acertos++;
								
							}
							
						}
						
					}
					
				}
				
				resultado.setText(acertos+"/"+qtdSintomas);
				
				int contV=0;
				
				if(acertos == qtdSintomas){
					
					for(int i=0; i<sintomasB.length; i++){
						
						if(sintomasB[i].getLocation().y < div.getLocation().y-40){
							
							contV++;
							
						}
						
					}
					
					if(contV==qtdSintomas){
						
						if(ganhou == false){
						
							verifica.setText("Parabéns");
							
							vitoria.jogosG++;
							vitoria.vitoria();
							ganhou=true;
						
						}
						
					}else{
						
						Efeitos.retira=30;
						
					}
					
				}else{
					
					Efeitos.retira=30;
					
				}
				
			}
					
		});
		
		this.add(verifica);
		this.add(div);
		
		ajuda = new JLabel("Arraste os sintomas da doença aqui.");
		ajuda.setBounds(0,((this.getHeight()/2)/2)-30,this.getWidth(),60);
		ajuda.setForeground(new Color(200,200,200));
		ajuda.setFont(new Font("Century Gothic",  Font. PLAIN,  30));
		ajuda.setHorizontalAlignment(SwingConstants.CENTER);
		ajuda.setVerticalAlignment(SwingConstants.CENTER);
		this.add(ajuda);
		
	}
	
}
