package br.com.etecGuainazes.BioGame.View;

import java.awt.Color;
import java.awt.Component;
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
import br.com.etecGuainazes.BioGame.Controller.Vitoria;

public class Sequencia extends JPanel{
	
	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	Vitoria vitoria = new Vitoria();
	
	boolean ganhou=false;
	
	JLabel campo[];
	
	JButton verifica;
	
	//itens
	
	JLabel div;
	String[] imgs = {"imgA/ovo.jpg","imgA/larva.jpg","imgA/pupa.jpg","imgA/mosquito.jpg"};
	
	public static JButton pecas[];
	int roleta;
	
	//arrasta
	private static final long serialVersionUID = 1L; 
    private int x;  
    private int y; 
	
	public Sequencia(){			
	
		this.setLayout(null);
		this.setBounds(w,0,w+2,h-140);
		this.setBackground(new Color(255,255,255));
		
		div = new JLabel();
		div.setOpaque(true);
		div.setBounds(0,this.getHeight()/2,this.getWidth(),2);
		div.setBackground(new Color(2,123,208));
		
		//img
		
		ImageIcon imgPecas;
		
		pecas = new JButton[4];
		int descBtn = 0;
		int altura = (this.getHeight()/2)-((((this.getWidth()/100)*12)/2)*3), distancia = (this.getWidth()/100)*20;
		Random espalhar = new Random();
		int roda=0;
		int[] valida = {-1,-1,-1,-1};
		
		int centro2 = (this.getWidth()/2) - ((((this.getWidth()/100)*16)/2)*4)-75;
		int anterior=0;
		
		while(roda<pecas.length){
	
			roleta = espalhar.nextInt(4);
			
			for(int i=0; i<valida.length; i++){
				
				if(valida[i] == roleta){
					
					break;
					
				}
				
				if(i == valida.length-1){
					valida[roleta] = roleta;
					descBtn = roleta+1;
					pecas[roleta] = (new JButton());
					
					if(roda==0){
						pecas[roleta].setBounds(centro2,(this.getHeight()/2)+((this.getHeight()/4))-(((w/100)*18)/2),(w/100)*16,(w/100)*18);
						
					}else{
						pecas[roleta].setBounds(pecas[anterior].getLocation().x+((w/100)*16)+50,pecas[anterior].getLocation().y,(w/100)*16,(w/100)*18);
				
					}
					
					anterior = roleta;
					
					imgPecas = new ImageIcon(imgs[roleta]);
					pecas[roleta].setIcon(new ImageIcon(imgPecas.getImage().getScaledInstance(pecas[roleta].getWidth(),pecas[roleta].getHeight(), Image.SCALE_DEFAULT)));
					pecas[roleta].setFont(new Font("Century Gothic",  Font. PLAIN,  0));
					pecas[roleta].setContentAreaFilled(false);
					pecas[roleta].setBorder(new LineBorder(new Color(2,123,208), 4, false));
					pecas[roleta].setHorizontalAlignment(SwingConstants.CENTER);
					pecas[roleta].setVerticalAlignment(SwingConstants.CENTER);
					pecas[roleta].addMouseMotionListener(new MouseMotionListener(){

						@Override
						public void mouseDragged(MouseEvent e) {
							
							pecas[roleta].setBorder(new LineBorder(new Color(2,74,124), 4, false));

								if (e.getX() - x == 0 || e.getX() - x == 0) {  
					                x = e.getX();  
					            }  
					            if (e.getY() - y == 0 || e.getY() - y == 0) {  
					                y = e.getY();  
					            }  
					           
					            if(ControladorFrame.pJogos.barra.getWidth() > 0){
					            	pecas[roleta].setLocation(pecas[roleta].getX() + (e.getX() - x), pecas[roleta].getY() + (e.getY() - y)); 
					            }else{
					            	pecas[roleta].setVisible(false);
					            }
					            
						}

						@Override
						public void mouseMoved(MouseEvent e) {
						}

					});
					pecas[roleta].addMouseListener(new MouseListener(){

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
							
							for(int i=0; i<pecas.length;i++){
								
								if(((JButton)e.getSource()).getIcon().equals(pecas[i].getIcon())){
									
									roleta = i;
									
								}
								
							}
							
							if(ControladorFrame.pJogos.barra.getWidth() > 0){
							
								 x = e.getX();  
						         y = e.getY(); 
						         
							}else{
								
								pecas[roleta].setVisible(false);
								
							}
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							
							pecas[roleta].setBorder(new LineBorder(new Color(2,123,208), 4, false));
							
							for(int i=0; i<pecas.length; i++){
								
								if(pecas[roleta].getLocation().x > campo[i].getLocation().x-30 && pecas[roleta].getLocation().x < campo[i].getLocation().x+(campo[i].getWidth()/2) && pecas[roleta].getLocation().y > campo[i].getLocation().y-30 && pecas[roleta].getLocation().y < campo[i].getLocation().y+(campo[i].getHeight()/2)){
									
									pecas[roleta].setLocation(campo[i].getLocation());
									break;
									
								}
								
							}
							
						}
							
					});  
					
					this.add(pecas[roleta]);
					
					altura+=((this.getWidth()/100)*12)+10;
					if(roda==1){
						
						altura = (this.getHeight()/2)-((((this.getWidth()/100)*12)/2)*3);
						
					}
					
					roda++;
					
				}
				
			}
			
		}
		
