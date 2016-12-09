package trainingTimer;

import java.awt.Toolkit;
import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;

public class Ex3Timer {
//	private int hour;
//	private int minute;
	private int second;
	
	Timer myTimer = new Timer();
	
	public void startTimerHr2(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){
					myTimer.cancel();
				} else {					
					if (second >= 25 && second <= 29 || second >= 115 && second <= 119 || second >= 200){
						second++;
						System.out.println(second + " BEEEP!");
//					Console.Beep(1, 100);
//					System.out.println("\007")
						if(second == 205){//205
							System.out.println("STOPP");
							myTimer.cancel();
						}
					}
					else if (second >= 85 && second <= 89 || second >= 175 && second <= 179){
						second++;
						System.out.println(second + " BEEEP!");
					}
					else if (second == 30 || second == 120){
						second++;
						System.out.println(second + " PAUSE!");
					}
					else if (second == 90 || second == 180){
						second++;
						System.out.println(second + " START!");
					}
					else {
						second++;
						System.out.println("Seconds passed: " + second);
					}
				}
			}
		}, 1000, 1000);
	}
}
