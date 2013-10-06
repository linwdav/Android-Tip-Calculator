package org.davidlin.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	final double TEN_PERCENT = 0.1;
	final double FIFTEEN_PERCENT = 0.15;
	final double TWENTY_PERCENT = 0.2;
	
	private EditText etTotalAmount;
	private TextView etTotalTip;
	private Button btTip10;
	private Button btTip15;
	private Button btTip20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		etTotalTip = (TextView) findViewById(R.id.tvTotalTip);
		btTip10 = (Button) findViewById(R.id.btTip10);
		btTip15 = (Button) findViewById(R.id.btTip15);
		btTip20 = (Button) findViewById(R.id.btTip20);
		
		btTip10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double totalAmount = Double.valueOf(etTotalAmount.getText().toString());
				double totalTip = totalAmount * TEN_PERCENT;
				DecimalFormat df = new DecimalFormat("#0.00");
				etTotalTip.setText("$" + String.valueOf(df.format(totalTip)));
			}
		});
		
		btTip15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double totalAmount = Double.valueOf(etTotalAmount.getText().toString());
				double totalTip = totalAmount * FIFTEEN_PERCENT;
				DecimalFormat df = new DecimalFormat("#0.00");
				etTotalTip.setText("$" + String.valueOf(df.format(totalTip)));
			}
		});
		
		btTip20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				double totalAmount = Double.valueOf(etTotalAmount.getText().toString());
				double totalTip = totalAmount * TWENTY_PERCENT;
				DecimalFormat df = new DecimalFormat("#0.00");
				etTotalTip.setText("$" + String.valueOf(df.format(totalTip)));
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
