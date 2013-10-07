package org.davidlin.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

	final double TEN_PERCENT = 0.1;
	final double FIFTEEN_PERCENT = 0.15;
	final double TWENTY_PERCENT = 0.2;

	private EditText etTotalAmount;
	private TextView etTotalTip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		etTotalTip = (TextView) findViewById(R.id.tvTotalTip);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Calculate and display tip.
	 * @param view	Clicked button
	 */
	public void calculateTip(View view) {
		double tipPercentage = 0.0;

		// Set tip percentage based on button pressed
		if (view.getId() == R.id.btTip10) {
			tipPercentage = TEN_PERCENT;
		} else if (view.getId() == R.id.btTip15) {
			tipPercentage = FIFTEEN_PERCENT;
		} else if (view.getId() == R.id.btTip20) {
			tipPercentage = TWENTY_PERCENT;
		}

		// Update tip text view
		try {
			double totalAmount = Double.valueOf(etTotalAmount.getText().toString());
			double totalTip = totalAmount * tipPercentage;
			DecimalFormat df = new DecimalFormat("#0.00");
			etTotalTip.setText("$" + String.valueOf(df.format(totalTip)));
		} catch (NumberFormatException ex) {
			Toast.makeText(getApplicationContext(), "Please enter a valid amount", Toast.LENGTH_SHORT).show();
		}
	}

}
