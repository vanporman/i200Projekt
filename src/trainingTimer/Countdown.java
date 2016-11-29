package trainingTimer;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
	
	public static int aegStardini;
	private int aegMaha = aegStardini + 1;
	private static int harjutus = StartPage.harjutuseValik;
	
	Timer allaLugemiseTimer = new Timer();
	
	public void alustaAllalugemist(){
		allaLugemiseTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){
					allaLugemiseTimer.cancel();
				} else {					
					if (aegMaha < 2){
						aegMaha--;
						System.out.println("STARTS");
						if (harjutus == 1 && aegMaha == 0){
							System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
							allaLugemiseTimer.cancel();
							WSaPTimer harjutus1 = new WSaPTimer();
							harjutus1.startTimerHr();
						} else if (harjutus == 2 && aegMaha == 0){
							System.out.println("Tegemist on PLANK harjutusega " + harjutus);
							allaLugemiseTimer.cancel();
							WSaPTimer harjutus2 = new WSaPTimer();
							harjutus2.startTimerHr();
						} else if (harjutus == 3 && aegMaha == 0){
							System.out.println("Tegemist on SIDE PLANK harjutusega " + harjutus);
							allaLugemiseTimer.cancel();
							SPTimer harjutus3 = new SPTimer();
							harjutus3.startTimerHr2();
						}
					} else {
						aegMaha--;
						System.out.println("Seconds to go: " + aegMaha);
					}
				}
			}
		}, 1000, 1000);
	}
}
