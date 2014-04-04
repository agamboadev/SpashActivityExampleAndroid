package com.example.splashactivityexample;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends Activity {
	
	// El tiempo que va a durar la pantalla splash (milisegundos)
	private long splashDelay = 4000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		TimerTask tTask = new TimerTask() {
			@Override
		    public void run() {
				Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
		        startActivity(mainIntent);
		        // Terminamos y eliminamos la activity
		        finish();
		    }
		};

		// Variable que servira como temporizador
		Timer timer = new Timer();
		// Una vez que han pasado los segundos definidos, se realiza la accion de run()
		timer.schedule(tTask, splashDelay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
