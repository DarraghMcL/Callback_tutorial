package com.bytesizedbear.callback_tutorial;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends Fragment {

	// Creating the interface containing the callback methods
	public interface MyInterface {

		public void pressTop(String top);
		public void pressBottom(String bottom);
	}

	// Creating an object representing the interface
	MyInterface myInterface;

	// Button objects to be used by the fragment
	Button topButton, bottomButton;

	// Strings that we'll pass through the callback methods
	static final String TOP = "TOP", BOTTOM = "BOTTOM";

	/**
	 * When the fragment is attached to the main activity we need to grab a
	 * reference to the activity and attach it to our interface. This tells the
	 * code where the method call will be going to.
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		myInterface = (MyInterface) activity;

	}

	// Standard onCreateView method sets up the fragment and indicates which
	// layout to use
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);

		// Setting up the buttons
		topButton = (Button) rootView.findViewById(R.id.topButton);
		bottomButton = (Button) rootView.findViewById(R.id.bottomButton);

		// On the onClickListener for each button, fire the interface methods
		// and pass in strings as the parameters
		topButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				myInterface.pressTop(TOP);	
			}
			
		});
		
		bottomButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				myInterface.pressBottom(BOTTOM);
			}
			
		});

		return rootView;
	}

}
