package trainingTimer;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;


public class Ex1And2Timer {
	
	Timer myTimer = new Timer();
	
	public void startTimerHr(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){ // Peatab taimeri kui vajutada stopp nuppu
					myTimer.cancel();
				} else if (Excercise1Window.minute == 1 ){ // Peatab taimeri kui aeg on t2is
					myTimer.cancel();
				} else {					
					if(Excercise1Window.second < 59){ //59
						Excercise1Window.second++;
						if (Excercise1Window.second >= 55 && Excercise1Window.second <= 59){
							System.out.println(Excercise1Window.second + " BEEEP!");
						}
						System.out.println("Seconds passed: " + Excercise1Window.second);
					} else {
						Excercise1Window.second = 0;
						if (Excercise1Window.minute < 59){ //59
							Excercise1Window.minute++;
							System.out.println("Minutes passed: " + Excercise1Window.minute);
						}
					}
					
//					if (second >= 55 && second <= 59 || second >= 175 && second <= 179 || second >= 295){
//						second++;
//						System.out.println(second + " BEEEP!");
//						if(second == 300){//300
//							System.out.println("STOPP");
//							myTimer.cancel();
//						}
//					}
//					else if (second >= 115 && second <= 119 || second >= 235 && second <= 239){
//						second++;
//						System.out.println(second + " BEEEP!");
//					}
//					else if (second == 60 || second == 180){
//						second++;
//						System.out.println(second + " PAUSE!");
//					}
//					else if (second == 120 || second == 240){
//						second++;
//						System.out.println(second + " START!");
//					}
//					else{
//						second++;
//						System.out.println("Seconds passed: " + second);
//					}
				}
			}
		}, 1000, 1000);
	}
}
