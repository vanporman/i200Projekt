package trainingTimer;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Ex2Timer {
	File Beep = new File("beep-07.wav");
	File Beep2 =new File("beep-01a.wav");
//	int[] Ex2minutes = {1, 2, 3, 4, 5, 6};
//	int[] Ex2seconds = {10, 14, 25, 29, 40, 44, 55, 59}; 
	Timer myTimer = new Timer();
	
	public void startTimerHr2(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				//harjutus 2 - vb muuta see nagu harjutus ette näeb 01:15 pikkuseks
				if (CountdownTimer.harjutus == 2){
					if (StartPage.taimeriOlek == 2){ // Peatab taimeri kui vajutada stopp nuppu
						myTimer.cancel();
					} else if (Excercise2Window.minute == 6 && Excercise2Window.second == 45){ // Peatab taimeri kui aeg on t2is
						myTimer.cancel();
					} else if (Excercise2Window.minute == 1 && Excercise2Window.second >= 9 && Excercise2Window.second <= 14){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEP!");
						CountdownTimer.PlaySound(Beep);
						if (Excercise2Window.second == 15){
							CountdownTimer.PlaySound(Beep2);
						}
					} else if (Excercise2Window.minute == 2 && Excercise2Window.second >= 39 && Excercise2Window.second <= 44){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEP!");
						CountdownTimer.PlaySound(Beep);
						if (Excercise2Window.second == 45){
							CountdownTimer.PlaySound(Beep2);
						}
					} else if (Excercise2Window.minute == 3 && Excercise2Window.second >= 54 && Excercise2Window.second <= 59){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEP!");
						CountdownTimer.PlaySound(Beep);
						if (Excercise2Window.minute == 4){
							CountdownTimer.PlaySound(Beep2);
						}
					} else if (Excercise2Window.minute == 5 && Excercise2Window.second >= 24 && Excercise2Window.second <= 29){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEP!");
						CountdownTimer.PlaySound(Beep);
						if (Excercise2Window.second == 30){
							CountdownTimer.PlaySound(Beep2);
						}
					} else if (Excercise2Window.minute == 6 && Excercise2Window.second >= 39 && Excercise2Window.second <= 44){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEP!");
						CountdownTimer.PlaySound(Beep);
						if (Excercise2Window.second == 45){
							CountdownTimer.PlaySound(Beep2);
						}
					} else {					
						if(Excercise2Window.second < 59){ //59
							Excercise2Window.second++;
							System.out.println("Seconds passed: " + Excercise2Window.second);
						} else {
							Excercise2Window.second = 0;
							if (Excercise2Window.minute < 59){ //59
								Excercise2Window.minute++;
								System.out.println("Minutes passed: " + Excercise2Window.minute);
								if (Excercise2Window.minute > 0){
//									CountdownTimer.PlaySound(Beep2);
								}
							}
						}
					}

				}
			}
		}, 1000, 1000);
	}
}
