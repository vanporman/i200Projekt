package trainingTimer;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;


public class WSaPTimer {
//	private int hour;
//	private int minute;
	private int second;
	
	Timer myTimer = new Timer();
	
	public void startTimerHr(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){
					myTimer.cancel();
				} else {					
					if (second >= 55 && second <= 59 || second >= 175 && second <= 179 || second >= 295){
						second++;
						System.out.println(second + " BEEEP!");
						if(second == 300){//300
							System.out.println("STOPP");
							myTimer.cancel();
						}
					}
					else if (second >= 115 && second <= 119 || second >= 235 && second <= 239){
						second++;
						System.out.println(second + " BEEEP!");
					}
					else if (second == 60 || second == 180){
						second++;
						System.out.println(second + " PAUSE!");
					}
					else if (second == 120 || second == 240){
						second++;
						System.out.println(second + " START!");
					}
					else{
						second++;
						System.out.println("Seconds passed: " + second);
					}
				}
			}
		}, 1000, 1000);
	}
}
