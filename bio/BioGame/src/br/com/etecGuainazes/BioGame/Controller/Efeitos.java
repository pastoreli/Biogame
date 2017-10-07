package br.com.etecGuainazes.BioGame.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.omg.Messaging.SyncScopeHelper;

import br.com.etecGuainazes.BioGame.View.ControladorFrame;
import br.com.etecGuainazes.BioGame.View.Home;
import br.com.etecGuainazes.BioGame.View.JogoMemoria;
import br.com.etecGuainazes.BioGame.View.Jogos;
import br.com.etecGuainazes.BioGame.View.Login;
import br.com.etecGuainazes.BioGame.View.Sequencia;
import br.com.etecGuainazes.BioGame.View.Splash;
import br.com.etecGuainazes.BioGame.View.Tratamentos;

public class Efeitos {

	private int saida;
	private int entrada;
	private int escolhaE;

	Vitoria vitoria = new Vitoria();
	LogicaMemoria logica = new LogicaMemoria();
	
	int delay = 1, delay2 =1;
	
	int interval = 10, interval2 = 1;
	
	Timer timer = new Timer();
	
	static  int w = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth();
	static int h = (int) Toolkit.getDefaultToolkit ().getScreenSize ().getHeight ();
	
	public int getSaida() {
		
		return saida;
	
	}
	public void setSaida(int saida) {
	
		this.saida = saida;
	
	}
	public int getEntrada() {
	
		return entrada;
	
	}
	public void setEntrada(int entrada) {
	
		this.entrada = entrada;
	
	}
	
	public int getEscolhaE() {
		
		return escolhaE;
	
	}
	public void setEscolhaE(int escolhaE) {
	
		this.escolhaE = escolhaE;
	
	}
	
