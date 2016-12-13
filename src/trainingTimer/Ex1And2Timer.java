package trainingTimer;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;

import java.io.*;
import sun.audio.*;

public class Ex1And2Timer {
	
	Timer myTimer = new Timer();
	
	public void startTimerHr(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				//harjutus 1
				if (StartPage.harjutuseValik == 1){
					if (StartPage.taimeriOlek == 1){ // Peatab taimeri kui vajutada stopp nuppu
						myTimer.cancel();
						/*
						 * MUUTUJAD PEAVAD OLEMA
						 * Excercise1Window.second
						 * Excercise1Window.minute
						 * Excercise2Window.second
						 * Excercise2Window.minute
						 */
					} else if (Excercise1Window.minute == 1 && Excercise1Window.second == 5){ // Peatab taimeri kui aeg on t2is
						myTimer.cancel();
					} else {					
						if(Excercise1Window.second < 59){ //59
							Excercise1Window.second++;
							if (Excercise1Window.second >= 55 && Excercise1Window.second <= 59){
								System.out.println(Excercise1Window.second + " BEEEP!");
							} else {
								System.out.println("Seconds passed: " + Excercise1Window.second);
								
							}
						} else {
							Excercise1Window.second = 0;
							if (Excercise1Window.minute < 59){ //59
								Excercise1Window.minute++;
								System.out.println("Minutes passed: " + Excercise1Window.minute);
							}
						}
					}
				//harjutus 2
				} else if (StartPage.harjutuseValik == 2){
					if (StartPage.taimeriOlek == 1){ // Peatab taimeri kui vajutada stopp nuppu
						myTimer.cancel();
					} else if (Excercise2Window.minute == 1 && Excercise2Window.second == 5){ // Peatab taimeri kui aeg on t2is
						myTimer.cancel();
					} else {					
						if(Excercise2Window.second < 59){ //59
							Excercise2Window.second++;
							if (Excercise2Window.second >= 55 && Excercise2Window.second <= 59){
								System.out.println(Excercise2Window.second + " BEEEP!");
							} else {
								System.out.println("Seconds passed: " + Excercise2Window.second);
								
							}
						} else {
							Excercise2Window.second = 0;
							if (Excercise2Window.minute < 59){ //59
								Excercise2Window.minute++;
								System.out.println("Minutes passed: " + Excercise2Window.minute);
							}
						}
					}

				}
			}
		}, 1000, 1000);
	}
	
//	private void PlaySound(){
//		try {
//			String soundFile = "/i200Projekt/src/sound/beep-03.wav";
//			InputStream inStream = new FileInputStream(soundFile);
//			AudioStream audioStream = new AudioStream(inStream);
//			AudioPlayer.player.start(audioStream);
//		}
//		catch (Exception e){
//			
//		}
//	}
}


//if (second >= 55 && second <= 59 || second >= 175 && second <= 179 || second >= 295){
//	second++;
//	System.out.println(second + " BEEEP!");
//	if(second == 300){//300
//		System.out.println("STOPP");
//		myTimer.cancel();
//	}
//}
//else if (second >= 115 && second <= 119 || second >= 235 && second <= 239){
//	second++;
//	System.out.println(second + " BEEEP!");
//}
//else if (second == 60 || second == 180){
//	second++;
//	System.out.println(second + " PAUSE!");
//}
//else if (second == 120 || second == 240){
//	second++;
//	System.out.println(second + " START!");
//}
//else{
//	second++;
//	System.out.println("Seconds passed: " + second);
//}