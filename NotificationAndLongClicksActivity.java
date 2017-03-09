package ahmed.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotificationAndLongClicksActivity extends Activity {
    /** Called when the activity is first created. */
	
	OnClickListener btnclick = null;
	OnLongClickListener longclick = null;
	
	int sum = 0;
	String txt;
	EditText et;
	int current_base_num = 4;
	
	int btnid = R.id.button3;
	Button reportbtn;
	Button oldbtn;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnclick = new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Button b = (Button) v;
				sum = Integer.parseInt((String) b.getText()) + Integer.parseInt(String.valueOf(et.getText()));
				et.setText(sum + "");
			}
		};
        
		longclick = new OnLongClickListener() {
			
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				Button newbtn = (Button) v;
				
				Button oldBtn = (Button) findViewById(btnid);
				oldBtn.setTextColor(Color.BLACK);
				
				btnid = newbtn.getId();
				
				current_base_num = Integer.parseInt((String) newbtn.getText());
				newbtn.setTextColor(Color.RED);
				
				String mess = "Multiple of " + current_base_num + "?";
				reportbtn.setText(mess);
				return true;
			}
		
		};
		
		et = (EditText) findViewById(R.id.editText1);
		
        Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(btnclick);
		b1.setOnLongClickListener(longclick);
		
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(btnclick);
		b2.setOnLongClickListener(longclick);
		
		Button b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(btnclick);
		b3.setOnLongClickListener(longclick);
		
		Button b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(btnclick);
		b4.setOnLongClickListener(longclick);
		
		Button b5 = (Button) findViewById(R.id.button5);
		b5.setOnClickListener(btnclick);
		b5.setOnLongClickListener(longclick);
		
		Button b6 = (Button) findViewById(R.id.button6);
		b6.setOnClickListener(btnclick);
		b6.setOnLongClickListener(longclick);
		
		Button b7 = (Button) findViewById(R.id.button7);
		b7.setOnClickListener(btnclick);
		b7.setOnLongClickListener(longclick);
		
		Button b8 = (Button) findViewById(R.id.button8);
		b8.setOnClickListener(btnclick);
		b8.setOnLongClickListener(longclick);
		
		Button b9 = (Button) findViewById(R.id.button9);
		b9.setOnClickListener(btnclick);
		b9.setOnLongClickListener(longclick);
		
		reportbtn = (Button) findViewById(R.id.button10);
		reportbtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				txt = String.valueOf(et.getText());
				String message;
				int time;
				int num = Integer.parseInt(txt);
				
				if(num % current_base_num == 0 && num != 0){
					message = "Yes, " + sum + " is the multiple of " + current_base_num
					+ "\nProof is: " + num / current_base_num + " * " + current_base_num 
					+ " = " + num + ".";
					time = Toast.LENGTH_LONG;
				}else{
					message = "Sorry, " + num + " is not multiple of " + current_base_num;
					time = Toast.LENGTH_SHORT;
				}
				
				Toast.makeText(getApplicationContext(), message, time).show();
			}
		});
		
		Button b11 = (Button) findViewById(R.id.button11);
		b11.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				et.setText("0"); 
				current_base_num = 4;
				btnid = R.id.button3;
				reportbtn.setText("Multiple of " + current_base_num + "?");
			}
		});
		
    }
}