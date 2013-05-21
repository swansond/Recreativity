package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class PlayActivity extends Activity implements OnClickListener {
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	private GestureDetector gestureDetector;
	View.OnTouchListener gestureListener;

	private LinearLayout prompt;
	private LinearLayout compose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_play);	

		prompt = (LinearLayout) findViewById(R.id.prompt_fragment);

		compose = (LinearLayout) findViewById(R.id.compose_fragment);

		// Gesture detection
		gestureDetector = new GestureDetector(this, new MyGestureDetector());
		gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};

		ImageButton goCompose = (ImageButton) findViewById(R.id.imageButton1);
		goCompose.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				prompt.setVisibility(View.INVISIBLE);
				compose.setVisibility(View.VISIBLE);
			}
		});   

		Button goPrompt = (Button) findViewById(R.id.backToPrompt);
		goPrompt.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				compose.setVisibility(View.INVISIBLE);
				prompt.setVisibility(View.VISIBLE);
				getWindow().setSoftInputMode(
						WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			}
		});

		Button submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				// gets the text the user entered, not sure what to do with it
				EditText mEdit   = (EditText)findViewById(R.id.response); 
				String text = mEdit.getText().toString();
				Data.getFlow(1).addItem(new BasicSubmission(new TextContent(text), Data.getUser(1)));
				Intent intent = new Intent(getBaseContext(), ViewSubmissionActivity.class);
				intent.putExtra(Data.SUBMISSION, Data.getFlow(1).keyframe());
				intent.putExtra(Data.FLOW, Data.getFlow(1).serialNumber());
				startActivity(intent);
			}
		});
	}

	class MyGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			try {
				if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
					return false;
				// right to left swipe
				if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					prompt.setVisibility(View.INVISIBLE);
					compose.setVisibility(View.VISIBLE);
				}  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					compose.setVisibility(View.INVISIBLE);
					prompt.setVisibility(View.VISIBLE);
					getWindow().setSoftInputMode(
							WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
				}
			} catch (Exception e) {
				// nothing
			}
			return false;
		}

	}

	public void onClick(View v) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_explore:
			Data.goToExplore(this);
			break;
		case R.id.menu_play:
			Data.goToPlay(this);
			break;
		case R.id.menu_profile:
			Data.goToProfile(this);
			break;
		default:
			break;
		}
		return true;
	}
}