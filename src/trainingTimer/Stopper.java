package trainingTimer;

/*
 * Stopperi kood(tundide arvestuses j22b lõputult jooksma
 * if-tsykkel (aja lugemiseks/arvestamiseks) startStopper meetodi sees on saanud inspiratsiooni erinevatelt n2idetelt mida googlist leidsin.
 * kokku on ta mul pandud erinevatest näidetest 
 */

import java.util.Timer;
import java.util.TimerTask;

public class Stopper {
	
	private Timer stopperiTimer = new Timer();
	
	public void startStopper(){
		stopperiTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){ // kui avalehel vajutada stopp-nuppu, siis v2ljutakse tsykklist
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
