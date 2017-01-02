package trainingTimer;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Ex2Timer {
	File Beep = new File("beep-07.wav");
	File Beep2 =new File("beep-01a.wav"); 
	Timer myTimer = new Timer();
	
	public void startTimerHr2(){		
		myTimer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				if (CountdownTimer.harjutus == 2){
					if (StartPage.taimeriOlek == 2){ // Peatab taimeri kui vajutada stopp nuppu
						myTimer.cancel();
					} else if (Excercise2Window.minute == 6 && Excercise2Window.second == 45){ // Peatab taimeri kui aeg on t2is
						System.out.println("STOP");
						myTimer.cancel();
					} else if (Excercise2Window.minute == 1 && Excercise2Window.second >= 9 && Excercise2Window.second <= 13 // lyhikese signaali
							|| Excercise2Window.minute == 2 && Excercise2Window.second >= 39 && Excercise2Window.second <= 43 // vahemikud
							|| Excercise2Window.minute == 3 && Excercise2Window.second >= 54 && Excercise2Window.second <= 58
							|| Excercise2Window.minute == 5 && Excercise2Window.second >= 24 && Excercise2Window.second <= 28
							|| Excercise2Window.minute == 6 && Excercise2Window.second >= 39 && Excercise2Window.second <= 43){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEP!");
						CountdownTimer.PlaySound(Beep);
					} else if (Excercise2Window.minute == 1 && Excercise2Window.second == 14 // pika signaali vahemikud
							|| Excercise2Window.minute == 2 && Excercise2Window.second == 44
							|| Excercise2Window.minute == 5 && Excercise2Window.second == 29
							|| Excercise2Window.minute == 6 && Excercise2Window.second >= 44){
						Excercise2Window.second++;
						System.out.println(Excercise2Window.second + " BEEEEEEP!");
						CountdownTimer.PlaySound(Beep2);
					} else {					
						if(Excercise2Window.second < 59){ //59
							Excercise2Window.second++;
							System.out.println("Seconds passed: " + Excercise2Window.second);
						} else {
							Excercise2Window.second = 0;
							if (Excercise2Window.minute < 59){ //59
								Excercise2Window.minute++;
								System.out.println("Minutes passed: " + Excercise2Window.minute);
								if (Excercise2Window.minute == 4){
									CountdownTimer.PlaySound(Beep2);
								}
							}
						}
					}

				}
			}
		}, 1000, 1000);
	}
}
