package winning.pwnies.recreativity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewSubmissionActivity extends Activity {

	private Submission submission;
	
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
		contentView.setContent(submission.getContent());
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

}