		campo = new JLabel[4];
		int descLbl = 0, tamanho = (this.getWidth()/100)*80;
		
		int centro = (this.getWidth()/2) - ((((this.getWidth()/100)*16)/2)*4)-75;
		
		for(int i=0; i<campo.length; i++){
		
			descLbl++;
			
			campo[i] = (new JLabel(Integer.toString(descLbl)));
			
			if(i==0){
				campo[i].setBounds(centro,((this.getHeight()/2)/2)-(((w/100)*18)/2),(w/100)*16,(w/100)*18);
				
			}else{
				campo[i].setBounds(campo[i-1].getLocation().x+((w/100)*16)+50,campo[i-1].getLocation().y,(w/100)*16,(w/100)*18);
		
			}
			
			campo[i].setBackground(new Color(255,255,255));
			campo[i].setForeground(new Color(2,123,208));
			campo[i].setFont(new Font("Century Gothic",  Font. PLAIN,  100));
			campo[i].setBorder(new LineBorder(new Color(2,123,208), 4, false));
			campo[i].setHorizontalAlignment(SwingConstants.CENTER);
			campo[i].setVerticalAlignment(SwingConstants.CENTER);
			
			this.add(campo[i]);
			
		}
	
		verifica = (new JButton("Verificar"));
		verifica.setBounds((this.getWidth()/2)-50,(this.getHeight()/2)-15,100,30);
		verifica.setBackground(new Color(255,255,255));
		verifica.setForeground(new Color(2,123,208));
		verifica.setFocusPainted(false);
		verifica.setFont(new Font("Century Gothic",  Font. PLAIN,  18));
		verifica.setBorder(new LineBorder(new Color(2,123,208), 2, false));
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
				 
					 verifica.setBackground(new Color(2,123,208));
					 verifica.setForeground(new Color(255,255,255));
					 
				 }else{
					 
					 verifica.setVisible(false);
					 
				 }
				 
			 }
			 @Override
			 public void mouseExited(MouseEvent e) {
				 
				 if(ControladorFrame.pJogos.barra.getWidth() > 0){
				 
					 verifica.setBackground(new Color(255,255,255));
					 verifica.setForeground(new Color(2,123,208));
					 
				 }else{
					 
					 verifica.setVisible(false);
					 
				 }
				 
			}
		});
		verifica.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				boolean valido = false;
				
				for(int i=0; i<pecas.length; i++){
					
					if(campo[i].getLocation().equals(pecas[i].getLocation())){
						
						valido = true;
						
					}else{
						
						valido = false;
						break;
						
					}
					
				}
				
				if(valido == true){
					
					if(ganhou==false){
					
						verifica.setText("Parab�ns");
						
						vitoria.jogosG++;
						vitoria.vitoria();
						ganhou=true;
					
					}
					
				}else{
					
					Efeitos.retira = 30;
					
				}
				
			}
					
		});
		
		this.add(verifica);
		this.add(div);
		
	}
}
