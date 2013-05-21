package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewSubmissionActivity extends Activity {

	private Submission submission;
	private boolean starred;
	private ImageButton starButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_submission);
		Intent intent = getIntent();
		submission = intent.getParcelableExtra("submission");
		
		ContentView contentView = (ContentView) findViewById(R.id.contentView);
		if (submission == null) {
			System.err.println("WHAT THE IS GOING ON HERE?");
		}
		
		starButton = (ImageButton)findViewById(R.id.starButton);
		starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
		starButton.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (starred) {					
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star2));
					starred = false;
				} else {
					starButton.setImageDrawable(getResources().getDrawable(R.drawable.star1));
					starred = true;
				}
			}
		});
		
		contentView.setContent(submission.getContent());
		
		starred = false;
	}
	
	public void viewNext(View view) {
		if (submission.hasNext()) {
			Intent intent = new Intent(this, ViewSubmissionActivity.class);
			intent.putExtra("submission", submission.next());
			startActivity(intent);
		}
	}
	
	public void viewPrev(View view) {
		if (submission.hasPrev()) {
			Intent intent = new Intent(this, ViewSubmissionActivity.class);
			intent.putExtra("submission", submission.prev());
			startActivity(intent);
		}
	}
	
	public void star_clicked(View view) {
		starred=true;
	}
}
