package com.alex.jniexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener{


	private static final String TAG = "DEBUG_TAG";

	EditText FiboInput,FactorialInput;
	TextView FiboOut,FactorialOut; 
	Button launch;
	RadioGroup fibo,factorial;



	int currentCheckedRBFac = 0;
	int currentCheckedRBFib = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		views();

	}


	public void views()
	{
		FiboInput = (EditText)findViewById(R.id.fibonacci_input);
		FactorialInput = (EditText)findViewById(R.id.factorial_input);

		FiboOut = (TextView)findViewById(R.id.fibonacci_result);
		FactorialOut = (TextView)findViewById(R.id.factorial_result);

		fibo = (RadioGroup) findViewById(R.id.rdgGroupFib);
		factorial = (RadioGroup) findViewById(R.id.rdgGrupo);

		launch = (Button)findViewById(R.id.bt_launch);

		fibo.setOnCheckedChangeListener(this);
		factorial.setOnCheckedChangeListener(this);
		launch.setOnClickListener(this);

		currentCheckedRBFib = fibo.getCheckedRadioButtonId();
		currentCheckedRBFac = factorial.getCheckedRadioButtonId();

	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		if(group.getId()==R.id.rdgGrupo){
			currentCheckedRBFac = checkedId;
			Log.i(TAG,"RadioButton changed in factorial RG");
		}else if (group.getId()==R.id.rdgGroupFib){
			currentCheckedRBFib = checkedId;
			Log.i(TAG,"RadioButton changed in fibonacci  RG");
		}
	}


	@Override
	public void onClick(View v) {

		Log.i(TAG,"Get factorial and fibonacci results");

		if(!FiboInput.getText().toString().isEmpty()){

			try{
				long result = 0;
				long a = Long.parseLong(FiboInput.getText().toString());
				long t1 = 0  ,t2 = 0;

				switch(currentCheckedRBFib){

				case R.id.rdbRNFib:
					/* recursive native fibonacci*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.fibRNative(a);
					t2 = System.currentTimeMillis();

					break;

				case R.id.rdbRJFib:
					/* recursive java fibonacci*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.fibR(a);
					t2 = System.currentTimeMillis();
					break;

				case R.id.rdbINFib:
					/* iterative native fibonacci*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.fibINative(a);
					t2 = System.currentTimeMillis();
					break;

				case R.id.rdbIJFib:

					/* iterative java fibonacci*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.fibI(a);
					t2 = System.currentTimeMillis();
					break;
				}

				FiboOut.setText(result+" (delivered in "+(t2-t1)+" ms)");
				Log.i(TAG,result+" (delivered in "+(t2-t1)+" ms)");
			}catch(NumberFormatException e){

				Toast.makeText(this, "Invalid imput for Fibonacci!", Toast.LENGTH_LONG).show();

			}catch (Exception e){

				Log.e("ERROR","Unknown Error!");
				e.printStackTrace();
			}

		}

		if(!FactorialInput.getText().toString().isEmpty()){
			try{
				long result = 0;
				long a = Long.parseLong(FactorialInput.getText().toString());
				long t1 = 0  ,t2 = 0;

				switch(currentCheckedRBFac){

				case R.id.rdbRNF:
					/* recursive native factorial*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.factRN(a);
					t2 = System.currentTimeMillis();

					break;

				case R.id.rdbRJF:
					/* recursive java factorial*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.factR(a);
					t2 = System.currentTimeMillis();
					break;

				case R.id.rdbINF:
					/* iterative native factorial*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.factIN(a);
					t2 = System.currentTimeMillis();
					break;

				case R.id.rdbIJF:

					/* iterative java factorial*/
					t1 = System.currentTimeMillis();
					result = MathNativeLib.factI(a);
					t2 = System.currentTimeMillis();
					break;
				}

				FactorialOut.setText(result+" (delivered in "+(t2-t1)+" ms)");
				Log.i(TAG,result+" (delivered in "+(t2-t1)+" ms)");
			}catch(NumberFormatException e){

				Toast.makeText(this, "Invalid imput for Factorial!", Toast.LENGTH_LONG).show();

			}catch (Exception e) {

				Log.e("ERROR","Unknown Error!");
				e.printStackTrace();

			}

		}

	}





}
