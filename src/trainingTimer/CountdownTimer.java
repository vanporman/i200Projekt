package trainingTimer;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
	
	public static int aegStardini;
//	private int aegMaha = aegStardini + 1;
	private static int harjutus = StartPage.harjutuseValik;
	
	Timer allaLugemiseTimer = new Timer();
	
	public void alustaAllalugemist(){
		allaLugemiseTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (StartPage.taimeriOlek == 1){
					allaLugemiseTimer.cancel();
				} else {					
					if (Excercise1Window.second < 2){
						Excercise1Window.second--;
						System.out.println("STARTS");
						if (harjutus == 1 || harjutus == 2 && Excercise1Window.second == 0){
							System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
							allaLugemiseTimer.cancel();
							Ex1And2Timer harjutus1 = new Ex1And2Timer();
							harjutus1.startTimerHr();
						} else if (harjutus == 2 && Excercise1Window.second == 0){
							System.out.println("Tegemist on PLANK harjutusega " + harjutus);
							allaLugemiseTimer.cancel();
							Ex1And2Timer harjutus2 = new Ex1And2Timer();
							harjutus2.startTimerHr();
						} else if (harjutus == 3 && Excercise1Window.second == 0){
							System.out.println("Tegemist on SIDE PLANK harjutusega " + harjutus);
							allaLugemiseTimer.cancel();
//							Ex3Timer harjutus3 = new Ex3Timer();
//							harjutus3.startTimerHr2();
						}
					} else {
						Excercise1Window.second--;
						System.out.println("Seconds to go: " + Excercise1Window.second);
					}
				}
			}
		}, 1000, 1000);
	}
}
