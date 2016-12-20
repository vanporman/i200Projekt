package trainingTimer;

import java.util.Timer;
import java.util.TimerTask;

import java.io.*;

public class Ex1Timer {
	
	File Beep = new File("beep-07.wav");
	File Beep2 =new File("beep-01a.wav");
	Timer myTimer = new Timer();
	
	public void startTimerHr(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				//harjutus 1
				if (CountdownTimer.harjutus == 1){
					if (StartPage.taimeriOlek == 2){ // Peatab taimeri kui vajutada stopp nuppu
						myTimer.cancel();
						/*
						 * MUUTUJAD PEAVAD OLEMA
						 * Excercise1Window.second
						 * Excercise1Window.minute
						 * Excercise2Window.second
						 * Excercise2Window.minute
						 */
					} else if (Excercise1Window.minute == 5 /*&& Excercise1Window.second == 5*/){ // Peatab taimeri kui aeg on t2is
						myTimer.cancel();
					} else {					
						if(Excercise1Window.second < 59){ //59
							Excercise1Window.second++;
							if (Excercise1Window.second >= 55 && Excercise1Window.second <= 59){
								CountdownTimer.PlaySound(Beep);
								System.out.println(Excercise1Window.second + " BEEEP!");
							}
							else {
								System.out.println("Seconds passed: " + Excercise1Window.second);
							}
						} else {
							Excercise1Window.second = 0;
							if (Excercise1Window.minute < 59){ //59
								Excercise1Window.minute++;
								System.out.println("Minutes passed: " + Excercise1Window.minute);
								if (Excercise1Window.minute > 0){
									CountdownTimer.PlaySound(Beep2);
								}
							}
						}
					}
				} 
			}
		}, 1000, 1000);
	}
}