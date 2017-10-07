package br.com.etecGuainazes.BioGame.Controller;

import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import br.com.etecGuainazes.BioGame.View.ControladorFrame;

public class LogicaMemoria {

	ControladorFrame controle;
	
	Vitoria vitoria = new Vitoria();
	
	public static int nivel;
	
	public static int numeroB;
	
	public static boolean virada = false, iniciou = false;
	
	int delay = 1;
	
	int interval = 100;
	
	// imagens dos botões
	String[] imgs;
	String imgB[];
	boolean[] verificaV;
	
	//para erro
	int indexB1, indexB2;
	
	Timer timer = new Timer();
	
	Timer timer2 = new Timer();
	
	//para o jogo
	int guardaN;
	public static int tipoImg;
	
	public void start(){
			
		tipoImg = 0;
		
			if(nivel == 1){
				
				if(iniciou == false){
					
					imgs = new String[]{"imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg"};
					
					
					iniciou = true;
					
					imgB = new String[8];
				
					verificaV = new boolean[]{false, false, false, false, false, false, false, false};
					
					Random espalhar = new Random();
					
					int roda=0;
					
					while(roda<8){
					
						int roleta = espalhar.nextInt(7);
						
						int valida=0;
						
						for(int i=0; i<8; i++){
						
							if(i == roda){
								
								imgB[i] = imgs[roleta];
								roda++;
								break;
								
							}
							
							if(imgB[i].equals(imgs[roleta])){
								
								if(valida < 1){
									
									valida++;
									
								}else{
									
									break;
									
								}
								
							}
							
						}
						
					}
					
				}
				
				if(verificaV[numeroB] == false){
				
					rotacao();
					
				}
					
			}else if(nivel == 2){
				
				if(iniciou == false){
					
					imgs = new String[]{"imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png"};
					
					iniciou = true;
					
					imgB = new String[10];
				
					verificaV = new boolean[]{false, false, false, false, false, false, false, false, false, false};
					
					Random espalhar = new Random();
					
					int roda=0;
					
					while(roda<10){
					
						int roleta = espalhar.nextInt(9);
						
						int valida=0;
						
						for(int i=0; i<10; i++){
						
							if(i == roda){
								
								imgB[i] = imgs[roleta];
								roda++;
								break;
								
							}
							
							if(imgB[i].equals(imgs[roleta])){
								
								if(valida < 1){
									
									valida++;
									
								}else{
									
									break;
									
								}
								
							}
							
						}
						
					}
					
				}
				
				if(verificaV[numeroB] == false){
					
					rotacao();
					
				}
					
			}else{
				
				if(iniciou == false){
					
					switch(nivel){
					
						case 3:
						
							imgs = new String[]{"imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/grama.png", "imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/grama.png"};
							
						break;
						
						case 4:
							
							imgs = new String[]{"imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/grama.png", "imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/grama.png"};
							
						break;
						
						case 5:
						
						imgs = new String[]{"imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/grama.png", "imgM/garrafa.jpg", "imgM/caixa.jpg", "imgM/pnel.jpg", "imgM/vaso.jpg", "imgM/lixo.png", "imgM/grama.png"};
						
						break;
					
					}
					
					iniciou = true;
					
					imgB = new String[12];
				
					verificaV = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false};
					
					Random espalhar = new Random();
					
					int roda=0;
					
					while(roda<12){
					
						int roleta = espalhar.nextInt(11);
						
						int valida=0;
						
						for(int i=0; i<12; i++){
						
							if(i == roda){
								
								imgB[i] = imgs[roleta];
								roda++;
								break;
								
							}
							
							if(imgB[i].equals(imgs[roleta])){
								
								if(valida < 1){
									
									valida++;
									
								}else{
									
									break;
									
								}
								
							}
							
						}
						
					}
					
				}
				
				if(verificaV[numeroB] == false){
					
					rotacao();
					
				}
			
		}
			
	}
	
	//nivel1
	
	public void nivel1(){
		
		//validação
		if(virada == false){
			
				
				virada = true;
				guardaN = numeroB;
				verificaV[numeroB] = true;
			
		}else{
				
			virada = false;
				
			if(imgB[numeroB].equals(imgB[guardaN])){
					
				verificaV[numeroB] = true;
				
				for(int i=0; i<verificaV.length; i++){
					
					if(verificaV[i] == true){
						
						if(i==verificaV.length-1){
							
							vitoria.jogosG++;
							vitoria.vitoria();
							
						}
						
					}else{
						
						break;
						
					}
					
				}
					
			}else{
					
				indexB1 = guardaN;
				indexB2 = numeroB;
				
				rotacaoVolta();
				
				verificaV[guardaN] = false;
				
				Efeitos.retira = 30;
					
			}
			
		}
		
	}
	
	//nivel2
	public void nivel2(){
		
		//validação
		if(virada == false){

			if(verificaV[numeroB] == false){
			
				ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
				controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
				virada = true;
				guardaN = numeroB;
				verificaV[numeroB] = true;
			
			}
			
		}else{
			
			if(verificaV[numeroB] == false){
				
				ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
				controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
				virada = false;
				
				if(imgB[numeroB].equals(imgB[guardaN])){
					
					verificaV[numeroB] = true;
					
					for(int i=0; i<verificaV.length; i++){
						
						if(verificaV[i] == true){
							
							if(i==verificaV.length-1){
								
								vitoria.jogosG++;
								vitoria.vitoria();
								
							}
							
						}else{
							
							break;
							
						}
						
					}
					
				}else{
					
					indexB1 = guardaN;
					indexB2 = numeroB;
					
					rotacaoVolta();
					verificaV[guardaN] = false;
					Efeitos.retira = 30;
					
				}
				
			}
			
		}
		
	}
	
	//nivelis 3, 4 e 5

		public void outrosNiveis(){
			
			//validação
			if(virada == false){

				if(verificaV[numeroB] == false){
				
					ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
					controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
					virada = true;
					guardaN = numeroB;
					verificaV[numeroB] = true;
				
				}
				
			}else{
				
				if(verificaV[numeroB] == false){
					
					ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
					controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
					virada = false;
					
					if(imgB[numeroB].equals(imgB[guardaN])){
						
						verificaV[numeroB] = true;
						
						for(int i=0; i<verificaV.length; i++){
							
							if(verificaV[i] == true){
								
								if(i==verificaV.length-1){
									
									vitoria.jogosG++;
									vitoria.vitoria();
									
								}
								
							}else{
								
								break;
								
							}
							
						}
						
					}else{
						
						indexB1 = guardaN;
						indexB2 = numeroB;
						
						rotacaoVolta();
						verificaV[guardaN] = false;
						Efeitos.retira = 30;
						
					}
					
				}
				
			}
			
		}
		
		
		//efeitos
		public void rotacao(){
			
			timer.scheduleAtFixedRate(new TimerTask(){
				
				public void run(){
					
					if(tipoImg == 0){
						
						ImageIcon imgCapa = new ImageIcon("imgM/capa.jpg");
						controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/3,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						
						tipoImg++;
						
					}else if(tipoImg==1){
							
						ImageIcon imgCapa = new ImageIcon("imgM/capa.jpg");
						controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/5,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
							
						tipoImg++;
							
					}else if(tipoImg==2){
								
						ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
						controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/5,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
								
						tipoImg++;
								
					}else if(tipoImg==3){
									
						ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
						controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/3,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
									  
						tipoImg++;
									
					}else if(tipoImg==4){
									
						ImageIcon imgCapa = new ImageIcon(imgB[numeroB]);
						controle.pMemoria.pecas[numeroB].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						
						tipoImg++;						
				
					}else{
						
						cancel();	
						
						if(nivel == 1){
						
							nivel1();
						
						}else if(nivel == 2){
							
							nivel2();
							
						}else{
							
							outrosNiveis();
							
						}
						
						tipoImg = 0;
						
					}
				
				}
				
			},delay,interval);
			
		}
		
		public void rotacaoVolta(){
			
			tipoImg = 0;
			
			timer2.scheduleAtFixedRate(new TimerTask(){
				
				public void run(){
					
					if(tipoImg == 0){
						
						ImageIcon imgCapa = new ImageIcon(imgB[indexB1]);
						controle.pMemoria.pecas[indexB1].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/3,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						imgCapa = new ImageIcon(imgB[indexB2]);
						controle.pMemoria.pecas[indexB2].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/3,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						
						tipoImg++;
						
					}else if(tipoImg==1){
							
						ImageIcon imgCapa = new ImageIcon(imgB[indexB1]);
						controle.pMemoria.pecas[indexB1].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/5,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						imgCapa = new ImageIcon(imgB[indexB2]);
						controle.pMemoria.pecas[indexB2].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/5,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						
						tipoImg++;
							
					}else if(tipoImg==2){
								
						ImageIcon imgCapa = new ImageIcon("imgM/capa.jpg");
						controle.pMemoria.pecas[indexB1].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/5,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						controle.pMemoria.pecas[indexB2].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/5,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
							
						tipoImg++;
								
					}else if(tipoImg==3){
									
						ImageIcon imgCapa = new ImageIcon("imgM/capa.jpg");
						controle.pMemoria.pecas[indexB1].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/3,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						controle.pMemoria.pecas[indexB2].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth()/3,controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
									  
						tipoImg++;
									
					}else{
									
						ImageIcon imgCapa = new ImageIcon("imgM/capa.jpg");
						controle.pMemoria.pecas[indexB1].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
						controle.pMemoria.pecas[indexB2].setIcon(new ImageIcon(imgCapa.getImage().getScaledInstance(controle.pMemoria.pecas[numeroB].getWidth(),controle.pMemoria.pecas[numeroB].getHeight(), Image.SCALE_DEFAULT)));
									
						cancel();	
						tipoImg = 0;
									
						
					}	
				
				}
				
			},delay,interval);
			
		}
	
}
