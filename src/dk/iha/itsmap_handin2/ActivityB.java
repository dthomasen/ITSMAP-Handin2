package dk.iha.itsmap_handin2;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityB extends Activity{
	
	private static final String TAG = "ActivityB";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "OnCreate called");
        super.onCreate(savedInstanceState);
        stopService(new Intent(this, AlarmService.class));
        setContentView(R.layout.activityb);
        AudioManager audioManager = (AudioManager) getSystemService(ActivityB.AUDIO_SERVICE); 
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 10, 0);
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
        mp.start();
        TextView messageFromA = (TextView) findViewById(R.id.MessageFromA);
        messageFromA.setText(getIntent().getExtras().getString("messageFromA"));
    }
	
	   protected void onStart(){
		   super.onStart();
		   Log.d(TAG, "OnStart called");
	   }
	   
	   protected void onRestart(){
		   super.onRestart();
		   Log.d(TAG, "OnRestart called");
	   }

	   protected void onResume(){
		   super.onResume();
		   Log.d(TAG, "OnResume called");
	   }

	   protected void onPause(){
		   super.onPause();
		   Log.d(TAG, "OnPause called");
	   }

	   protected void onStop(){
		   super.onStop();
		   Log.d(TAG, "OnStop called");
	   }
	
}
