package dk.iha.itsmap_handin2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReciever extends BroadcastReceiver{
	
	private static final String TAG = "MyBroadcastReciever";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "OnRecieve called - Broadcast Recieved");
		Intent i = new Intent(context, ActivityB.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("messageFromA", intent.getExtras().getString("messageToBeForwarded"));
		context.startActivity(i);
	}

}
