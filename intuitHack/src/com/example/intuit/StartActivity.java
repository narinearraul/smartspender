package com.example.intuit;

import com.example.intuit.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class StartActivity extends Activity {

	
	Intent intentP, intentC; 
	Context context; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		context = getApplicationContext();
	}
	
	 public void searchMatches(View v){
	    	
	    	context = getApplicationContext(); 
	    	Log.i("GOT CONTEXT: ", "WORK PLEASE");
			//intent = new Intent(this.context, ConnectActivity.class);
	    	Log.i("GOT INTENT: ", "WORK PLEASE");
			//startActivity(intent);        	
	    }
	
	 
	 public void parentIN(View v){
		 Log.i("PARENT: ", " Logged in"); 
		 intentP = new Intent(context, ChoreActivity.class);
		 startActivity(intentP);    
	 }
	 
	 public void childIN(View v){
		 Log.i("CHILD: ", " Logged in"); 
		 intentC = new Intent(context, RequestItemActivity.class);
		 startActivity(intentC);    
	 }
}
