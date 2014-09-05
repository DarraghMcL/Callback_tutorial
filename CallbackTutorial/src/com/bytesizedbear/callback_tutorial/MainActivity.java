package com.bytesizedbear.callback_tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements
		MyFragment.MyInterface {
	
	TextView selectionText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.my_fragment, new MyFragment()).commit();
		}
		
		selectionText = (TextView) findViewById(R.id.selection_text);
		
		
	}
	

	// Methods indicating what happens when the fragment interface methods are
	// fired.
	// In this case we'll append the supplied string to the text view in the
	// activity.
	@Override
	public void pressTop(String top) {
		selectionText.setText(top);
	}

	@Override
	public void pressBottom(String bottom) {
		selectionText.setText(bottom);
	}

}