	public void transicaoReducao(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			int reduz = 0, reduz2 = 0;
			
			public void run(){
				
				if(reduz <= 20){
				
					reduz++;
					reduz2+=2;
					
					switch(getSaida()){
					
					case 1:
					
						ControladorFrame.pLogin.setBounds(reduz, reduz, w-reduz2, (h-40)-reduz2);
					
					break;
					
					case 2:
					
						ControladorFrame.pHome.setBounds(reduz, reduz, w-reduz2, (h-40)-reduz2);
						
					break;
					
					case 3:
						
						ControladorFrame.pJogos.setBounds(reduz, reduz, w-reduz2, (h-40)-reduz2);
						
					break;
					
					case 4:
						
						ControladorFrame.pTratamento.setBounds(reduz, reduz, w-reduz2, (h-40)-reduz2);
						
					break;
					
					}
				
				}else{
					
					this.cancel();
					
					switch(getEscolhaE()){
					
					case 1:
						
						transicaoTroca();
						
					break;
					
					case 2:
						
						transicaoVolta();
						
					break;
					
					case 3:
						
						transicaoAmpliacao();
						
					break;
					
					case 4:
						
						transicaoTrocaT();
						
					break;
					
					case 5:
						
						transicaoVoltaT();
						
					break;
					
					}
					
				}
//				this.setBounds(w+20,20,w-40,h-80);
//				this.setBounds(0,0,w,h-40);
				
				
			
			}
			
		},delay,interval);
		
	}
	
	public void transicaoTroca(){
		
		ControladorFrame.pHome = new Home();
		
		ControladorFrame.telas.add(ControladorFrame.pHome);
	
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(ControladorFrame.pHome.getLocation().x > 20){
				
					switch(getEntrada()){
					
					case 1:
						
						ControladorFrame.pLogin.setLocation(ControladorFrame.pLogin.getLocation().x-4, ControladorFrame.pLogin.getLocation().y);
						
						
					break;
					
					case 2:
					
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x-4, ControladorFrame.pHome.getLocation().y);
					
					break;
					
					}
					
					switch(getSaida()){
					
					case 1:
					
						ControladorFrame.pLogin.setLocation(ControladorFrame.pLogin.getLocation().x-4, ControladorFrame.pLogin.getLocation().y);
					
					break;
					
					case 2:
					
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x-4, ControladorFrame.pHome.getLocation().y);
						
						
					break;
						
					}
					
				}else{
					
					switch(getSaida()){
					
					case 1:
					
						ControladorFrame.pLogin.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pLogin);
					
					break;
					
					case 2:
						
						ControladorFrame.pHome.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pHome);
						
					break;
					
					}
					
					this.cancel();
					
					transicaoAmpliacao();
					
				}
			
			}
			
		},delay2,interval2);
		
	}
	
	public void transicaoVolta(){
		
		switch(getEntrada()){
		
		case 1:
			
			ControladorFrame.pLogin = new Login();
			ControladorFrame.pLogin.setBounds(-w-20, 20, w-40, h-80);
			ControladorFrame.telas.add(ControladorFrame.pLogin);
			
		break;
		
		case 2:
			
			ControladorFrame.pHome = new Home();
			ControladorFrame.pHome.setBounds(-w-20, 20, w-40, h-80);
			ControladorFrame.telas.add(ControladorFrame.pHome);
			
		break;
		
		}
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(ControladorFrame.pLogin.getLocation().x < 20){
				
					switch(getEntrada()){
					
					case 1:
						
						ControladorFrame.pLogin.setLocation(ControladorFrame.pLogin.getLocation().x+4, ControladorFrame.pLogin.getLocation().y);
						
						
					break;
					
					case 2:
					
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x+4, ControladorFrame.pHome.getLocation().y);
					
					break;
					
					}
					
					switch(getSaida()){
					
					case 1:
					
						ControladorFrame.pLogin.setLocation(ControladorFrame.pLogin.getLocation().x+4, ControladorFrame.pLogin.getLocation().y);
					
					break;
					
					case 2:
					
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x+4, ControladorFrame.pHome.getLocation().y);
						
						
					break;
						
					}
					
				}else{
					
					switch(getSaida()){
					
					case 1:
					
						ControladorFrame.pLogin.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pLogin);
					
					break;
					
					case 2:
						
						ControladorFrame.pHome.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pHome);
						
					break;
					
					}
					
					this.cancel();
					
					transicaoAmpliacao();
					
				}
			
			}
			
		},delay2,interval2);
		
	}
	
	public void transicaoAmpliacao(){
			
		if(getEscolhaE() == 3){
		
			switch(getEntrada()){
			
			case 2:
				
				ControladorFrame.pJogos.setVisible(false);
				ControladorFrame.telas.remove(ControladorFrame.pJogos);
				ControladorFrame.pHome = new Home();
				ControladorFrame.telas.add(ControladorFrame.pHome);
				
			break;
			
			case 3:
				
				ControladorFrame.pHome.setVisible(false);
				ControladorFrame.telas.remove(ControladorFrame.pHome);
				ControladorFrame.pJogos = new Jogos();
				ControladorFrame.telas.add(ControladorFrame.pJogos);
				
			break;
			
			}
			
		}
		
			timer.scheduleAtFixedRate(new TimerTask(){
				
				int reduz = 0, reduz2 = 0;
				
				public void run(){
					
					if(reduz <= 20){
					
						reduz++;
						reduz2+=2;
						
						switch(getEntrada()){
						
						case 1:
						
							ControladorFrame.pLogin.setBounds(20-reduz, 20-reduz, (w-40)+reduz2, (h-80)+reduz2);
						
						break;
						
						case 2:
						
							ControladorFrame.pHome.setBounds(20-reduz, 20-reduz, (w-40)+reduz2, (h-80)+reduz2);
							
						break;
						
						case 3:
							
							ControladorFrame.pJogos.setBounds(20-reduz, 20-reduz, (w-40)+reduz2, (h-80)+reduz2);
							
						break;
						
						case 4:
							
							ControladorFrame.pTratamento.setBounds(20-reduz, 20-reduz, (w-40)+reduz2, (h-80)+reduz2);
							
						break;
						
						}
						
					}else{
						
						this.cancel();
						
					}
	//				this.setBounds(w+20,20,w-40,h-80);
	//				this.setBounds(0,0,w,h-40);
					
					
				
				}
				
			},delay,interval);
			
		}

