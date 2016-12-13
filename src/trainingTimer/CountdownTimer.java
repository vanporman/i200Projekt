package trainingTimer;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
	
	public static int aegStardini;
//	private int aegMaha = aegStardini + 1;
	static int harjutus = StartPage.harjutuseValik;
	
	//Meetod mis valib switch-case p6hjal mis aknas harjutused liiguvad????
	//Meetod 2 mis paneb käima taimeri vastavalt switch-case valikutele???
	//Meetod siia sisse??????
	/*MUUTUJAD PEAVAD OLEMA
	 * Excercise1Window.second
	 * Excercise2Window.second
	 * Excercise3Window.second
	 */
	
	Timer allaLugemiseTimer = new Timer();
	
	public void alustaAllalugemist(){	
		allaLugemiseTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				//harjutus 1 taimeri kood
				if (harjutus == 1){
					if (StartPage.taimeriOlek == 1){
						allaLugemiseTimer.cancel();	
					}
					else {
						if (Excercise1Window.second < 2){
							Excercise1Window.second--;
							System.out.println("STARTS");
							if (Excercise1Window.second == 0){
								System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
								allaLugemiseTimer.cancel();
								Ex1And2Timer harjutus1 = new Ex1And2Timer();
								harjutus1.startTimerHr();
							}
						}
						else {
							Excercise1Window.second--;
							System.out.println("Seconds to go: " + Excercise1Window.second);
						}
					}
				} 
				// harjutus 2 taimeri kood
				else if (harjutus == 2){
					if (StartPage.taimeriOlek == 1){
						allaLugemiseTimer.cancel();	
					}
					else {
						if (Excercise2Window.second < 2){
							Excercise2Window.second--;
							System.out.println("STARTS");
							if (Excercise2Window.second == 0){
								System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
								allaLugemiseTimer.cancel();
								Ex1And2Timer harjutus1 = new Ex1And2Timer();
								harjutus1.startTimerHr();
							}
						}
						else {
							Excercise2Window.second--;
							System.out.println("Seconds to go: " + Excercise2Window.second);
						}
					}
				}
				// harjutus 3 taimeri kood
				else if (harjutus == 2){
					if (StartPage.taimeriOlek == 1){
						allaLugemiseTimer.cancel();	
					}
					else {
						if (Excercise3Window.second < 2){
							Excercise3Window.second--;
							System.out.println("STARTS");
							if (Excercise3Window.second == 0){
								System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
								allaLugemiseTimer.cancel();
								Ex1And2Timer harjutus1 = new Ex1And2Timer();
								harjutus1.startTimerHr();
							}
						}
						else {
							Excercise3Window.second--;
							System.out.println("Seconds to go: " + Excercise3Window.second);
						}
					}
				}
			}
		}, 1000, 1000);
	}
}

//if (StartPage.taimeriOlek == 1){
//	allaLugemiseTimer.cancel();
//} else {
//	if (Excercise1Window.second < 2){
//		Excercise1Window.second--;
//		System.out.println("STARTS" + Excercise1Window.second);
//		if (harjutus == 1 && Excercise1Window.second == 0){
//			System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
//			allaLugemiseTimer.cancel();
//			Ex1And2Timer harjutus1 = new Ex1And2Timer();
//			harjutus1.startTimerHr();
////	if (muutuja < 2){
////		muutuja--;
////		System.out.println("STARTS");
////		if (harjutus == 1 && muutuja == 0){
////			System.out.println("Tegemist on WALL SIT harjutusega " + harjutus);
////			allaLugemiseTimer.cancel();
////			Ex1And2Timer harjutus1 = new Ex1And2Timer();
////			harjutus1.startTimerHr();
////		} else if (harjutus == 2 && Excercise2Window.second == 0){
////			System.out.println("Tegemist on PLANK harjutusega " + harjutus);
////			allaLugemiseTimer.cancel();
////			Ex1And2Timer harjutus2 = new Ex1And2Timer();
////			harjutus2.startTimerHr();
////		} else if (harjutus == 3 && Excercise1Window.second == 0){
////			System.out.println("Tegemist on SIDE PLANK harjutusega " + harjutus);
////			allaLugemiseTimer.cancel();
////			Ex3Timer harjutus3 = new Ex3Timer();
////			harjutus3.startTimerHr2();
//		}
//	} else {
//		Excercise1Window.second--;
//		System.out.println("Seconds to go: " + Excercise1Window.second);
////		muutuja--;
////		System.out.println("Seconds to go: " + muutuja);
//	}
//}
