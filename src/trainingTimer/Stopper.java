package trainingTimer;

import java.util.Timer;
import java.util.TimerTask;

public class Stopper {
//	Integer hour = 0;
//	Integer minute = 0;
//	Integer second = 0;
	
	private Timer stopperiTimer = new Timer();
	
	public void startStopper(){
		stopperiTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){
					stopperiTimer.cancel();						
				} else {					
					if(StartPage.second < 59){ //59
						StartPage.second++;
						StartPage.sec = (StartPage.second < 10 ? "0" : "") + StartPage.second;
						System.out.println("Seconds passed: " + StartPage.second);
					} else {
						StartPage.second = 0;
						if (StartPage.minute < 59){ //59
							StartPage.minute++;
							StartPage.min = (StartPage.minute < 10 ? "0" : "") + StartPage.minute;
							System.out.println("Minutes passed: " + StartPage.minute);
						} else {
							StartPage.minute = 0;
							StartPage.hour++;
							StartPage.h = (StartPage.hour < 10 ? "0" : "") + StartPage.hour;
							System.out.println("Hours passed: " + StartPage.hour);
						}
					}
				}
			}
		}, 1000, 1000);
	}
}