//tempo popUp login

int intervalSd = 2, intervalE = 5000;

	public void popSobe(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			int reduz = 0;
			
			public void run(){
				
				if(reduz <= 200){
				
				reduz++;
				
				ControladorFrame.pLogin.caixa.setBounds(0,h-reduz,w,200);
					
				}else{
					
					this.cancel();
					popEstavel();
					
				}
				
			
			}
			
		},delay,intervalSd);
		
	}
	
	public void popEstavel(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			int aviso = 0;
			
			public void run(){
				
				if(aviso == 1){
				
					this.cancel();
					popDesce();
					
				}else{
					
					aviso++;
					
				}
				
			
			}
			
		},delay,intervalE);
		
	}
	
	public void popDesce(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			int reduz = 200;
			
			public void run(){
				
				if(reduz != 0){
				
				reduz--;
				
				ControladorFrame.pLogin.caixa.setBounds(0,h-reduz,w,200);
					
				}else{
					
					this.cancel();
					
				}
				
			
			}
			
		},delay,intervalSd);
		
	}
	
	//reduz tamanho da barra de tempo
	
	static public int finaliza, retira=0, tempo, pontos;
	
	public void tempo(){
		
		finaliza = 0;
		
		interval = 500;
		
		if(logica.nivel == 1){
			
			tempo = w/180;
			pontos=12000;
		
		}else{
			
			tempo = w/240;
			pontos=22000;
			
		}
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(ControladorFrame.pJogos.barra.getWidth() > 0 && finaliza == 0){
					
					if(pontos<=200){
						pontos=200;
					}else{
						pontos+=-80-retira;
					}
					
					if(ControladorFrame.pJogos.barra.getWidth() < 250){
						
						ControladorFrame.pJogos.barra.setBackground(new Color(252,27,49));
						
					}
					
					ControladorFrame.pJogos.barra.setSize((ControladorFrame.pJogos.barra.getWidth()-tempo)-retira, 38);
					retira=0;
					
				}else{
					
					if(ControladorFrame.pJogos.barra.getWidth() <= 0){
						
						vitoria.derrota();
						retira=0;
						
					}
					
					cancel();
					
				}
			
			}
			
		},delay,interval);
		
	}
	
	// troca de tela entre jogos
	
	public static boolean permitir = true;
	
	public void trocaJogo(){	
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			int reduz=w;
			
			public void run(){
				
				if(reduz > 4){
					
					switch(getEntrada()){
						
					case 2:
						
						ControladorFrame.pSequencia.setLocation(ControladorFrame.pSequencia.getLocation().x-4, ControladorFrame.pSequencia.getLocation().y);
					
					break;
						
					case 3:						
					
						ControladorFrame.pSintomas.setLocation(ControladorFrame.pSintomas.getLocation().x-4, ControladorFrame.pSintomas.getLocation().y);
					
					break;	
					
					}

					ControladorFrame.pMemoria.setLocation(ControladorFrame.pMemoria.getLocation().x-4, ControladorFrame.pMemoria.getLocation().y);
					reduz+=-4;
					
				}else{
					
					switch(getEntrada()){
					
					case 2:
					
						ControladorFrame.pSequencia.setLocation(0, ControladorFrame.pSequencia.getLocation().y);
					
					break;
					
					case 3:
					
						ControladorFrame.pSintomas.setLocation(0, ControladorFrame.pSintomas.getLocation().y);
						
					break;
					
					}
					
					
					ControladorFrame.pMemoria.setLocation(-w, ControladorFrame.pMemoria.getLocation().y);
					
					cancel();
					
					permitir = true;
					
				}
			
			}
			
		},delay2,interval2);
		
	}
	
	public void voltaJogo(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			int reduz=0;
			
			public void run(){
				
				if(reduz < w-4){
					
					switch(getEntrada()){
						
					case 2:
						
						ControladorFrame.pSequencia.setLocation(ControladorFrame.pSequencia.getLocation().x+4, ControladorFrame.pSequencia.getLocation().y);
					
					break;
						
					case 3:						
					
						ControladorFrame.pSintomas.setLocation(ControladorFrame.pSintomas.getLocation().x+4, ControladorFrame.pSintomas.getLocation().y);
					
					break;	
					
					}

					ControladorFrame.pMemoria.setLocation(ControladorFrame.pMemoria.getLocation().x+4, ControladorFrame.pMemoria.getLocation().y);
					reduz+=+4;
					
				}else{
					
					switch(getEntrada()){
					
					case 2:
					
						ControladorFrame.pSequencia.setLocation(w, ControladorFrame.pSequencia.getLocation().y);
					
					break;
					
					case 3:
						
						ControladorFrame.pSintomas.setLocation(w, ControladorFrame.pSintomas.getLocation().y);
						
					break;
					
					}
					
					ControladorFrame.pMemoria.setLocation(0, ControladorFrame.pMemoria.getLocation().y);
					
					cancel();
					
					permitir = true;
					
				}
			
			}
			
		},delay2,interval2);
		
	}
	
	//efeito popUp
	
	public static int tipoPop;
	int interval3=8; 
	
	public void popUpT(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(tipoPop==1){
					
					Jogos.pPopUp.popUp.setBounds(0,(Jogos.pPopUp.getHeight()/2)-175,Jogos.pPopUp.popUp.getWidth()+20,350);
					
					if(Jogos.pPopUp.popUp.getWidth()>=w+2){
						
						Jogos.pPopUp.popUp.setBounds(0,(Jogos.pPopUp.getHeight()/2)-175,w+2,350);
						cancel();
						
					}
					
				}else{
					
					Jogos.pPopUp.derrotaPop.setBounds(0,(Jogos.pPopUp.getHeight()/2)-175,Jogos.pPopUp.derrotaPop.getWidth()+20,350);
					
					if(Jogos.pPopUp.derrotaPop.getWidth()>=w+2){
						
						Jogos.pPopUp.derrotaPop.setBounds(0,(Jogos.pPopUp.getHeight()/2)-175,w+2,350);
						cancel();
						
					}
					
				}
			
			}
			
		},delay2,interval3);
		
	}
	
	//aumenta ponto
	
	Timer timerP = new Timer();
	
	int interval4=15;
	
	int validaP=0, soma, antigo;
	
	public void pontos(){
		
		soma = Integer.parseInt(ControladorFrame.pJogos.pontuacao.getText());
		
		antigo = soma;
		
		timerP.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				validaP+=155;
				
				soma+=+155;	
				
				ControladorFrame.pJogos.pontuacao.setText(Integer.toString(soma));
				
				if(validaP>=pontos){
					
					ControladorFrame.pJogos.pontuacao.setText(Integer.toString(antigo+pontos));
					cancel();
					
					pontos=20000;
					
				}
			
			}
			
		},delay2,interval4);
		
	}
	
	// transi��o entre tratamento
	
