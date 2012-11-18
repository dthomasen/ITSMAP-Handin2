package dk.iha.itsmap_handin2;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class AlarmService extends Service{

	private static final String TAG = "AlarmService";
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "OnBind called");
		return null;
	}

	public void onCreate(){
		Log.d(TAG, "OnCreate called");
		super.onCreate();
	}
	
	public void onDestroy(){
		Log.d(TAG, "OnDestroy called - Service killed");
		super.onDestroy();
	}
	
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.d(TAG, "Service started - Value: "+intent.getExtras().getString("SecondsValue"));
		
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, Integer.parseInt(intent.getExtras().getString("SecondsValue")));
        
        Intent broadcastIntent = new Intent(this, MyBroadcastReciever.class);
        broadcastIntent.putExtra("messageToBeForwarded", intent.getExtras().getString("messageToB"));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
        Toast.makeText(this, "Alarm set", Toast.LENGTH_LONG).show();

		return START_STICKY;
	}
}
