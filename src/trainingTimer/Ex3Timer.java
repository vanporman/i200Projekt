package trainingTimer;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Ex3Timer {
	
	File Beep = new File("beep-07.wav");
	File Beep2 =new File("beep-01a.wav");
	Timer myTimer = new Timer();
	
	public void startTimerHr3(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
//				if (CountdownTimer.harjutus == 3){					
				if (StartPage.taimeriOlek == 2){
					myTimer.cancel();
				} else if (Excercise3Window.minute == 3 && Excercise3Window.second == 30){
					myTimer.cancel();
				} else if (Excercise3Window.minute == 0 && Excercise3Window.second >= 24 && Excercise3Window.second <= 28
						|| Excercise3Window.minute == 1 && Excercise3Window.second >= 24 && Excercise3Window.second <= 28
						|| Excercise3Window.minute == 1 && Excercise3Window.second >= 54 && Excercise3Window.second <= 58
						|| Excercise3Window.minute == 2 && Excercise3Window.second >= 54 && Excercise3Window.second <= 58
						|| Excercise3Window.minute == 3 && Excercise3Window.second >= 24 && Excercise3Window.second <= 28){
					Excercise3Window.second++;
					System.out.println(Excercise3Window.second + " BEEEP!");
					CountdownTimer.PlaySound(Beep);
				} else if (Excercise3Window.minute == 0 && Excercise3Window.second == 29
						|| Excercise3Window.minute == 1 && Excercise3Window.second == 29
						|| Excercise3Window.minute == 3 && Excercise3Window.second == 29){
					Excercise3Window.second++;
					System.out.println(Excercise3Window.second + " BEEEEEEP!");
					CountdownTimer.PlaySound(Beep2);
				} else {
					if (Excercise3Window.second < 59){
						Excercise3Window.second++;
						System.out.println("Seconds passed: " + Excercise3Window.second);
					} else {
						Excercise3Window.second = 0;
						if (Excercise3Window.minute < 59){
							Excercise3Window.minute++;
							System.out.println("Minutes " + Excercise3Window.minute);
							if (Excercise3Window.minute > 1){
								CountdownTimer.PlaySound(Beep2);
							}
						}
					}
				}
			}
//			}
		}, 1000, 1000);
	}
}
