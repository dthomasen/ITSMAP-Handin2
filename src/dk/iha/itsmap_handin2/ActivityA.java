package dk.iha.itsmap_handin2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ActivityA extends Activity implements android.view.View.OnClickListener{

	private static final String TAG="ActivityA";
	private EditText textField;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitya);
        textField = (EditText) findViewById(R.id.secondsInput);
        View startAlarmButton = findViewById(R.id.startAlarmButton);
        Log.d(TAG, "OnCreate called");
        startAlarmButton.setOnClickListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activitya, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.startAlarmButton:
			Log.d(TAG,"Start alarm button clicked - Value of field: "+textField.getText().toString());
			Intent i = new Intent(this, AlarmService.class);
			i.putExtra("SecondsValue", textField.getText().toString());
			i.putExtra("messageToB", "This is Activity A speaking: Hello!");
			startService(i);
			break;
		}
	}
}
