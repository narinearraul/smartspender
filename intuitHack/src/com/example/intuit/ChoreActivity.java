package com.example.intuit;


import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.example.intuit.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ChoreActivity extends Activity {
	
    /**
     * Fields to contain the current position and display contents of the spinner
     */
    protected int mPos;
    protected String mSelection;
    Intent intent;
    Context context; 
    /**
     * ArrayAdapter connects the spinner widget to array-based data.
     */
    protected ArrayAdapter<CharSequence> mAdapter;
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;
    CheckBox chk4;
    CheckBox chk5;
    CheckBox chk6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chores);
		
		context = getApplicationContext(); 
		
		chk1 = (CheckBox)findViewById(R.id.checkBox1);
		chk2 = (CheckBox)findViewById(R.id.checkBox2);
		chk3 = (CheckBox)findViewById(R.id.checkBox3);
		chk4 = (CheckBox)findViewById(R.id.checkBox4);
		chk5 = (CheckBox)findViewById(R.id.checkBox5);
		chk6 = (CheckBox)findViewById(R.id.checkBox6);						 
		
		chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk1.setClickable(false);
		    	   chk1.setEnabled(false);
		    	   String text = (chk1.getText().toString());
		    	   chk1.setText(text); 
		       }
		   }
		); 
		
		chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk2.setClickable(false);
		    	   chk2.setEnabled(false);
		    	   String text = (chk2.getText().toString());
		    	   chk2.setText(text); 
		       }
		   }
		); 
		chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk3.setClickable(false);
		    	   chk3.setEnabled(false);
		    	   String text = (chk3.getText().toString());
		    	   chk3.setText(text); 
		       }
		   }
		); 
		
		chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk4.setClickable(false);
		    	   chk4.setEnabled(false);
		    	   String text = (chk4.getText().toString());
		    	   chk4.setText(text); 
		       }
		   }
		); 
		chk5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk5.setClickable(false);
		    	   chk5.setEnabled(false);
		    	   String text = (chk5.getText().toString());
		    	   chk5.setText(text); 
		       }
		   }
		); 
		
		chk6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk6.setClickable(false);
		    	   chk6.setEnabled(false);
		    	   String text = (chk6.getText().toString());
		    	   chk6.setText(text); 
		       }
		   }
		); 
    //    Spinner spinner = (Spinner) findViewById(R.id.Spinner01);

        /*
         * Create a backing mLocalAdapter for the Spinner from a list of the
         * planets. The list is defined by XML in the strings.xml file.
         */

      //  this.mAdapter = ArrayAdapter.createFromResource(this, R.array.bkg,
        //        android.R.layout.simple_spinner_dropdown_item);

        /*
         * Attach the mLocalAdapter to the spinner.
         */

      //  spinner.setAdapter(this.mAdapter);

        /*
         * Create a listener that is triggered when Android detects the
         * user has selected an item in the Spinner.
         */

        OnItemSelectedListener spinnerListener = new myOnItemSelectedListener(this,this.mAdapter);

        /*
         * Attach the listener to the Spinner.
         */

        //spinner.setOnItemSelectedListener(spinnerListener);


        /*
         * To demonstrate a failure in the preConditions test,
         * uncomment the following line.
         * The test will fail because the selection listener for the
         * Spinner is not set.
         */
         // spinner.setOnItemSelectedListener(null);

    }


    /**
     *  A callback listener that implements the
     *  {@link android.widget.AdapterView.OnItemSelectedListener} interface
     *  For views based on adapters, this interface defines the methods available
     *  when the user selects an item from the View.
     *
     */
    public class myOnItemSelectedListener implements OnItemSelectedListener {

        /*
         * provide local instances of the mLocalAdapter and the mLocalContext
         */

        ArrayAdapter<CharSequence> mLocalAdapter;
        Activity mLocalContext;

        /**
         *  Constructor
         *  @param c - The activity that displays the Spinner.
         *  @param ad - The Adapter view that
         *    controls the Spinner.
         *  Instantiate a new listener object.
         */
        public myOnItemSelectedListener(Activity c, ArrayAdapter<CharSequence> ad) {

          this.mLocalContext = c;
          this.mLocalAdapter = ad;

        }

        /**
         * When the user selects an item in the spinner, this method is invoked by the callback
         * chain. Android calls the item selected listener for the spinner, which invokes the
         * onItemSelected method.
         *
         * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(
         *  android.widget.AdapterView, android.view.View, int, long)
         * @param parent - the AdapterView for this listener
         * @param v - the View for this listener
         * @param pos - the 0-based position of the selection in the mLocalAdapter
         * @param row - the 0-based row number of the selection in the View
         */
        public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {

        	ChoreActivity.this.mPos = pos;
        	ChoreActivity.this.mSelection = parent.getItemAtPosition(pos).toString();
            /*
             * Set the value of the text field in the UI
             */
           // TextView resultText = (TextView)findViewById(R.id.SpinnerResult);
          //  resultText.setText(StoryActivity.this.mSelection);
        }

        /**
         * The definition of OnItemSelectedListener requires an override
         * of onNothingSelected(), even though this implementation does not use it.
         * @param parent - The View for this Listener
         */
        public void onNothingSelected(AdapterView<?> parent) {

            // do nothing

        }
        
      
    }
    public void findMatch(View v) throws ClientProtocolException, IOException{
    	Log.i("GOT HERE: ", "YAAP"); 
    	JSONObject obj = null; 
    	
    	ArrayList<String> toSend = new ArrayList<String>();
    	String finStr = "["; 
    	String name = "{\"name\":" ; 
    	String value = "{\"value\":" ; 
    	String status = "{\"status\":\"INCOMPLETE\"}" ; 
   	    String url =  "http://137.110.91.32:3000/api/parent/setChores"; 
    	Log.i("GOT CONTEXT: ", "WORK PLEASE");
    	if(chk1.isChecked()){
    		String temp1 = ((chk1.getText()).toString()); 
    		int i = temp1.indexOf('-');
    		String nameOfChore = temp1.substring(0, i);   	
    	    String valueOfChore = stripNonDigits(temp1);    		  
    		
    		temp1 = Arrays.toString(temp1.split("\\-"));
    		Log.i("TEMP1: ", temp1);
    		
    		String name1 =  name + ("\"" + nameOfChore + "\"}"); 
    		String value1 = value + ("\"" + valueOfChore + "\"}"); 
    		String fin1 = name1 + value1 + status; 
    		finStr += fin1; 
 
    		
    	}
    	if(chk2.isChecked()){
    		String temp2 = ((chk2.getText()).toString()); 
    		int i = temp2.indexOf('-');
    		String nameOfChore = temp2.substring(0, i);   	
    	    String valueOfChore = stripNonDigits(temp2);    		  
    		
    		temp2 = Arrays.toString(temp2.split("\\-"));
    		Log.i("TEMP2: ", temp2);
    		
    		name += ("\"" + nameOfChore + "\"}"); 
    		value += ("\"" + valueOfChore + "\"}"); 
    		String fin2 = name + value + status; 
    		finStr += fin2; 
    	}
    	if(chk3.isChecked()){
    		String temp3 = ((chk3.getText()).toString()); 
    		int i = temp3.indexOf('-');
    		String nameOfChore = temp3.substring(0, i);   	
    	    String valueOfChore = stripNonDigits(temp3);    		  
    		
    		temp3 = Arrays.toString(temp3.split("\\-"));
    		Log.i("TEMP3: ", temp3);
    		
    		String name3 = name + ("\"" + nameOfChore + "\"}"); 
    		String value3 = value + ("\"" + valueOfChore + "\"}"); 
    		String fin3 = name3 + value3 + status; 
    		finStr += fin3; 
    	}
    	if(chk4.isChecked()){
    		String temp4 = ((chk4.getText()).toString()); 
    		int i = temp4.indexOf('-');
    		String nameOfChore = temp4.substring(0, i);   	
    	    String valueOfChore = stripNonDigits(temp4);    		  
    		
    		temp4 = Arrays.toString(temp4.split("\\-"));
    		Log.i("TEMP4: ", temp4);
    		
    		String name4 = name + ("\"" + nameOfChore + "\"}"); 
    		String value4 = value + ("\"" + valueOfChore + "\"}"); 
    		String fin4 = name4 + value4 + status; 
    		finStr += fin4; 
    	}
    	if(chk5.isChecked()){
    		String temp5 = ((chk5.getText()).toString()); 
    		int i = temp5.indexOf('-');
    		String nameOfChore = temp5.substring(0, i);   	
    	    String valueOfChore = stripNonDigits(temp5);    		  
    		
    		temp5 = Arrays.toString(temp5.split("\\-"));
    		Log.i("TEMP5: ", temp5);
    		
    		String name5 = "," + name + ("\"" + nameOfChore + "\"}"); 
    		String value5 = value + ("\"" + valueOfChore + "\"}"); 
    		String fin5 = name5 + value5 + status; 
    		finStr += fin5;  
    	}
    	if(chk6.isChecked()){
    		String temp6 = ((chk6.getText()).toString()); 
    		int i = temp6.indexOf('-');
    		String nameOfChore = temp6.substring(0, i);   	
    	    String valueOfChore = stripNonDigits(temp6);    		  
    		
    		temp6 = Arrays.toString(temp6.split("\\-"));
    		Log.i("TEMP6: ", temp6);
    		
    		String name6 = name + ("\"" + nameOfChore + "\"}"); 
    		String value6 = value + ("\"" + valueOfChore + "\"}"); 
    		String fin6 = name6 + value6 + status; 
    		finStr += fin6;  
    	}
    	
    	finStr += "]";
    	Log.i("ARRAY IS: ", finStr);
//    	String rawData = "id=10";
//    	String type = "application/json";
//    	String encodedData = URLEncoder.encode( rawData ); 
//    	URL u = new URL(url);
//    	HttpURLConnection conn = (HttpURLConnection) u.openConnection();
//    	conn.setDoOutput(true);
//    	conn.setRequestMethod("POST");
//    	conn.setRequestProperty( "Content-Type", type );
//    	conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
//    	OutputStream os = conn.getOutputStream();
//    	os.write(encodedData.getBytes());
    
		intent = new Intent(this.context, CheckChoreActivity.class);
    //	postData(url);
		
		startActivity(intent);        	
    }
   
    
    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */){
    final StringBuilder sb = new StringBuilder(
            input.length() /* also inspired by seh's comment */);
    for(int i = 0; i < input.length(); i++){
        final char c = input.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
        }
    }
    return sb.toString();
}
}
