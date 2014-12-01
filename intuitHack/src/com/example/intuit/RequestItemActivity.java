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
import android.widget.Button;


public class RequestItemActivity extends Activity {
	
	public Intent intent;
	public Context context; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_request_item);
		context = getApplicationContext(); 
	}
	public void sentRequest(View v){
		//Button request = (Button)(findViewById(R.id.confirm)); 
		//request.setText("Request sent!");
		intent = new Intent(context, GetChoreActivity.class);
		startActivity(intent);    
	}
}
