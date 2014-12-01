package com.example.intuit;


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

public class CheckChoreActivity extends Activity {
	
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
	CheckBox chk5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_chores);
		context = getApplicationContext(); 
		chk1 = (CheckBox)findViewById(R.id.checkBox1);
		final CheckBox chk2 = (CheckBox)findViewById(R.id.checkBox2);
		final CheckBox chk3 = (CheckBox)findViewById(R.id.checkBox3);
		final CheckBox chk4 = (CheckBox)findViewById(R.id.checkBox4);
		chk5 = (CheckBox)findViewById(R.id.checkBox5);
//		chk1.setVisibility(0);
//		chk5.setVisibility(0);
		final CheckBox chk6 = (CheckBox)findViewById(R.id.checkBox6);						 
		
		chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   chk1.setClickable(false);
		    	   chk1.setEnabled(false);
		    	   String text = (chk1.getText().toString());
		    	   chk1.setText(text + "  - approved"); 
		       }
		   }
		); 
		
//		chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//		       @Override
//		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
//		    	   chk2.setClickable(false);
//		    	   chk2.setEnabled(false);
//		    	   String text = (chk2.getText().toString());
//		    	   chk2.setText(text + "  - approved"); 
//		       }
//		   }
//		); 
//		chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//		       @Override
//		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
//		    	   chk3.setClickable(false);
//		    	   chk3.setEnabled(false);
//		    	   String text = (chk3.getText().toString());
//		    	   chk3.setText(text + "  - approved"); 
//		       }
//		   }
//		); 
//		
//		chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//		       @Override
//		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
//		    	   chk4.setClickable(false);
//		    	   chk4.setEnabled(false);
//		    	   String text = (chk4.getText().toString());
//		    	   chk4.setText(text + "  - approved"); 
//		       }
//		   }
//		); 
		chk5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	  // chk5.setClickable(false);
		    	  // chk5.setEnabled(false);
		    	  // String text = (chk5.getText().toString());
		    	  // chk5.setText(text + "  - approved"); 
		       }
		   }
		); 
		
//		chk6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//		       @Override
//		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
//		    	   chk6.setClickable(false);
//		    	   chk6.setEnabled(false);
//		    	   String text = (chk6.getText().toString());
//		    	   chk6.setText(text + "  - approved"); 
//		       }
//		   }
//		); 
//		
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

        	CheckChoreActivity.this.mPos = pos;
        	CheckChoreActivity.this.mSelection = parent.getItemAtPosition(pos).toString();
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
    public void choreAssigned(View v){
    	Log.i("GOT HERE: ", "YAAP"); 
    
    	Log.i("GOT CONTEXT: ", "WORK PLEASE");
		//intent = new Intent(this.context, StartActivity.class);
    	chk1.setVisibility(2);
		chk5.setVisibility(2);
		Log.i("GOT INTENT: ", "WORK PLEASE");
		//startActivity(intent);        	
    }
}