public void transicaoTrocaT(){
		
		ControladorFrame.pTratamento = new Tratamentos();
		
		ControladorFrame.telas.add(ControladorFrame.pTratamento);
	
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(ControladorFrame.pTratamento.getLocation().x > 20){
				
					switch(getEntrada()){
					
					case 2:
						
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x-4, ControladorFrame.pHome.getLocation().y);
						
						
					break;
					
					case 4:
					
						ControladorFrame.pTratamento.setLocation(ControladorFrame.pTratamento.getLocation().x-4, ControladorFrame.pTratamento.getLocation().y);
					
					break;
					
					}
					
					switch(getSaida()){
					
					case 2:
					
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x-4, ControladorFrame.pHome.getLocation().y);
					
					break;
					
					case 4:
					
						ControladorFrame.pTratamento.setLocation(ControladorFrame.pTratamento.getLocation().x-4, ControladorFrame.pTratamento.getLocation().y);
						
						
					break;
						
					}
					
				}else{
					
					switch(getSaida()){
					
					case 2:
					
						ControladorFrame.pHome.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pHome);
					
					break;
					
					case 4:
						
						ControladorFrame.pTratamento.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pTratamento);
						
					break;
					
					}
					
					this.cancel();
					
					transicaoAmpliacao();
					
				}
			
			}
			
		},delay2,interval2);
		
	}
	
	public void transicaoVoltaT(){
		
		switch(getEntrada()){
		
		case 2:
			
			ControladorFrame.pHome = new Home();
			ControladorFrame.pHome.setBounds(-w-20, 20, w-40, h-80);
			ControladorFrame.telas.add(ControladorFrame.pHome);
			
		break;
		
		case 4:
			
			ControladorFrame.pTratamento = new Tratamentos();
			ControladorFrame.pTratamento.setBounds(-w-20, 20, w-40, h-80);
			ControladorFrame.telas.add(ControladorFrame.pTratamento);
			
		break;
		
		}
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				if(ControladorFrame.pHome.getLocation().x < 20){
				
					switch(getEntrada()){
					
					case 2:
						
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x+4, ControladorFrame.pHome.getLocation().y);
						
						
					break;
					
					case 4:
					
						ControladorFrame.pTratamento.setLocation(ControladorFrame.pTratamento.getLocation().x+4, ControladorFrame.pTratamento.getLocation().y);
					
					break;
					
					}
					
					switch(getSaida()){
					
					case 2:
					
						ControladorFrame.pHome.setLocation(ControladorFrame.pHome.getLocation().x+4, ControladorFrame.pHome.getLocation().y);
					
					break;
					
					case 4:
					
						ControladorFrame.pTratamento.setLocation(ControladorFrame.pTratamento.getLocation().x+4, ControladorFrame.pTratamento.getLocation().y);
						
						
					break;
						
					}
					
				}else{
					
					switch(getSaida()){
					
					case 2:
					
						ControladorFrame.pHome.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pHome);
					
					break;
					
					case 4:
						
						ControladorFrame.pTratamento.setVisible(false);
						ControladorFrame.telas.remove(ControladorFrame.pTratamento);
						
					break;
					
					}
					
					this.cancel();
					
					transicaoAmpliacao();
					
				}
			
			}
			
		},delay2,interval2);
		
	}

	//splash
	

	
	int duracao =0;
	
	int intervalS =  20;
	
	public void splashBarra(){
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			Splash s = new Splash();
			
			ControladorFrame c = new ControladorFrame();
			
				public void run(){
					
					
						Splash.barra.setSize(Splash.barra.getWidth()+5, 2);
						
						if(Splash.barra.getWidth()>200){
							
							if(Splash.bio.getLocation().x>105){
							
							Splash.folks.setLocation(Splash.folks.getLocation().x-15,105);
							Splash.bio.setLocation(Splash.bio.getLocation().x-15,105);
							
							}else{
								
								Splash.bio.setLocation(105,105);
								
							}
							
						}
						
						if(Splash.barra.getWidth()==500){
							
							c.setVisible(true);
							
							cancel();
							
							s.dispose();
							
						}
					
					duracao++;
				
				}
				
			},delay2,intervalS);
		
		}
	
	
	//abre os bot�es da home
	
	int intervalA = 10, font=100, abrir;
	
	public void iniciaJogo(){
		
		font=100;
		abrir=0;
		
		ControladorFrame.pJogos = new Jogos();
		ControladorFrame.telas.add(ControladorFrame.pJogos);
		
		timer.scheduleAtFixedRate(new TimerTask(){
			
			public void run(){
				
				
				switch(getEscolhaE()){
				
					case 1:
						
						ControladorFrame.pHome.nivel2.setVisible(false);
						ControladorFrame.pHome.nivel3.setVisible(false);
						ControladorFrame.pHome.nivel4.setVisible(false);
						ControladorFrame.pHome.nivel5.setVisible(false);
						
						if(ControladorFrame.pHome.nivel1.getHeight() < h-40 || ControladorFrame.pHome.nivel1.getWidth() < w  || ControladorFrame.pHome.nivel1.getLocation().x>0 || ControladorFrame.pHome.nivel1.getLocation().y >0){
							
							ControladorFrame.pHome.nivel1.setFont(new Font("Century Gothic",  Font. PLAIN,  font));
							
							font+=4;
							
							if(ControladorFrame.pHome.nivel1.getLocation().x > 0){	
								ControladorFrame.pHome.nivel1.setLocation(ControladorFrame.pHome.nivel1.getLocation().x-15, ControladorFrame.pHome.nivel1.getLocation().y);
							}
							
							if(ControladorFrame.pHome.nivel1.getLocation().y > 0){	
								ControladorFrame.pHome.nivel1.setLocation(ControladorFrame.pHome.nivel1.getLocation().x, ControladorFrame.pHome.nivel1.getLocation().y-15);
							}else{
								
								ControladorFrame.cabecalho.setBackground(ControladorFrame.pJogos.cores);
								ControladorFrame.fechar.setBackground(ControladorFrame.cor1);
								ControladorFrame.minimizar.setBackground(ControladorFrame.cor1);
								
							}
							
							if(ControladorFrame.pHome.nivel1.getHeight() < h-40){	
								ControladorFrame.pHome.nivel1.setSize(ControladorFrame.pHome.nivel1.getWidth(), ControladorFrame.pHome.nivel1.getHeight()+30);
								
							}
							
							if(ControladorFrame.pHome.nivel1.getWidth() < w){	
								ControladorFrame.pHome.nivel1.setSize(ControladorFrame.pHome.nivel1.getWidth()+30, ControladorFrame.pHome.nivel1.getHeight());
								
							}
						}else{
							
							if(abrir==45){
							
								ControladorFrame.pJogos.setVisible(true);
								ControladorFrame.pHome.setVisible(false);
								ControladorFrame.telas.remove(ControladorFrame.pHome);
								this.cancel();	
							
							}else{
								abrir++;
							}
							
						}
						
					break;
					
					case 2:
						
						ControladorFrame.pHome.nivel1.setVisible(false);
						ControladorFrame.pHome.nivel3.setVisible(false);
						ControladorFrame.pHome.nivel4.setVisible(false);
						ControladorFrame.pHome.nivel5.setVisible(false);
						
						if(ControladorFrame.pHome.nivel2.getHeight() < h-40 || ControladorFrame.pHome.nivel2.getWidth() < w  || ControladorFrame.pHome.nivel2.getLocation().x>0 || ControladorFrame.pHome.nivel2.getLocation().y >0){
							
							ControladorFrame.pHome.nivel2.setFont(new Font("Century Gothic",  Font. PLAIN,  font));
							
							font+=4;
							
							if(ControladorFrame.pHome.nivel2.getLocation().x > 0){	
								ControladorFrame.pHome.nivel2.setLocation(ControladorFrame.pHome.nivel2.getLocation().x-15, ControladorFrame.pHome.nivel2.getLocation().y);
							}
							
							if(ControladorFrame.pHome.nivel2.getLocation().y > 0){	
								ControladorFrame.pHome.nivel2.setLocation(ControladorFrame.pHome.nivel2.getLocation().x, ControladorFrame.pHome.nivel2.getLocation().y-15);
							}else{
								
								ControladorFrame.cabecalho.setBackground(ControladorFrame.pJogos.cores);
								ControladorFrame.fechar.setBackground(ControladorFrame.cor1);
								ControladorFrame.minimizar.setBackground(ControladorFrame.cor1);
								
							}
							
							if(ControladorFrame.pHome.nivel2.getHeight() < h-40){	
								ControladorFrame.pHome.nivel2.setSize(ControladorFrame.pHome.nivel2.getWidth(), ControladorFrame.pHome.nivel2.getHeight()+30);
								
							}
							
							if(ControladorFrame.pHome.nivel2.getWidth() < w){	
								ControladorFrame.pHome.nivel2.setSize(ControladorFrame.pHome.nivel2.getWidth()+30, ControladorFrame.pHome.nivel2.getHeight());
								
							}
						}else{
							
							if(abrir==45){
							
								ControladorFrame.pJogos.setVisible(true);
								ControladorFrame.pHome.setVisible(false);
								ControladorFrame.telas.remove(ControladorFrame.pHome);
								this.cancel();	
							
							}else{
								abrir++;
							}
							
						}
						
					break;
						
					case 3:
						
						ControladorFrame.pHome.nivel1.setVisible(false);
						ControladorFrame.pHome.nivel2.setVisible(false);
						ControladorFrame.pHome.nivel4.setVisible(false);
						ControladorFrame.pHome.nivel5.setVisible(false);
						
						if(ControladorFrame.pHome.nivel3.getHeight() < h-40 || ControladorFrame.pHome.nivel3.getWidth() < w  || ControladorFrame.pHome.nivel3.getLocation().x>0 || ControladorFrame.pHome.nivel3.getLocation().y >0){
							
							ControladorFrame.pHome.nivel3.setFont(new Font("Century Gothic",  Font. PLAIN,  font));
							
							font+=4;
							
							if(ControladorFrame.pHome.nivel3.getLocation().x > 0){	
								ControladorFrame.pHome.nivel3.setLocation(ControladorFrame.pHome.nivel3.getLocation().x-15, ControladorFrame.pHome.nivel3.getLocation().y);
							}
							
							if(ControladorFrame.pHome.nivel3.getLocation().y > 0){	
								ControladorFrame.pHome.nivel3.setLocation(ControladorFrame.pHome.nivel3.getLocation().x, ControladorFrame.pHome.nivel3.getLocation().y-15);
							}else{
								
								ControladorFrame.cabecalho.setBackground(ControladorFrame.pJogos.cores);
								ControladorFrame.fechar.setBackground(ControladorFrame.cor1);
								ControladorFrame.minimizar.setBackground(ControladorFrame.cor1);
								
							}
							
							if(ControladorFrame.pHome.nivel3.getHeight() < h-40){	
								ControladorFrame.pHome.nivel3.setSize(ControladorFrame.pHome.nivel3.getWidth(), ControladorFrame.pHome.nivel3.getHeight()+30);
								
							}
							
							if(ControladorFrame.pHome.nivel3.getWidth() < w){	
								ControladorFrame.pHome.nivel3.setSize(ControladorFrame.pHome.nivel3.getWidth()+30, ControladorFrame.pHome.nivel3.getHeight());
								
							}
						}else{
							
							if(abrir==45){
							
								ControladorFrame.pJogos.setVisible(true);
								ControladorFrame.pHome.setVisible(false);
								ControladorFrame.telas.remove(ControladorFrame.pHome);
								this.cancel();	
							
							}else{
								abrir++;
							}
							
						}
						
					break;
						
					case 4:
						
						ControladorFrame.pHome.nivel1.setVisible(false);
						ControladorFrame.pHome.nivel2.setVisible(false);
						ControladorFrame.pHome.nivel3.setVisible(false);
						ControladorFrame.pHome.nivel5.setVisible(false);
						
						if(ControladorFrame.pHome.nivel4.getHeight() < h-40 || ControladorFrame.pHome.nivel4.getWidth() < w  || ControladorFrame.pHome.nivel4.getLocation().x>0 || ControladorFrame.pHome.nivel4.getLocation().y >0){
							
							ControladorFrame.pHome.nivel4.setFont(new Font("Century Gothic",  Font. PLAIN,  font));
							
							font+=4;
							
							if(ControladorFrame.pHome.nivel4.getLocation().x > 0){	
								ControladorFrame.pHome.nivel4.setLocation(ControladorFrame.pHome.nivel4.getLocation().x-15, ControladorFrame.pHome.nivel4.getLocation().y);
							}
							
							if(ControladorFrame.pHome.nivel4.getLocation().y > 0){	
								ControladorFrame.pHome.nivel4.setLocation(ControladorFrame.pHome.nivel4.getLocation().x, ControladorFrame.pHome.nivel4.getLocation().y-15);
							}else{
								
								ControladorFrame.cabecalho.setBackground(ControladorFrame.pJogos.cores);
								ControladorFrame.fechar.setBackground(ControladorFrame.cor1);
								ControladorFrame.minimizar.setBackground(ControladorFrame.cor1);
								
							}
							
							if(ControladorFrame.pHome.nivel4.getHeight() < h-40){	
								ControladorFrame.pHome.nivel4.setSize(ControladorFrame.pHome.nivel4.getWidth(), ControladorFrame.pHome.nivel4.getHeight()+30);
								
							}
							
							if(ControladorFrame.pHome.nivel4.getWidth() < w){	
								ControladorFrame.pHome.nivel4.setSize(ControladorFrame.pHome.nivel4.getWidth()+30, ControladorFrame.pHome.nivel4.getHeight());
								
							}
						}else{
							
							if(abrir==45){
							
								ControladorFrame.pJogos.setVisible(true);
								ControladorFrame.pHome.setVisible(false);
								ControladorFrame.telas.remove(ControladorFrame.pHome);
								this.cancel();	
							
							}else{
								abrir++;
							}
							
						}
						
					break;
						
					case 5:
						
						ControladorFrame.pHome.nivel1.setVisible(false);
						ControladorFrame.pHome.nivel2.setVisible(false);
						ControladorFrame.pHome.nivel3.setVisible(false);
						ControladorFrame.pHome.nivel4.setVisible(false);
						
						if(ControladorFrame.pHome.nivel5.getHeight() < h-40 || ControladorFrame.pHome.nivel5.getWidth() < w || ControladorFrame.pHome.nivel5.getLocation().x>0 || ControladorFrame.pHome.nivel5.getLocation().y >0){
							
							ControladorFrame.pHome.nivel5.setFont(new Font("Century Gothic",  Font. PLAIN,  font));
							
							font+=4;
							
							if(ControladorFrame.pHome.nivel5.getLocation().x > 0){	
								ControladorFrame.pHome.nivel5.setLocation(ControladorFrame.pHome.nivel5.getLocation().x-15, ControladorFrame.pHome.nivel5.getLocation().y);
							}
							
							if(ControladorFrame.pHome.nivel5.getLocation().y > 0){	
								ControladorFrame.pHome.nivel5.setLocation(ControladorFrame.pHome.nivel5.getLocation().x, ControladorFrame.pHome.nivel5.getLocation().y-15);
							}else{
								
								ControladorFrame.cabecalho.setBackground(ControladorFrame.pJogos.cores);
								ControladorFrame.fechar.setBackground(ControladorFrame.cor1);
								ControladorFrame.minimizar.setBackground(ControladorFrame.cor1);
								
							}
							
							if(ControladorFrame.pHome.nivel5.getHeight() < h-40){	
								ControladorFrame.pHome.nivel5.setSize(ControladorFrame.pHome.nivel5.getWidth(), ControladorFrame.pHome.nivel5.getHeight()+30);
								
							}
							
							if(ControladorFrame.pHome.nivel5.getWidth() < w){	
								ControladorFrame.pHome.nivel5.setSize(ControladorFrame.pHome.nivel5.getWidth()+30, ControladorFrame.pHome.nivel5.getHeight());
								
							}
						}else{
							
							if(abrir==45){
							
								ControladorFrame.pJogos.setVisible(true);
								ControladorFrame.pHome.setVisible(false);
								ControladorFrame.telas.remove(ControladorFrame.pHome);
								this.cancel();	
							
							}else{
								abrir++;
							}
							
						}
						
					break;
				
				}
				
			}
				
		},delay,intervalA);
	

		
	}
	
}

